package com.example.demo.control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.service.CourseService;
import com.example.demo.service.UserService;
import com.example.demo.service.MateService;
import com.example.demo.service.UsertoMateService;
import com.example.demo.service.MatetoCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Value;
import com.sun.javafx.collections.MappingChange.Map;
@Controller
public class UserControll {
	@Autowired
	CourseService courservice;
	@Autowired
	UserService userservice;
	@Autowired
	UsertoMateService usertomateservice;
	@Autowired
	MateService imate;
	@Autowired
	MatetoCourseService iMatetoCourse;


    //管理员登录检查
	@RequestMapping(value = "syslogin")
	public String syslogin(HttpServletRequest request,@RequestParam("name") String name,@RequestParam("password")  String password) {
     System.out.println(name+"-"+password);
      if("sys".equals(name)&&"sys".equals(password)){
       request.getSession().setAttribute("loginUser",name);
		  return "redirect:/index.html";
	  }else{
		  return "redirect:/login.html";
	  }

	}

     //退出登录
	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("loginUser");
		return "redirect:/login.html";
	}

	@ResponseBody
	@RequestMapping(value = "jsp/selectper")
	public List<User> selectPers() {
		List<User> pers = userservice.selectPers();
		return pers;
	}

	// 查询没用分配班级的user
	@ResponseBody
	@RequestMapping(value = "jsp/selectUserInfo")
	public List<User> selectUserInfo() {
		List<User> pers = userservice.selectUserInfo();
		return pers;
	}
	@RequestMapping(value = {"sys","office","doctor","circle","record","index"})
	public String sys(HttpServletRequest hsr) {
		String path=hsr.getServletPath();
		System.out.println(path);
		return path;
	}

	@ResponseBody
	@RequestMapping(value = "jsp/updateinfo")
	public String updateInfo(User user) {
		userservice.updateInfo(user);
		return "1";
	}

	// 把人添加的唯一的学号添加到user_mate表中，在完善user_new表的信息
	// 通过mateid查询信息，在插入到user_new表中
	@RequestMapping(value = "jsp/addPertoMate")
	public String addPertoMate(@RequestParam(value = "ids", required = false) String ids) {
		String[] split = ids.substring(1, ids.length() - 1).split(",");
		// 第一个为班级id，后面为userid
		List<UsertoMate> UsertoMates = new ArrayList<UsertoMate>();
		List<User> Users = new ArrayList<User>();
		Mate mate = imate.selectMtInfoByMateid(Integer.parseInt(split[0].substring(1, split[0].length() - 1)));
		for (int i = 1; i < split.length; i++) {
			UsertoMate UsertoMate = new UsertoMate(Integer.parseInt(split[0].substring(1, split[0].length() - 1)),
					split[i].substring(1, split[i].length() - 1));
			// String id, String mate, String zy, String school
			User user = new User(split[i].substring(1, split[i].length() - 1), mate.getBjh(), mate.getZy(),
					mate.getSchool());
			Users.add(user);
			UsertoMates.add(UsertoMate);
		}
		usertomateservice.insertUsertoMate(UsertoMates);
		userservice.commpleteUserInfo(Users);
		return "mateinfo.html";
	}

	// 将学生从班级中删除
	// 先将mate_user中的学号删除mateid和userid
	// 在update表user_new的数据school,zy,bj
	@RequestMapping(value = "jsp/deletePertoMate")
	public String deletePertoMate(@RequestParam(value = "ids", required = false) String ids) {
		String[] split = ids.substring(1, ids.length() - 1).split(",");
		// 第一个为班级id，后面为userid
		List<String> userid = new ArrayList<String>();
		int mateid = Integer.parseInt(split[0].substring(1, split[0].length() - 1));
		for (int i = 1; i < split.length; i++) {
			userid.add(split[i].substring(1, split[i].length() - 1));
		}
		usertomateservice.deleteUsertoMate(mateid, userid);
		userservice.updateUserInfo(userid);
		return "mateinfo.html";
	}

	@ResponseBody
	@RequestMapping(value = "jsp/selectMateInfo")
	// SELECT un.* FROM mate_user mu,user_new un where mu.userid=un.id and
	// mu.mateid=4;
	public List<User> selectMateInfo(@RequestParam int mateid) {
		List<User> users = userservice.selectMateInfo(mateid);
		return users;
	}
     //创建的课程添加到course表，并且获取到courseid
	//通过school，zy，bjh查询符合条件的mateid
	//将mateid和courseid插入到mate_course表中
	@RequestMapping(value = "jsp/tjCourse")
	public String tjCourse(@RequestBody Course course) {
		if("".equals(course.getSchool())||"请选择".equals(course.getSchool())||null==course.getSchool()) {
			course.setSchool("");
		}
		if("".equals(course.getZy())||"请选择".equals(course.getZy())||null==course.getZy()) {
			course.setZy("");
		}
		if("".equals(course.getBj())||"请选择".equals(course.getBj())||null==course.getBj()) {
			course.setBj("");
		}
		//
		Integer courseid = courservice.addCourse(course);
		//查询满足条件的mateid
		//String school, String bjh, String zy
		Mate mate=new Mate(course.getSchool(),course.getBj(),course.getZy());
		List<Integer> mateid = imate.selectMateIdByMate(mate);
		//查询出满足条件的mateid后，将mateid和courseid插入到表mate_course中
		iMatetoCourse.insertMateidCourseid(courseid,mateid);
		return "less.html";
	}

	@ResponseBody
	@RequestMapping(value ="jsp/selectCourse")
	public List<Course> selectCourse() {
		return courservice.selectCourse();
	}
	//查詢班級裡面的課程
	@ResponseBody
	@RequestMapping(value ="jsp/selectMateCourse")
	public List<Course_teacher> selectMateCourse(@RequestParam int mateid) {
		return courservice.selectMateCourse(mateid);
	}
}
// @RequestMapping(value ="jsp/Login")
// public String login(@RequestParam int id,@RequestParam String
// password,HttpServletRequest request) {
//		User user=new User(id,password);
//		User isuser = userservice.selectUserBy(user);
//		if(isuser!=null) {
//			request.getSession().setAttribute("user", isuser);
//			return "redirect:home.jsp";
//		}else {
//			return "redirect:index.html";
//		}
//	}
//}

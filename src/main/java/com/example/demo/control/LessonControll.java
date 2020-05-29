package com.example.demo.control;

import com.example.demo.entity.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@SessionAttributes(value = { "lesson", "works" })
public class LessonControll {
	//public int Lessonid = 0;// 保存课程的id
	@Autowired
	CourseService icourse;
	@Autowired
	UserService iuser;
	@Autowired
	UsertoMateService iUsertoMate;
	@Autowired
	MateService imate;
	@Autowired
	MatetoCourseService iMatetoCourse;
//		User user = (User) session.getAttribute("user");
//		lesson.setTeachername(user.getUsername());
//		int image = (int) (Math.random() * 6) + 1;
//		String image2 = image + "";
//		lesson.setImageurl(image2);
//		ilesson.insertLesson(lesson);
//		return "redirect:home.jsp";
//	}
//
//	@ResponseBody
//	@RequestMapping("jsp/selectLesson") // 进入home.jsp时查询lessons数据
//	public List<Lesson> selectLesson(HttpSession session) {
//		User user = (User) session.getAttribute("user");
//		ArrayList<Lesson> lessons = null;
//		if (user.getRole().equals("teacher")) {
//			lessons = (ArrayList<Lesson>) ilesson.selectLesson(user.getUsername());
//		} else {
//			lessons = (ArrayList<Lesson>) ilesson.selectLessonByStudentname(user.getUsername());
//		}
//		return lessons;
//	}
//
//	@RequestMapping("jsp/Handlehref")
//	public String Handlehref(@RequestParam int id, Map<String, Lesson> ma) {
//		Lesson lesson = ilesson.selectLessonById(id);
//		Lessonid = lesson.getId();
//		ma.put("lesson", lesson);
//		return "redirect:lesson.jsp";
//	}

//	@SuppressWarnings({ "null" })
//	@ResponseBody
//	@RequestMapping("jsp/selectWork") // 查询老师自己发布的作业,同时如果角色是学生时查询学生。
//	public List<Work> selectWork(HttpSession session, Map<String, Object> ma) {
//		User user = (User) session.getAttribute("user");
//		List<Work> works = null;
//		Work work = new Work(Lessonid, user.getUsername());
//		// 老师
//		if (user.getRole().equals("teacher")) {
//			works = iwork.selectWork(work);
//		}
//		// 学生没有数据
//		/*
//		 * else if(works.size()==0&&user.getRole().equals("student")) { Work work22=new
//		 * Work(); work22.setIsStudent(3); //works为null NullPointerException
//		 * works.add(work22); //学生有数据 }
//		 */
//		else if (user.getRole().equals("student")) {
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("studentname", user.getUsername());
//			map.put("lessonid", Lessonid);
//			List<Work> Student_works = StudentInsertWork.selectWorksByStudentnameAndLessonid(map);
//			Student_works.get(0).setIsStudent(1);
//			works = Student_works;
//		}
//		return works;
//	}

//	// 处理下添加作业，需要teachername,作业所属的课程workname,content,time
//	@SuppressWarnings("unchecked")
//	@RequestMapping("jsp/addWork")
//	public String addWork(@RequestParam String workname, @RequestParam String content, @RequestParam String time,
//			HttpSession session) throws ParseException {
//		String teachername = ((User) session.getAttribute("user")).getUsername();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String begindate = sdf.format(new Date());
//		Date begintime = sdf.parse(begindate);
//		Calendar ca = Calendar.getInstance();
//		ca.setTime(begintime);
//		int day = Integer.parseInt(time);
//		ca.add(Calendar.DATE, day);
//		Date endtime = ca.getTime();
//		String enddate = sdf.format(endtime);
//		List<String> Studentnames = StudentInsertlesson.selectStudentLessonByLessonid(Lessonid);
//		// String teachername, int lessonid, String workname, String begintime, String
//		// endtime, String content
//		Work work = new Work(teachername, Lessonid, workname, begindate, enddate, content);
	//	Integer i = iwork.insertWork(work);
//		for (String name : Studentnames) {
//			// 查询到添加了lessonid的学生后将这些学生添加到student_work表中
//			Work everyStudentwork = new Work(Lessonid, name, work.getId(), workname, enddate, "无", "未提交", "0");
//			StudentInsertWork.insertWorks(everyStudentwork);
//		}
//		return "redirect:work.jsp";
//	}

//	@ResponseBody
//	@RequestMapping("jsp/searchLesson") // 接收到后模糊查询
//	public List<Lesson> searchLesson(@RequestParam String searchMsg) {
//		List<Lesson> lessons = ilesson.selectLessonBySearchMsg(searchMsg);
//		return lessons;
//	}

//	@SuppressWarnings("finally")
//	@RequestMapping("jsp/addLesson") // 学生添加课程，添加课程的同时将课程下的作业添加进去
//	// 通过lessonid可以到work表中查到workid,workname,endtime
//	public String addLesson(@RequestParam int lessonid, HttpSession session) {
//		String studentname = ((User) session.getAttribute("user")).getUsername();
//		List<Work> works = iwork.selectWorkBylessonId(lessonid);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("studentname", studentname);
//		map.put("lessonid", lessonid);
//		try {
////int lessonid, String studentname, int workid, String workname, String endtime,String committime, String status, String percent
//			StudentInsertlesson.StudentInsertLesson(map);
//			for (Work work : works) {
//				Work Student_Work = new Work(lessonid, studentname, work.getId(), work.getWorkname(), work.getEndtime(),
//						"无", "未提交", "0");
//				StudentInsertWork.insertWorks(Student_Work);
//			}
//		} catch (Exception e) {
//		} finally {
//			return "redirect:home.jsp";
//		}
//	}

//	// 处理文件的上传,文件上传需要得到文件名，用户名,作业id,提交时间
//	// 更新student_work表中的数据,通过用户名和作业id更新
//	@RequestMapping(value = "jsp/fileUpLoad")
//	public String testUpload(HttpSession session, @RequestParam("workid") int workid,
//			@RequestParam("file") CommonsMultipartFile file) throws Exception {
//		if (file.getSize() == 0) {
//			return "redirect:work.jsp";
//		}
//		User user = (User) session.getAttribute("user");
//		String username = user.getUsername();
//		String path = System.getProperty("catalina.home");
//		path = path + "\\" + "homework";
//		File file1 = new File(path);
//		if (!file1.exists()) {
//			file1.mkdir(); // 如果该目录不存在，就创建此抽象路径名指定的目录。
//		}
//		String prefix = UUID.randomUUID().toString();
//		prefix = prefix.replace("-", "");
//		String fileName = prefix + "_" + file.getOriginalFilename();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String committime = sdf.format(new Date());
//		InputStream in = file.getInputStream();
//		;// 声明输入输出流
//		OutputStream out = new FileOutputStream(new File(path + "\\" + fileName));// 指定输出流的位置;
//		byte[] buffer = new byte[1024];
//		int len = -1;
//		while ((len = in.read(buffer)) != -1) {
//			out.write(buffer, 0, len);
//			out.flush(); // 类似于文件复制，将文件存储到输入流，再通过输出流写入到上传位置
//		} // 这段代码也可以用IOUtils.copy(in, out)工具类的copy方法完成
//		out.close();
//		in.close();
//		Work work = new Work(committime, username, "已提交", fileName, workid);
//		StudentInsertWork.updateWorkUpload(work);
//		return "redirect:work.jsp";
//	}

	// 处理文件的下载
	@RequestMapping("jsp/fileDownLoad")
	public ResponseEntity<byte[]> fileDownLoad(HttpServletRequest request, @RequestParam("filename") String filename)
			throws Exception {
		String path = System.getProperty("catalina.home");
		path = path + "\\" + "homework";
		InputStream in = new FileInputStream(new File(path + "\\" + filename));// 将该文件加入到输入流之中
		byte[] body = null;
		body = new byte[in.available()];// 返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取（或跳过）的估计剩余字节数
		in.read(body);// 读入到输入流里面
		filename = new String(filename.getBytes("gbk"), "iso8859-1");// 防止中文乱码
		HttpHeaders headers = new HttpHeaders();// 设置响应头
		headers.add("Content-Disposition", "attachment;filename=" + filename);
		HttpStatus statusCode = HttpStatus.OK;// 设置响应吗
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);
		return response;
	}

//	@ResponseBody
//	@RequestMapping("jsp/getCommitStudentList")
//	public List<Work> getCommitStudentList(@RequestParam int workid) {
//		List<Work> works = StudentInsertWork.selectCommitStudentList(workid);
//		return works;
//	}
//
//	@ResponseBody
//	@RequestMapping("jsp/postPercent")
//	public String postPercent(@RequestParam int primaryid, @RequestParam String percent) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", primaryid);
//		map.put("percent", percent);
//		StudentInsertWork.updatePercent(map);
//		return null;
//	}
	//添加班级
	@RequestMapping("jsp/addbj")
	public String addClass(Mate mate) {
		//先查询班级是否存在
		//学校,专业，班级号
		Mate selectBJCZ = imate.selectBJCZ(mate);
		if(selectBJCZ!=null) {
			return "mate.html";
		}
		if(mate.isblank()) 
			return "mate.html";
		//不为空插入数据
		imate.addMate(mate);
		return "mate.html";
	}
	//查询班级
	@ResponseBody
	@RequestMapping("jsp/selectbj")
	public List<Mate> selectbj() {
		List<Mate> mates = imate.seletMate();
		return mates;
	}
	@RequestMapping(value = "jsp/selectMtInfo")
	public String selectMtInfo(@RequestParam Integer id) {
		imate.selectMtInfoByMateid(id);
		return "1";
	}
}

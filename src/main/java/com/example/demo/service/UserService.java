package com.example.demo.service;

import com.example.demo.mapper.IUser;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    IUser iuser;
    //通过登录账号查询用户
  public  User selectUser(String id){
      return  iuser.selectUser(id);
    }
    public void insertUser(User user){
        iuser.insertUser(user);
    }
    public User selectUserBy(User user){
        return iuser.selectUserBy(user);
    }
    //查询所有的人
    public   List<User> selectPers(){
        return iuser.selectPers();
    }
    public void updateInfo(User user){
        iuser.updateInfo(user);
    }
    //查询没用分配班级的user
    public List<User> selectUserInfo(){
        return iuser.selectUserInfo();
    }
    //通过mateid查找这个班级的人
    public List<User> selectMateInfo(int mateid){
        return iuser.selectMateInfo(mateid);
    }
    //批处理完善信息
    public void commpleteUserInfo(List<User> UsertoMate){
        iuser.commpleteUserInfo(UsertoMate);
    }

    public void updateUserInfo(List<String> userid){
        iuser.updateUserInfo(userid);
    }
}

package com.example.demo.mapper;


import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.entity.UsertoMate;
import org.springframework.stereotype.Repository;

@Repository
public interface IUser {
	//通过登录账号查询用户
  User selectUser(String id);
  void insertUser(User user);
  User selectUserBy(User user);
  //查询所有的人
  List<User> selectPers();
  void updateInfo(User user);
  //查询没用分配班级的user
  List<User> selectUserInfo();
  //通过mateid查找这个班级的人
  List<User> selectMateInfo(int mateid);
  //批处理完善信息
  void commpleteUserInfo(List<User> UsertoMate);
  
void updateUserInfo(List<String> userid);
}
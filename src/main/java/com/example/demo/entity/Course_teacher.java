package com.example.demo.entity;

public class Course_teacher {
 private String name;
 private String userid;
 private String school;
 private String zy;
 private String bj;
public String getName() {
	return name;
}
public Course_teacher(String name, String userid, String school, String zy, String bj) {
	super();
	this.name = name;
	this.userid = userid;
	this.school = school;
	this.zy = zy;
	this.bj = bj;
}
public Course_teacher() {
	super();
	// TODO Auto-generated constructor stub
}
public void setName(String name) {
	this.name = name;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getSchool() {
	return school;
}
public void setSchool(String school) {
	this.school = school;
}
public String getZy() {
	return zy;
}
public void setZy(String zy) {
	this.zy = zy;
}
public String getBj() {
	return bj;
}
public void setBj(String bj) {
	this.bj = bj;
}
}

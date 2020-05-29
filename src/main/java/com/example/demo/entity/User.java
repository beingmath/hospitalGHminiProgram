package com.example.demo.entity;

public class User {
public User(String id, String mate, String zy, String school) {
		super();
		this.id = id;
		this.mate = mate;
		this.zy = zy;
		this.school = school;
	}
private String id;//学号
private String name;
public User(String id, String role, String pw) {
	super();
	this.id = id;
	this.role = role;
	this.pw = pw;
}
private String role;
private String pw;
private String mate;//班级
private String zy;//专业
public String getId() {
	return id;
}
public User(String id, String pw){
	super();
	this.id = id;
	this.pw = pw;
}
public User() {
	super();
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public User(String id, String name, String role, String pw, String mate, String zy, String school) {
	super();
	this.id = id;
	this.name = name;
	this.role = role;
	this.pw = pw;
	this.mate = mate;
	this.zy = zy;
	this.school = school;
}
public User(String id, String name, String pw, String mate, String zy, String school) {
	super();
	this.id = id;
	this.name = name;
	this.pw = pw;
	this.mate = mate;
	this.zy = zy;
	this.school = school;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPw() {
	return pw;
}
public void setPw(String pw) {
	this.pw = pw;
}
public String getMate() {
	return mate;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", role=" + role + ", pw=" + pw + ", mate=" + mate + ", zy=" + zy
			+ ", school=" + school + "]";
}
public void setMate(String mate) {
	this.mate = mate;
}
public String getZy() {
	return zy;
}
public void setZy(String zy) {
	this.zy = zy;
}
public String getSchool() {
	return school;
}
public void setSchool(String school) {
	this.school = school;
}
private String school;//学校
}

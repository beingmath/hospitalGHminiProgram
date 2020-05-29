package com.example.demo.entity;

public class Course {
private int id;
private String school;
 private String name;
 private String bj;
private String zy;
 private String descri;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSchool() {
	return school;
}
public void setSchool(String school) {
	this.school = school;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBj() {
	return bj;
}
public void setBj(String bj) {
	this.bj = bj;
}
public String getZy() {
	return zy;
}
public void setZy(String zy) {  
	this.zy = zy;
}
public String getDescri() {
	return descri;
}
public void setDescri(String descri) {
	this.descri = descri;
}
public Course(int id, String school, String name, String bj, String zy, String descri) {
	super();
	this.id = id;
	this.school = school;
	this.name = name;
	this.bj = bj;
	this.zy = zy;
	this.descri = descri;
}
public Course(String school, String name, String bj, String zy, String descri) {
	super();
	this.school = school;
	this.name = name;
	this.bj = bj;
	this.zy = zy;
	this.descri = descri;
}
public Course() {
	super();
}
@Override
public String toString() {
	return "Course [id=" + id + ", school=" + school + ", name=" + name + ", bj=" + bj + ", zy=" + zy + ", descri="
			+ descri + "]";
}
}
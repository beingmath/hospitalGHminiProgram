package com.example.demo.entity;

public class UsertoMate {
private int mateid;
private String userid;
public UsertoMate(int mateid, String userid) {
	super();
	this.mateid = mateid;
	this.userid = userid;
}
public int getMateid() {
	return mateid;
}
public void setMateid(int mateid) {
	this.mateid = mateid;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
}

package com.example.demo.entity;
public class Work{
public Work(int lessonid,String teachername) {
		super();
		this.teachername = teachername;
		this.lessonid = lessonid;
	}
public Work() {
		super();
		// TODO Auto-generated constructor stub
	}
public Work(String committime,String username,String status,String filename,int workid) {
	this.committime=committime;
	this.studentname=username;
	this.status=status;
	this.filename=filename;
	this.id=workid;
}
private String filename;
public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
private String studentname;
private int primary_id;//代表student_Work表的主键id
public int getPrimary_id() {
	return primary_id;
}
public void setPrimary_id(int primary_id) {
	this.primary_id = primary_id;
}
private int id;//代表的是workid就是work表中的id主键
private int isStudent=0;//当isStudent为1时为学生有数值，0时为teacher.3表示student并且没有值
public int getIsStudent() {
	return isStudent;
}
public void setIsStudent(int isStudent) {
	this.isStudent = isStudent;
}
private String status;
private String percent;
//lessonid,studentname,work.getId(),work.getWorkname(),work.getEndtime(),"无","未提交","0"
public Work(String studentname, int isStudent, String status, String percent, String committime, String teachername,
		int lessonid, String workname, String begintime, String endtime, String content) {
	super();
	this.studentname = studentname;
	this.isStudent = isStudent;
	this.status = status;
	this.percent = percent;
	this.committime = committime;
	this.teachername = teachername;
	this.lessonid = lessonid;
	this.workname = workname;
	this.begintime = begintime;
	this.endtime = endtime;
	this.content = content;
}
public Work(int lessonid, String studentname,int id, String workname, String endtime, String committime, String status,
		String percent) {
	super();
	this.id=id;
	this.lessonid = lessonid;
	this.studentname = studentname;
	this.workname = workname;
	this.endtime = endtime;
	this.committime = committime;
	this.status = status;
	this.percent = percent;
}
public Work(String studentname, int id, int isStudent, String status, String percent, String committime,
		String teachername, int lessonid, String workname, String begintime, String endtime, String content) {
	super();
	this.studentname = studentname;
	this.id = id;
	this.isStudent = isStudent;
	this.status = status;
	this.percent = percent;
	this.committime = committime;
	this.teachername = teachername;
	this.lessonid = lessonid;
	this.workname = workname;
	this.begintime = begintime;
	this.endtime = endtime;
	this.content = content;
}
@Override
public String toString() {
	return "Work [studentname=" + studentname + ", primary_id=" + primary_id + ", id=" + id + ", isStudent=" + isStudent
			+ ", status=" + status + ", percent=" + percent + ", committime=" + committime + ", teachername="
			+ teachername + ", lessonid=" + lessonid + ",filename=" + filename + ", workname=" + workname + ", begintime=" + begintime
			+ ", endtime=" + endtime + ", content=" + content + "]";
}
public String getStudentname() {
	return studentname;
}
public void setStudentname(String studentname) {
	this.studentname = studentname;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getPercent() {
	return percent;
}
public void setPercent(String percent) {
	this.percent = percent;
}
public String getCommittime() {
	return committime;
}
public void setCommittime(String committime) {
	this.committime = committime;
}
private String committime;
private String teachername;
private int lessonid;
private String workname;
public Work(String teachername, int lessonid, String workname, String begintime, String endtime, String content) {
	super();
	this.teachername = teachername;
	this.lessonid = lessonid;
	this.workname = workname;
	this.begintime = begintime;
	this.endtime = endtime;
	this.content = content;
}
public Work(int id, String teachername, int lessonid, String workname, String begintime, String endtime,
		String content) {
	super();
	this.id = id;
	this.teachername = teachername;
	this.lessonid = lessonid;
	this.workname = workname;
	this.begintime = begintime;
	this.endtime = endtime;
	this.content = content;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTeachername() {
	return teachername;
}
public void setTeachername(String teachername) {
	this.teachername = teachername;
}
public int getLessonid() {
	return lessonid;
}
public void setLessonid(int lessonid) {
	this.lessonid = lessonid;
}
public String getWorkname() {
	return workname;
}
public void setWorkname(String workname) {
	this.workname = workname;
}
public String getBegintime() {
	return begintime;
}
public void setBegintime(String begintime) {
	this.begintime = begintime;
}
public String getEndtime() {
	return endtime;
}
public void setEndtime(String endtime) {
	this.endtime = endtime;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
private String begintime;
private String endtime;
private String content;

}

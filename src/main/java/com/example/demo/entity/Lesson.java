package com.example.demo.entity;
public class Lesson {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String department;
	private String major;
	private String lessonIntrodution;
	private String teachername;
	private String lessonName;
	private String imageurl;
	public Lesson(String department, String major, String lessonIntrodution, String teachername, String lessonName,
			String imageurl) {
		super();
		this.department = department;
		this.major = major;
		this.lessonIntrodution = lessonIntrodution;
		this.teachername = teachername;
		this.lessonName = lessonName;
		this.imageurl = imageurl;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getLessonIntrodution() {
		return lessonIntrodution;
	}
	public void setLessonIntrodution(String lessonIntrodution) {
		this.lessonIntrodution = lessonIntrodution;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public String getLessonName() {
		return lessonName;
	}
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	public Lesson(String department, String major, String lessonIntrodution, String lessonName) {
		super();
		this.department = department;
		this.major = major;
		this.lessonIntrodution = lessonIntrodution;
		this.lessonName = lessonName;
	}
	public Lesson() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Lesson [id=" + id + ", department=" + department + ", major=" + major + ", lessonIntrodution="
				+ lessonIntrodution + ", teachername=" + teachername + ", lessonName=" + lessonName + ", imageurl="
				+ imageurl + "]";
	}
}
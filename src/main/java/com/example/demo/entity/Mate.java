package com.example.demo.entity;

public class Mate {
	int id;
	String school;
	public int getId() {
		return id;
	}

	public Mate(String school, String bjh, String zy) {
		super();
		this.school = school;
		this.bjh = bjh;
		this.zy = zy;
	}

	public Mate(int id, String school, String bjh, String descri, String zy) {
		super();
		this.id = id;
		this.school = school;
		this.bjh = bjh;
		this.descri = descri;
		this.zy = zy;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescri() {
		return descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}
	String bjh;
	String descri;
	String zy;

	public Mate(String school, String bjh, String descri, String zy) {
		super();
		this.school = school;
		this.bjh = bjh;
		this.descri = descri;
		this.zy = zy;
	}

	public Mate() {
		super();
	}


	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "Mate [id=" + id + ", school=" + school + ", bjh=" + bjh + ", descri=" + descri + ", zy=" + zy + "]";
	}

	public String getBjh() {
		return bjh;
	}

	public void setBjh(String bjh) {
		this.bjh = bjh;
	}

	public String getDesc() {
		return descri;
	}

	public void setDesc(String desc) {
		this.descri = desc;
	}

	public String getZy() {
		return zy;
	}

	public void setZy(String zy) {
		this.zy = zy;
	}
   //form表单添加班级时判断是否为空
	public boolean isblank() {
		if ("".equals(this.school.trim()) || "".equals(this.bjh.trim()) || "".equals(this.zy.trim())) {
			return true;
		}
		return false;
	}
}

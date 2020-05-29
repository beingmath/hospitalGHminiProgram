package com.example.demo.entity;

public class Record {
    private int id;
    private String openid;

    public Record(String openid, Doctor doctor, String patientName, String phone, int doctorid, String birth, String time) {
        this.openid = openid;
        this.doctor = doctor;
        this.patientName = patientName;
        this.phone = phone;
        this.doctorid = doctorid;
        this.birth = birth;
        this.time = time;
    }

    private Doctor doctor;
    private String patientName;

    public int getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }

    private String phone;
   private int doctorid;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Record(String openid, Doctor doctor, String patientName, String phone, String birth, String time) {
        this.openid = openid;
        this.doctor = doctor;
        this.patientName = patientName;
        this.phone = phone;
        this.birth = birth;
        this.time = time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Record() {
    }

    private String birth;
    private String time;
}

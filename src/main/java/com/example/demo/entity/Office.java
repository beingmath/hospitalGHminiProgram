package com.example.demo.entity;

public class Office {
    private int id;

    public Office(int id, String name, String png, String createtime) {
        this.id = id;
        this.name = name;
        this.png = png;
        this.createtime = createtime;
    }

    private String name;
    private String png;
    private String createtime;

    public Office() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPng() {
        return png;
    }

    public void setPng(String png) {
        this.png = png;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}

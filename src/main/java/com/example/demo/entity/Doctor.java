package com.example.demo.entity;

public class Doctor {
    private int id;
    private String name;
    private String major;
    private Double price;

    public Doctor(String name, String major, Double price, String office, String png, String intro) {
        this.name = name;
        this.major = major;
        this.price = price;
        this.office = office;
        this.png = png;
        this.intro = intro;
    }

    private String office;

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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getPng() {
        return png;
    }

    public void setPng(String png) {
        this.png = png;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    private String png;

    public Doctor() {
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", price=" + price +
                ", office='" + office + '\'' +
                ", png='" + png + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }

    private String intro;
}

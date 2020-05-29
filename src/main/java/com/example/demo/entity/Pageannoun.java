package com.example.demo.entity;

public class Pageannoun {
    private int id;
    private String png;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPng() {
        return png;
    }

    public void setPng(String png) {
        this.png = png;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Pageannoun() {
    }

    private String details;

    public Pageannoun(String png, String details) {
        this.png = png;
        this.details = details;
    }
}

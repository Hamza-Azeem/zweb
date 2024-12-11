package com.Zweb.backend.models;

public class Requirements {
    private Integer no;
    private String text;

    public Requirements(Integer no, String text) {
        this.no = no;
        this.text = text;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getTitle() {
        return text;
    }

    public void setTitle(String text) {
        this.text = text;
    }
}

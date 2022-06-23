package com.example.keep.entity;

import org.springframework.stereotype.Component;

@Component
public class MyCourse {
    private int id;
    private int user_id;
    private int course_id;
    private String course_name;

    private String picture;
    private int my_classes;
    private int classes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getMy_classes() {
        return my_classes;
    }

    public void setMy_classes(int my_classes) {
        this.my_classes = my_classes;
    }

    public int getClasses() {
        return classes;
    }

    public void setClasses(int classes) {
        this.classes = classes;
    }
}

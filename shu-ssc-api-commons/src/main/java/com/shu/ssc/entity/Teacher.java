package com.shu.ssc.entity;


import lombok.Data;

@Data
public class Teacher {
    private Integer userId;

    private String name;

    private String phoneId;

    private String password;

    private String sex;

    private String school;

    private Integer majorId;

    private String teacherPicUrl;

    private Boolean teacherStatus;

    private String intro;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getTeacherPicUrl() {
        return teacherPicUrl;
    }

    public void setTeacherPicUrl(String teacherPicUrl) {
        this.teacherPicUrl = teacherPicUrl;
    }

    public Boolean getTeacherStatus() {
        return teacherStatus;
    }

    public void setTeacherStatus(Boolean teacherStatus) {
        this.teacherStatus = teacherStatus;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
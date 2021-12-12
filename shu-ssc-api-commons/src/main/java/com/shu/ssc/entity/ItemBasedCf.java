package com.shu.ssc.entity;


import lombok.Data;

@Data
public class ItemBasedCf {
    private Integer id;

    private Integer studentId;

    private Integer courseId;

    private Double cfMark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Double getCfMark() {
        return cfMark;
    }

    public void setCfMark(Double cfMark) {
        this.cfMark = cfMark;
    }
}
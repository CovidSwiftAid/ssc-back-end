package com.shu.ssc.entity;

import java.math.BigDecimal;
import java.util.Date;


import lombok.Data;

@Data
public class Course {
    private Integer courseId;

    private String name;

    private Date uploadTime;

    private Integer teacherId;

    private Integer preferId;

    private String coursePic;

    private Integer courseStatus;

    private Boolean needVip;

    private BigDecimal courseAvgMark;

    private Integer courseWatches;

    private String intro;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getPreferId() {
        return preferId;
    }

    public void setPreferId(Integer preferId) {
        this.preferId = preferId;
    }

    public String getCoursePic() {
        return coursePic;
    }

    public void setCoursePic(String coursePic) {
        this.coursePic = coursePic;
    }

    public Integer getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(Integer courseStatus) {
        this.courseStatus = courseStatus;
    }

    public Boolean getNeedVip() {
        return needVip;
    }

    public void setNeedVip(Boolean needVip) {
        this.needVip = needVip;
    }

    public BigDecimal getCourseAvgMark() {
        return courseAvgMark;
    }

    public void setCourseAvgMark(BigDecimal courseAvgMark) {
        this.courseAvgMark = courseAvgMark;
    }

    public Integer getCourseWatches() {
        return courseWatches;
    }

    public void setCourseWatches(Integer courseWatches) {
        this.courseWatches = courseWatches;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
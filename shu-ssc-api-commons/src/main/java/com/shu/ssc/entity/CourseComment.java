package com.shu.ssc.entity;

import java.util.Date;


import lombok.Data;

@Data
public class CourseComment {
    private Integer commentId;

    private Integer likes;

    private String content;

    private Date time;

    private Integer studentId;

    private Integer courseId;

    private Integer commentMark;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    public Integer getCommentMark() {
        return commentMark;
    }

    public void setCommentMark(Integer commentMark) {
        this.commentMark = commentMark;
    }
}
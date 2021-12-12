package com.shu.ssc.entity;


import lombok.Data;

@Data
public class RelationshipStuPrefer {
    private Integer studentId;

    private Integer preferId;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getPreferId() {
        return preferId;
    }

    public void setPreferId(Integer preferId) {
        this.preferId = preferId;
    }
}
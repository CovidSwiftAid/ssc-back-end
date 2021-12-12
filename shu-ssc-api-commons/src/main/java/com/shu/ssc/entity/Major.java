package com.shu.ssc.entity;


import lombok.Data;

@Data
public class Major {
    private Integer majorId;

    private String majorContent;

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getMajorContent() {
        return majorContent;
    }

    public void setMajorContent(String majorContent) {
        this.majorContent = majorContent;
    }
}
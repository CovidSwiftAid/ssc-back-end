package com.shu.ssc.entity;


import lombok.Data;

@Data
public class Prefer {
    private Integer preferId;

    private String preferContent;

    private Integer majorId;

    public Integer getPreferId() {
        return preferId;
    }

    public void setPreferId(Integer preferId) {
        this.preferId = preferId;
    }

    public String getPreferContent() {
        return preferContent;
    }

    public void setPreferContent(String preferContent) {
        this.preferContent = preferContent;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }
}
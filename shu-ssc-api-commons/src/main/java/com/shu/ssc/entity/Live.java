package com.shu.ssc.entity;

import java.util.Date;


import lombok.Data;

@Data
public class Live {
    private Integer liveId;

    private String liveName;

    private Date liveDate;

    private Integer liveAddressId;

    private Integer teacherId;

    private String livePicUrl;

    private Integer liveArrange;

    private String liveIntro;

    public Integer getLiveId() {
        return liveId;
    }

    public void setLiveId(Integer liveId) {
        this.liveId = liveId;
    }

    public String getLiveName() {
        return liveName;
    }

    public void setLiveName(String liveName) {
        this.liveName = liveName;
    }

    public Date getLiveDate() {
        return liveDate;
    }

    public void setLiveDate(Date liveDate) {
        this.liveDate = liveDate;
    }

    public Integer getLiveAddressId() {
        return liveAddressId;
    }

    public void setLiveAddressId(Integer liveAddressId) {
        this.liveAddressId = liveAddressId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getLivePicUrl() {
        return livePicUrl;
    }

    public void setLivePicUrl(String livePicUrl) {
        this.livePicUrl = livePicUrl;
    }

    public Integer getLiveArrange() {
        return liveArrange;
    }

    public void setLiveArrange(Integer liveArrange) {
        this.liveArrange = liveArrange;
    }

    public String getLiveIntro() {
        return liveIntro;
    }

    public void setLiveIntro(String liveIntro) {
        this.liveIntro = liveIntro;
    }
}
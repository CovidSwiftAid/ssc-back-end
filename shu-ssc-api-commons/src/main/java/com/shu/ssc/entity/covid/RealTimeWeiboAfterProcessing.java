package com.shu.ssc.entity.covid;

import lombok.Data;

@Data
public class RealTimeWeiboAfterProcessing {
    private Integer id;

    private String place;

    private String closedRate;

    private String positiveRate;

    private String longitude;

    private String latitude;

    private String level;

    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getClosedRate() {
        return closedRate;
    }

    public void setClosedRate(String closedRate) {
        this.closedRate = closedRate;
    }

    public String getPositiveRate() {
        return positiveRate;
    }

    public void setPositiveRate(String positiveRate) {
        this.positiveRate = positiveRate;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
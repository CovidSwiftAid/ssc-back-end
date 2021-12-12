package com.shu.ssc.entity;


import lombok.Data;

@Data
public class LiveAddress {
    private Integer liveAddressId;

    private String liveAddress;

    public Integer getLiveAddressId() {
        return liveAddressId;
    }

    public void setLiveAddressId(Integer liveAddressId) {
        this.liveAddressId = liveAddressId;
    }

    public String getLiveAddress() {
        return liveAddress;
    }

    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress;
    }
}
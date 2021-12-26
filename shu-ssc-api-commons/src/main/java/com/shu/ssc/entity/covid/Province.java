package com.shu.ssc.entity.covid;

import lombok.Data;

@Data
public class Province {
    private Integer id;

    private Integer confirmed;

    private Integer died;

    private Integer cured;

    private String relativeTime;

    private Integer confirmRelative;

    private Integer diedRelative;

    private Integer curedRelative;

    private Integer asymptomaticRelative;

    private Integer asymptomatic;

    private Integer curConfirm;

    private Integer curConfirmRelative;

    private String province;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getDied() {
        return died;
    }

    public void setDied(Integer died) {
        this.died = died;
    }

    public Integer getCured() {
        return cured;
    }

    public void setCured(Integer cured) {
        this.cured = cured;
    }

    public String getRelativeTime() {
        return relativeTime;
    }

    public void setRelativeTime(String relativeTime) {
        this.relativeTime = relativeTime;
    }

    public Integer getConfirmRelative() {
        return confirmRelative;
    }

    public void setConfirmRelative(Integer confirmRelative) {
        this.confirmRelative = confirmRelative;
    }

    public Integer getDiedRelative() {
        return diedRelative;
    }

    public void setDiedRelative(Integer diedRelative) {
        this.diedRelative = diedRelative;
    }

    public Integer getCuredRelative() {
        return curedRelative;
    }

    public void setCuredRelative(Integer curedRelative) {
        this.curedRelative = curedRelative;
    }

    public Integer getAsymptomaticRelative() {
        return asymptomaticRelative;
    }

    public void setAsymptomaticRelative(Integer asymptomaticRelative) {
        this.asymptomaticRelative = asymptomaticRelative;
    }

    public Integer getAsymptomatic() {
        return asymptomatic;
    }

    public void setAsymptomatic(Integer asymptomatic) {
        this.asymptomatic = asymptomatic;
    }

    public Integer getCurConfirm() {
        return curConfirm;
    }

    public void setCurConfirm(Integer curConfirm) {
        this.curConfirm = curConfirm;
    }

    public Integer getCurConfirmRelative() {
        return curConfirmRelative;
    }

    public void setCurConfirmRelative(Integer curConfirmRelative) {
        this.curConfirmRelative = curConfirmRelative;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
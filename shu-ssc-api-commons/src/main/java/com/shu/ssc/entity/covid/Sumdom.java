package com.shu.ssc.entity.covid;

import lombok.Data;

@Data
public class Sumdom {
    private Integer id;

    private Integer confirmed;

    private Integer died;

    private Integer cured;

    private Integer asymptomatic;

    private Integer asymptomaticRelative;

    private Integer unconfirmed;

    private String relativeTime;

    private Integer confirmedRelative;

    private Integer unconfirmedRelative;

    private Integer curedRelative;

    private Integer diedRelative;

    private Integer serious;

    private Integer seriousRelative;

    private Integer foreignInput;

    private Integer foreignInputRelative;

    private Integer curConfirm;

    private Integer curConfirmRelative;

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

    public Integer getAsymptomatic() {
        return asymptomatic;
    }

    public void setAsymptomatic(Integer asymptomatic) {
        this.asymptomatic = asymptomatic;
    }

    public Integer getAsymptomaticRelative() {
        return asymptomaticRelative;
    }

    public void setAsymptomaticRelative(Integer asymptomaticRelative) {
        this.asymptomaticRelative = asymptomaticRelative;
    }

    public Integer getUnconfirmed() {
        return unconfirmed;
    }

    public void setUnconfirmed(Integer unconfirmed) {
        this.unconfirmed = unconfirmed;
    }

    public String getRelativeTime() {
        return relativeTime;
    }

    public void setRelativeTime(String relativeTime) {
        this.relativeTime = relativeTime;
    }

    public Integer getConfirmedRelative() {
        return confirmedRelative;
    }

    public void setConfirmedRelative(Integer confirmedRelative) {
        this.confirmedRelative = confirmedRelative;
    }

    public Integer getUnconfirmedRelative() {
        return unconfirmedRelative;
    }

    public void setUnconfirmedRelative(Integer unconfirmedRelative) {
        this.unconfirmedRelative = unconfirmedRelative;
    }

    public Integer getCuredRelative() {
        return curedRelative;
    }

    public void setCuredRelative(Integer curedRelative) {
        this.curedRelative = curedRelative;
    }

    public Integer getDiedRelative() {
        return diedRelative;
    }

    public void setDiedRelative(Integer diedRelative) {
        this.diedRelative = diedRelative;
    }

    public Integer getSerious() {
        return serious;
    }

    public void setSerious(Integer serious) {
        this.serious = serious;
    }

    public Integer getSeriousRelative() {
        return seriousRelative;
    }

    public void setSeriousRelative(Integer seriousRelative) {
        this.seriousRelative = seriousRelative;
    }

    public Integer getForeignInput() {
        return foreignInput;
    }

    public void setForeignInput(Integer foreignInput) {
        this.foreignInput = foreignInput;
    }

    public Integer getForeignInputRelative() {
        return foreignInputRelative;
    }

    public void setForeignInputRelative(Integer foreignInputRelative) {
        this.foreignInputRelative = foreignInputRelative;
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
}
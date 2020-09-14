package com.asg.cxiom.model;

import java.time.LocalDate;
import java.util.Date;

public class MobileData {

    private String id;

    private String brand;
    private String phone;
    private String picture;
    private String releaseAnnounceDate;
    private String releasePriceEur;
    private String sim;
    private String resolution;
    private String hardwareAudioJack;
    private String hardwareGps;
    private String hardwareBattery;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getReleaseAnnounceDate() {
        return releaseAnnounceDate;
    }

    public void setReleaseAnnounceDate(String releaseAnnounceDate) {
        this.releaseAnnounceDate = releaseAnnounceDate;
    }

    public String getReleasePriceEur() {
        return releasePriceEur;
    }

    public void setReleasePriceEur(String releasePriceEur) {
        this.releasePriceEur = releasePriceEur;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getHardwareAudioJack() {
        return hardwareAudioJack;
    }

    public void setHardwareAudioJack(String hardwareAudioJack) {
        this.hardwareAudioJack = hardwareAudioJack;
    }

    public String getHardwareGps() {
        return hardwareGps;
    }

    public void setHardwareGps(String hardwareGps) {
        this.hardwareGps = hardwareGps;
    }

    public String getHardwareBattery() {
        return hardwareBattery;
    }

    public void setHardwareBattery(String hardwareBattery) {
        this.hardwareBattery = hardwareBattery;
    }
}

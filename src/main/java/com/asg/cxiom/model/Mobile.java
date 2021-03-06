package com.asg.cxiom.model;

public class Mobile {

    private String id;
    private String brand;
    private String phone;
    private String picture;
    private MobileRelease release;
    private String sim;
    private String resolution;
    private MobilHarware hardware;

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

    public MobileRelease getRelease() {
        return release;
    }

    public void setRelease(MobileRelease release) {
        this.release = release;
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

    public MobilHarware getHardware() {
        return hardware;
    }

    public void setHardware(MobilHarware hardware) {
        this.hardware = hardware;
    }
}


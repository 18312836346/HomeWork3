package com.example.homework.service;

import java.io.Serializable;

public class ThreeService implements Serializable {
    private int imgId;
    private String name;

    public ThreeService(){
        
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ThreeService(int imgId, String name) {
        this.imgId = imgId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ThreeService{" +
                "imgId=" + imgId +
                ", name='" + name + '\'' +
                '}';
    }
}

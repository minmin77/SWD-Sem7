package com.example.testloginfb.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Detail implements Serializable {
    @SerializedName("id")
    private String detailId;

    @SerializedName("name")
    private String detailName;

    public Detail() {
    }

    public Detail(String detailId, String detailName) {
        this.detailId = detailId;
        this.detailName = detailName;
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }
}

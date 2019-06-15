package com.example.testloginfb.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Detail implements Serializable {
    @SerializedName("id")
    private int detailId;

    @SerializedName("name")
    private int detailName;

    public Detail() {
    }

    public Detail(int detailId, int detailName) {
        this.detailId = detailId;
        this.detailName = detailName;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public int getDetailName() {
        return detailName;
    }

    public void setDetailName(int detailName) {
        this.detailName = detailName;
    }
}

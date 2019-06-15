package com.example.testloginfb.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Staff implements Serializable {
    @SerializedName("id")
    private int staffId;

    @SerializedName("name")
    private String staffName;

    @SerializedName("store")
    private Store storeId;

    @SerializedName("position")
    private Detail staffPosition;

    @SerializedName("picUrl")
    private String pictureUrl;

    @SerializedName("accessToken")
    private String accessToken;

    @SerializedName("gmail")
    private String staffGoogle;

    @SerializedName("status")
    private Detail staffStatus;

    public Staff() {
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Store getStoreId() {
        return storeId;
    }

    public void setStoreId(Store storeId) {
        this.storeId = storeId;
    }

    public Detail getStaffPosition() {
        return staffPosition;
    }

    public void setStaffPosition(Detail staffPosition) {
        this.staffPosition = staffPosition;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getStaffGoogle() {
        return staffGoogle;
    }

    public void setStaffGoogle(String staffGoogle) {
        this.staffGoogle = staffGoogle;
    }

    public Detail getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(Detail staffStatus) {
        this.staffStatus = staffStatus;
    }
}

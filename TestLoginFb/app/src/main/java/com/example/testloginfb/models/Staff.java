package com.example.testloginfb.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Staff implements Serializable {
    @SerializedName("id")
    private Long staffId;

    @SerializedName("name")
    private String staffName;

    @SerializedName("store")
    private Store storeId;

    @SerializedName("position")
    private Detail staffPosition;

    @SerializedName("picUrl")
    private String pictureUrl;

    @SerializedName("authToken")
    private String authToken;

    @SerializedName("gmail")
    private String staffGoogle;

    @SerializedName("status")
    private Detail staffStatus;

    public Staff() {
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
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

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
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

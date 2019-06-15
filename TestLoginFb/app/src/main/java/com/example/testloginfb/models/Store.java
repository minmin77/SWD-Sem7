package com.example.testloginfb.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Store implements Serializable {
    @SerializedName("id")
    private String storeId;

    @SerializedName("name")
    private String storeName;

    @SerializedName("location")
    private String storeLocation;

    @SerializedName("status")
    private Detail storeDetail;

    public Store() {
    }

    public Store(String storeId, String storeName, String storeLocation, Detail storeDetail) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.storeLocation = storeLocation;
        this.storeDetail = storeDetail;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }

    public Detail getStoreDetail() {
        return storeDetail;
    }

    public void setStoreDetail(Detail storeDetail) {
        this.storeDetail = storeDetail;
    }
}

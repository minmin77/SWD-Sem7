package com.example.testloginfb.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Store implements Serializable {
    @SerializedName("id")
    private int storeId;

    @SerializedName("name")
    private int storeName;

    @SerializedName("location")
    private int storeLocation;

    @SerializedName("status")
    private Detail storeDetail;

    public Store() {
    }

    public Store(int storeId, int storeName, int storeLocation, Detail storeDetail) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.storeLocation = storeLocation;
        this.storeDetail = storeDetail;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getStoreName() {
        return storeName;
    }

    public void setStoreName(int storeName) {
        this.storeName = storeName;
    }

    public int getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(int storeLocation) {
        this.storeLocation = storeLocation;
    }

    public Detail getStoreDetail() {
        return storeDetail;
    }

    public void setStoreDetail(Detail storeDetail) {
        this.storeDetail = storeDetail;
    }
}

package com.example.testloginfb.room.entities;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.example.testloginfb.models.Detail;
import com.example.testloginfb.models.Store;

@Entity(tableName = "Staff")
public class StaffEntity {
    @PrimaryKey(autoGenerate = true)
    private int localStaffId;

    @ColumnInfo(name = "staff_id")
    private Long staffId;

    @ColumnInfo(name = "staff_name")
    private String staffName;

    @ColumnInfo(name = "position")
    private String position;

    @ColumnInfo(name = "store")
    private String store;

    @ColumnInfo(name = "pic_url")
    private String picUrl;

    @ColumnInfo(name = "auth_token")
    private String authToken;

    @ColumnInfo(name = "staff_mail")
    private String staffMail;

    @ColumnInfo(name = "staff_status")
    private String staffStatus;

    public StaffEntity() {
    }

    public int getLocalStaffId() {
        return localStaffId;
    }

    public void setLocalStaffId(int localStaffId) {
        this.localStaffId = localStaffId;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getStaffMail() {
        return staffMail;
    }

    public void setStaffMail(String staffMail) {
        this.staffMail = staffMail;
    }

    public String getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus;
    }
}
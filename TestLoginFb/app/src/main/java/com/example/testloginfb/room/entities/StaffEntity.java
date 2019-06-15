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
    private int staffId;

    @ColumnInfo(name = "staff_name")
    private String staffName;

//    @ColumnInfo(name = "position")
//    private Detail position;

//    @ColumnInfo(name = "store")
//    private Store store;

    @ColumnInfo(name = "pic_url")
    private String picUrl;

    @ColumnInfo(name = "access_token")
    private String accessToken;

    @ColumnInfo(name = "staff_mail")
    private String staffMail;

//    @ColumnInfo(name = "staff_status")
//    private Detail staffStatus;

    public StaffEntity() {
    }

    public int getLocalStaffId() {
        return localStaffId;
    }

    public void setLocalStaffId(int localStaffId) {
        this.localStaffId = localStaffId;
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


    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getStaffMail() {
        return staffMail;
    }

    public void setStaffMail(String staffMail) {
        this.staffMail = staffMail;
    }

    public String getPicUrl() {
        return picUrl;
    }
}
package com.example.testloginfb.utils;

import com.example.testloginfb.models.Staff;
import com.example.testloginfb.room.entities.StaffEntity;

public class TypeConverter {
    public static StaffEntity fromStaffToEntity(Staff staff) {
        StaffEntity staffEntity = new StaffEntity();
        staffEntity.setStaffId(staff.getStaffId());
        staffEntity.setStaffName(staff.getStaffName());
//        staffEntity.setPosition(staff.getStaffPosition());
//        staffEntity.setStore(staff.getStoreId());
        staffEntity.setPicUrl(staff.getPictureUrl());
        staffEntity.setAccessToken(staff.getAccessToken());
        staffEntity.setStaffMail(staff.getStaffGoogle());
//        staffEntity.setStaffStatus(staff.getStaffStatus());
        return staffEntity;
    }
}

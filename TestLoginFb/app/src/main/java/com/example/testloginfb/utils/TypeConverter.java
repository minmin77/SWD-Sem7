package com.example.testloginfb.utils;

import com.example.testloginfb.models.Staff;
import com.example.testloginfb.room.entities.StaffEntity;

public class TypeConverter {
    public static StaffEntity fromStaffToEntity(Staff staff) {
        StaffEntity staffEntity = new StaffEntity();
        staffEntity.setStaffId(staff.getStaffId());
        staffEntity.setStaffName(staff.getStaffName());
        staffEntity.setPosition(staff.getStaffPosition().getDetailName());
        staffEntity.setStore(staff.getStoreId().getStoreName());
        staffEntity.setPicUrl(staff.getPictureUrl());
        staffEntity.setAuthToken(staff.getAuthToken());
        staffEntity.setStaffMail(staff.getStaffGoogle());
        staffEntity.setStaffStatus(staff.getStaffStatus().getDetailName());
        return staffEntity;
    }
}

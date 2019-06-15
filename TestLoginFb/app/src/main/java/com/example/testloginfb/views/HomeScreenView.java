package com.example.testloginfb.views;

import com.example.testloginfb.room.entities.StaffEntity;

public interface HomeScreenView extends BaseView {
    void loadLocalStaff(StaffEntity staffEntity);
}

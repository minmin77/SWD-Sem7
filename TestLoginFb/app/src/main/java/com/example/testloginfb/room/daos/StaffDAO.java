package com.example.testloginfb.room.daos;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.testloginfb.room.entities.StaffEntity;


@Dao
public interface StaffDAO {
    @Insert
    void insert(StaffEntity... staffs);

    @Update
    void update(StaffEntity... staffs);

    @Delete
    void delete(StaffEntity... staffs);

    @Query("SELECT * FROM staff")
    StaffEntity getStaff();
}
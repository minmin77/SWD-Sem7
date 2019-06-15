package com.example.testloginfb.room.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.testloginfb.room.daos.StaffDAO;
import com.example.testloginfb.room.entities.StaffEntity;

import static com.example.testloginfb.room.database.QlkDatabase.DATABASE_VERSION;

@Database(entities = {StaffEntity.class}, version = DATABASE_VERSION)
public abstract class QlkDatabase extends RoomDatabase {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "qlk-database";
    private static QlkDatabase INSTANCE;

    public abstract StaffDAO getStaffDAO();

    public static QlkDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (QlkDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), QlkDatabase.class, DATABASE_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

package com.example.testloginfb.presenters;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.example.testloginfb.callbacks.CallbackData;
import com.example.testloginfb.helpers.StaffHelper;
import com.example.testloginfb.room.entities.StaffEntity;
import com.example.testloginfb.views.HomeScreenView;

public class HomeScreenPresenter {
    private HomeScreenView mHomeScreenView;
    private Context mContext;
    private StaffHelper mStaffHelper;

    public HomeScreenPresenter(HomeScreenView mHomeScreenView, Context mContext, Application application) {
        this.mHomeScreenView = mHomeScreenView;
        this.mContext = mContext;
        this.mStaffHelper = new StaffHelper(application);
    }

    public void handleLoadStaffFromRoom() {
        mStaffHelper.getLocalStaff(new CallbackData<StaffEntity>() {
            @Override
            public void onSuccess(StaffEntity staffEntity) {
                mHomeScreenView.loadLocalStaff(staffEntity);
            }

            @Override
            public void onFail(String message) {
                mHomeScreenView.showProgressHUD();
                Toast.makeText(mContext, "Room hổng load đc", Toast.LENGTH_LONG).show();
            }
        });
    }
}

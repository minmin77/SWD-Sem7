package com.example.testloginfb.presenters;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.example.testloginfb.callbacks.CallbackData;
import com.example.testloginfb.helpers.InternetHelper;
import com.example.testloginfb.helpers.StaffHelper;
import com.example.testloginfb.models.Staff;
import com.example.testloginfb.room.entities.StaffEntity;
import com.example.testloginfb.views.SplashView;

public class SplashPresenter {
    private SplashView mView;
    private Context mContext;
    private StaffHelper mStaffHelper;

    public SplashPresenter(SplashView mView, Context mContext, Application application) {
        this.mView = mView;
        this.mContext = mContext;
        this.mStaffHelper = new StaffHelper(application);
    }

    public void waitThenProgress() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadLocalUser();
            }
        }, 2000);
    }

    private void loadLocalUser() {
        if (InternetHelper.isOnline(mContext)) {
            mStaffHelper.getLocalStaff(new CallbackData<StaffEntity>() {
                @Override
                public void onSuccess(StaffEntity staffEntity) {
                    if (staffEntity != null) {
                        verifyStaffOnline(staffEntity);
                    }
                    mView.goToMainActivity();
                }

                @Override
                public void onFail(String message) {
                    mView.goToMainActivity();
                }
            });
        } else {
            mView.goToNoInternetActivity();
        }
    }

    private void verifyStaffOnline(final StaffEntity staffEntity) {
        mStaffHelper.getOnlineStaff(staffEntity, new CallbackData<Staff>() {
            @Override
            public void onSuccess(Staff staff) {
                mView.showProgressHUD();
                if (staffEntity != null){
                    mView.goToHomeScreenActivity();
                } else {
                    mView.goToMainActivity();
                }
            }

            @Override
            public void onFail(String message) {
                mView.goToMainActivity();
            }
        });
    }
}

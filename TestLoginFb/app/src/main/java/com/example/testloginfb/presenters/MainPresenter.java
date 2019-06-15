package com.example.testloginfb.presenters;

import android.app.Application;
import android.content.Context;

import com.example.testloginfb.callbacks.CallbackData;
import com.example.testloginfb.helpers.StaffHelper;
import com.example.testloginfb.models.Staff;
import com.example.testloginfb.views.MainView;

public class MainPresenter {
    private MainView mView;
    private Context mContext;
    private StaffHelper mStaffHelper;

    public MainPresenter(Context mContext, Application application, MainView mView) {
        this.mView = mView;
        this.mContext = mContext;
        this.mStaffHelper = new StaffHelper(application);
    }

    public void handleLoginWithFacebook(String accessToken) {
        mStaffHelper.processLoginByFacebook(accessToken, new CallbackData<Staff>() {
            @Override
            public void onSuccess(Staff staff) {
                mView.dismissProgressHUD();
                mView.goToHomeActivity();
            }

            @Override
            public void onFail(String message) {
                mView.showToastMessage(message);
                mView.dismissProgressHUD();
            }
        });
    }

    public void handleLoginWithGoogle(String google) {
        mStaffHelper.progressLoginByGoogle(google, new CallbackData<Staff>() {
            @Override
            public void onSuccess(Staff staff) {
                mView.dismissProgressHUD();
                mView.goToHomeActivity();
            }

            @Override
            public void onFail(String message) {
                mView.dismissProgressHUD();
                mView.showToastMessage(message);
            }
        });
    }
}

package com.example.testloginfb.presenters;

import android.content.Context;
import android.os.Handler;

import com.example.testloginfb.helpers.InternetHelper;
import com.example.testloginfb.views.SplashView;

public class SplashPresenter {
    private SplashView mView;
    private Context mContext;

    public SplashPresenter(SplashView mView, Context mContext) {
        this.mView = mView;
        this.mContext = mContext;
    }

    public void waitThenProgress() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadLocalUser();
            }
        }, 4000);
    }

    private void loadLocalUser() {
        if (InternetHelper.isOnline(mContext)) {
//            mStaffHelper.getLocalStaff(new CallbackData<StaffEntity>() {
//                @Override
//                public void onSuccess(StaffEntity staffEntity) {
//                    if (staffEntity != null){
//                        mView.goToMainActivity();
//                    }
//                    mView.goToSignInActivity();
//                }
//
//                @Override
//                public void onFail(String message) {
//                    mView.goToSignInActivity();
//                }
//            });
            mView.goToMainActivity();
        } else {
            mView.goToNoInternetActivity();
        }
    }
}

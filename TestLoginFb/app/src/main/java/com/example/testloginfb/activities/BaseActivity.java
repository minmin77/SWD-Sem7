package com.example.testloginfb.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.testloginfb.R;
import com.example.testloginfb.utils.KProgressHUDManager;
import com.example.testloginfb.views.BaseView;
import com.kaopiz.kprogresshud.KProgressHUD;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class BaseActivity extends AppCompatActivity implements BaseView {
    private KProgressHUD mHud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(getApplicationContext().getResources().getColor(R.color.color_green));
    }

    @Override
    public void showProgressHUD() {
        if (!this.isFinishing()) {
            mHud = KProgressHUDManager.showProgressHUD(this);
        }
    }

    @Override
    public void dismissProgressHUD() {
        if (!this.isFinishing()) {
            KProgressHUDManager.dismiss(mHud);
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

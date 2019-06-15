package com.example.testloginfb.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.testloginfb.R;
import com.example.testloginfb.helpers.InternetHelper;
import com.example.testloginfb.views.NoInternetView;

public class NoInternetActivity extends BaseActivity implements NoInternetView, View.OnClickListener {
    private Button mBtnTryAgain;

    public static void moveToNoInternetActivity(Activity activity) {
        Intent intentToNoInternetActivity = new Intent(activity, NoInternetActivity.class);
        activity.startActivity(intentToNoInternetActivity);
        activity.finish();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet);
        initialView();
    }

    private void initialView() {
        mBtnTryAgain = findViewById(R.id.btn_no_internet_try_again);
        mBtnTryAgain.setOnClickListener(this);
    }

    @Override
    public void goToSplashActivity() {
        SplashActivity.moveToSplashActivity(NoInternetActivity.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_no_internet_try_again:
                tryConnectAgain();
                break;
        }
    }

    private void tryConnectAgain() {
        if (InternetHelper.isOnline(NoInternetActivity.this)) {
            goToSplashActivity();
        } else {
            Toast.makeText(NoInternetActivity.this, "Vui lòng kiểm tra lại đường truyền.", Toast.LENGTH_LONG).show();
        }
    }
}

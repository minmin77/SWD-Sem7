package com.example.testloginfb.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;


import com.example.testloginfb.R;
import com.example.testloginfb.presenters.SplashPresenter;
import com.example.testloginfb.views.SplashView;

public class SplashActivity extends BaseActivity implements SplashView {
    private SplashPresenter mPresenter;

    public static void moveToSplashActivity(Activity activity) {
        Intent intentToSplashActivity = new Intent(activity, SplashActivity.class);
        activity.startActivity(intentToSplashActivity);
        activity.finish();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initialPresenter();
//        printKeyHash();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mPresenter.waitThenProgress();
    }

    private void initialPresenter() {
        mPresenter = new SplashPresenter(this, this,getApplication());
    }

    @Override
    public void goToMainActivity() {
        MainActivity.moveToMainActivity(SplashActivity.this);
    }

    @Override
    public void goToNoInternetActivity() {
        Intent intent = new Intent(this, NoInternetActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void goToHomeScreenActivity() {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        startActivity(intent);
        finish();
    }

//    private void printKeyHash() {
//        try {
//            PackageInfo info = getPackageManager()
//                    .getPackageInfo("com.example.swd_project.folders.activities",
//                            PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                Log.d("KEYHASH", Base64.encodeToString(md.digest(), Base64.DEFAULT));
//            }
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//    }
}

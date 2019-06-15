package com.example.testloginfb.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.testloginfb.R;
import com.example.testloginfb.room.entities.StaffEntity;


public class HomeScreenActivity extends BaseActivity implements View.OnClickListener {
    private Toolbar mToolbar;
    private Button mBtnHistory, mBtnTransaction, mBtnStock;
    private ImageView mImgNoti;
    private TextView mTxtStore, mTxtStaffName;
    private StaffEntity mStaffEntity;

    public static void moveToMainActivity(Activity activity) {
        Intent intentToMainActivity = new Intent(activity, MainActivity.class);
        activity.startActivity(intentToMainActivity);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        initialView();
//        initialData();
    }

    private void initialData() {
        mTxtStaffName.setText(mStaffEntity.getStaffName());
//        mTxtStore.setText(mStaffEntity.getStoreId());
    }

    private void initialView() {
        mToolbar = findViewById(R.id.tb_home_screen);
//        setSupportActionBar(mToolbar);
//        getSupportActionBar().setElevation(0);
//        //todo: show employee and store
//        getSupportActionBar().setTitle("");
        mBtnHistory = findViewById(R.id.btn_home_screen_history);
        mBtnTransaction = findViewById(R.id.btn_home_screen_transaction);
        mBtnStock = findViewById(R.id.btn_home_screen_stock);
        mImgNoti = findViewById(R.id.img_home_screen_notification);
        mTxtStore = findViewById(R.id.txt_tb_main_store);
        mTxtStaffName = findViewById(R.id.txt_tb_main_employee);
        mBtnTransaction.setOnClickListener(this);
        mBtnHistory.setOnClickListener(this);
        mBtnStock.setOnClickListener(this);
        mImgNoti.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_home_screen_transaction:
                showModeDialog();
                break;
            case R.id.btn_home_screen_history:
                //todo: go to history activity
                break;
            case R.id.img_home_screen_notification:
                //todo: show notification
                break;
        }
    }

    private void showModeDialog() {
        final Dialog dialog = new Dialog(HomeScreenActivity.this);
        dialog.setContentView(R.layout.dialog_choose_mode);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        LinearLayout lnlReceipt = dialog.findViewById(R.id.lnl_dialog_receipt);
        lnlReceipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo: go to Nhập hàng
            }
        });
        LinearLayout lnlIssue = dialog.findViewById(R.id.lnl_dialog_issue);
        lnlIssue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo: go to xuất hàng
            }
        });
        LinearLayout lnlCheck = dialog.findViewById(R.id.lnl_dialog_check);
        lnlCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo: go to kiểm kho
            }
        });
        dialog.show();
    }
}

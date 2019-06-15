package com.example.testloginfb.utils;

import android.content.Context;

import com.kaopiz.kprogresshud.KProgressHUD;

public class KProgressHUDManager {
    public static KProgressHUD showProgressHUD(Context context) {
        KProgressHUD hud = KProgressHUD.create(context)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
                .show();
        return hud;
    }

    public static void dismiss(KProgressHUD hud) {
        if (hud != null && hud.isShowing()) {
            hud.dismiss();
        }
    }
}
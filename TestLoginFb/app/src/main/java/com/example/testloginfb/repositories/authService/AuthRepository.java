package com.example.testloginfb.repositories.authService;

import android.content.Context;

import com.example.testloginfb.callbacks.CallbackData;
import com.example.testloginfb.models.Staff;

public interface AuthRepository {
    void loginByFacebook(Context context, Long staffId, CallbackData<Staff> callbackData);

    void loginByGoogle(Context context, String google, CallbackData<Staff> callbackData);

    void getStaffInfo(Context context, String authToken, Long staffId, CallbackData<Staff> callbackData);
}

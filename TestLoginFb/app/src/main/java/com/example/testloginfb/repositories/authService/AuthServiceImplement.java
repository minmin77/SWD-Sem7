package com.example.testloginfb.repositories.authService;

import android.content.Context;
import android.widget.Toast;

import com.example.testloginfb.callbacks.CallbackData;
import com.example.testloginfb.models.Staff;
import com.example.testloginfb.repositories.api.ClientApi;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthServiceImplement implements AuthRepository {
    @Override
    public void loginByFacebook(Context context, Long staffId, final CallbackData<Staff> callbackData) {
        ClientApi clientApi = new ClientApi();
        Call<Staff> serviceCall = clientApi.getAuthService().loginByFacebook(staffId);
        serviceCall.enqueue(new Callback<Staff>() {
            @Override
            public void onResponse(Call<Staff> call, Response<Staff> response) {
                if (response != null && response.body() != null) {
                    if (response.code() == 200) {
//                        try {
//                            String result = response.body().string();
//                        Type type = new TypeToken<Staff>() {
//                        }.getType();
//                            Staff staff = new Gson().fromJson(result, type);
                        Staff staff = response.body();
                        if (staff != null) {
                            callbackData.onSuccess(staff);
                        } else {
                            callbackData.onFail("No Data");
                        }

//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
                    }
                } else {
                    callbackData.onFail("No data");
                }
            }

            @Override
            public void onFailure(Call<Staff> call, Throwable t) {
                callbackData.onFail("No Data");
            }
        });
    }

    @Override
    public void loginByGoogle(Context context, String google, final CallbackData<Staff> callbackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> serviceCall = clientApi.getAuthService().loginByGoogle(google);
        serviceCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response != null && response.body() != null) {
                    if (response.code() == 200) {
                        try {
                            String result = response.body().string();
                            Type type = new TypeToken<Staff>() {
                            }.getType();
                            Staff staff = new Gson().fromJson(result, type);
                            if (staff != null) {
                                callbackData.onSuccess(staff);
                            } else {
                                callbackData.onFail("No Data");
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    callbackData.onFail("No data");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callbackData.onFail("No Data");
            }
        });
    }

    @Override
    public void getStaffInfo(final Context context, String authToken, Long staffId, final CallbackData<Staff> callbackData) {
        ClientApi clientApi = new ClientApi();
        String header = "Bearer " + authToken;
        Map<String, String> map = new HashMap<>();
        map.put("Authorization", header);
        Call<Staff> serviceCall = clientApi.getAuthService().getStaffInfo(map, staffId);
        serviceCall.enqueue(new Callback<Staff>() {
            @Override
            public void onResponse(Call<Staff> call, Response<Staff> response) {
                if (response.code() == 200 && response.body() != null) {
                    try {
                        Staff staff = response.body();
                        if (staff != null) {
                            callbackData.onSuccess(staff);
                        } else {
                            callbackData.onFail("No Data");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    callbackData.onFail(response.message());
                }
            }

            @Override
            public void onFailure(Call<Staff> call, Throwable t) {
                Toast.makeText(context, "verify fail", Toast.LENGTH_LONG).show();
            }
        });
    }
}

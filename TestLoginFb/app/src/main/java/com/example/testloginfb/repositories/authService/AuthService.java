package com.example.testloginfb.repositories.authService;

import com.example.testloginfb.callbacks.CallbackData;
import com.example.testloginfb.models.Staff;
import com.example.testloginfb.repositories.api.ConfigApi;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;

public interface AuthService {
    @GET(ConfigApi.Api.LOGIN_BY_FACEBOOK)
    Call<Staff> loginByFacebook(
            @Path("id") Long staffId
    );

    @GET(ConfigApi.Api.LOGIN_BY_GOOGLE)
    Call<ResponseBody> loginByGoogle(
            @Path("accessToken") String accessToken
    );

    @GET(ConfigApi.Api.GET_STAFF_INFO)
    Call<Staff> getStaffInfo(@HeaderMap Map<String, String> header, @Path("id") Long id);
}

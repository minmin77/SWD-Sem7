package com.example.testloginfb.repositories.authService;

import com.example.testloginfb.repositories.api.ConfigApi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AuthService {
    @GET(ConfigApi.Api.LOGIN_BY_FACEBOOK)
    Call<ResponseBody> loginByFacebook(
            @Path("accessToken") String accessToken
    );

    @GET(ConfigApi.Api.LOGIN_BY_GOOGLE)
    Call<ResponseBody> loginByGoogle(
            @Path("accessToken") String accessToken
    );
}

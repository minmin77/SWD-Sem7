package com.example.testloginfb.repositories.api;

import com.example.testloginfb.repositories.authService.AuthService;

public class ClientApi extends BaseApi {
    public AuthService getAuthService() {
        return this.getService(AuthService.class, ConfigApi.BASE_URL);
    }
}

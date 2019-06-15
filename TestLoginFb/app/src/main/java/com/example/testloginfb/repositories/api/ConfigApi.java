package com.example.testloginfb.repositories.api;

public class ConfigApi {
    //todo: update base url after upload api to server
    public static final String BASE_URL = "https://swhapicore.azurewebsites.net/api/";


    public interface Api {
        String LOGIN_BY_FACEBOOK = "staff/{id}";
        String LOGIN_BY_GOOGLE = "/staff/google";
        String GET_STAFF_INFO = "staff/{id}";
    }
}

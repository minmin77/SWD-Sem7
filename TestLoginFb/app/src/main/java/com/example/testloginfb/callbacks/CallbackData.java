package com.example.testloginfb.callbacks;

public interface CallbackData<T> {
    void onSuccess(T t);

    void onFail(String message);
}

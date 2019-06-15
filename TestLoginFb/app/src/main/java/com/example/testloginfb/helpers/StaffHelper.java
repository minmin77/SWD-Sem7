package com.example.testloginfb.helpers;

import android.content.Context;
import android.widget.Toast;

import com.example.testloginfb.callbacks.CallbackData;
import com.example.testloginfb.models.Staff;
import com.example.testloginfb.repositories.authService.AuthRepository;
import com.example.testloginfb.repositories.authService.AuthServiceImplement;
import com.example.testloginfb.room.entities.StaffEntity;
import com.example.testloginfb.room.managers.StaffManager;
import com.example.testloginfb.utils.TypeConverter;

public class StaffHelper {
    private Context mContext;
    private StaffManager mStaffManager;
    private AuthRepository mAuthRepository;

    public StaffHelper(Context application) {
        this.mContext = application;
    }

    public void getLocalStaff(final CallbackData<StaffEntity> callbackData) {
        mStaffManager = new StaffManager(mContext);
        mStaffManager.getStaff(new CallbackData<StaffEntity>() {
            @Override
            public void onSuccess(StaffEntity staffEntity) {
                callbackData.onSuccess(staffEntity);
            }

            @Override
            public void onFail(String message) {
                callbackData.onFail(message);
            }
        });
    }

    public void processLoginByFacebook(Long staffId, final CallbackData<Staff> callbackData) {
        mAuthRepository = new AuthServiceImplement();
        mAuthRepository.loginByFacebook(mContext, staffId, new CallbackData<Staff>() {
            @Override
            public void onSuccess(final Staff staff) {
                if (staff != null) {
                    addStaffInfoToRoom(staff, new CallbackData<String>() {
                        @Override
                        public void onSuccess(String s) {
                            getLocalStaff(new CallbackData<StaffEntity>() {
                                @Override
                                public void onSuccess(StaffEntity staffEntity) {
                                    if (staffEntity != null) {
                                        callbackData.onSuccess(staff);
                                    } else {
                                        callbackData.onFail("null entity");
                                    }
                                }

                                @Override
                                public void onFail(String message) {
                                    callbackData.onFail(message);
                                }
                            });
                        }

                        @Override
                        public void onFail(String message) {
                            callbackData.onFail(message);
                        }
                    });
                } else {
                    callbackData.onFail("Phone fail");
                }
                callbackData.onSuccess(staff);
            }

            @Override
            public void onFail(String message) {
                callbackData.onFail(message);
            }
        });
    }

    public void progressLoginByGoogle(String google, final CallbackData<Staff> callbackData) {
        mAuthRepository = new AuthServiceImplement();
        mAuthRepository.loginByGoogle(mContext, google, new CallbackData<Staff>() {
            @Override
            public void onSuccess(final Staff staff) {
                if (staff != null) {
                    addStaffInfoToRoom(staff, new CallbackData<String>() {
                        @Override
                        public void onSuccess(String s) {
                            getLocalStaff(new CallbackData<StaffEntity>() {
                                @Override
                                public void onSuccess(StaffEntity staffEntity) {
                                    if (staffEntity != null) {
                                        callbackData.onSuccess(staff);
                                    } else {
                                        callbackData.onFail("null entity");
                                    }
                                }

                                @Override
                                public void onFail(String message) {
                                    callbackData.onFail(message);
                                }
                            });
                        }

                        @Override
                        public void onFail(String message) {
                            callbackData.onFail(message);
                        }
                    });
                } else {
                    callbackData.onFail("Phone fail");
                }
            }

            @Override
            public void onFail(String message) {
                callbackData.onFail(message);
            }
        });
    }

    public void getOnlineStaff(StaffEntity staffEntity, final CallbackData<Staff> callbackData){
        mAuthRepository = new AuthServiceImplement();
        mAuthRepository.getStaffInfo(mContext, staffEntity.getAuthToken(), staffEntity.getStaffId(), new CallbackData<Staff>() {
            @Override
            public void onSuccess(Staff staff) {
                callbackData.onSuccess(staff);
            }

            @Override
            public void onFail(String message) {
                callbackData.onFail(message);
            }
        });
    }

    private void addStaffInfoToRoom(final Staff staff, final CallbackData<String> callbackData) {
        mStaffManager = new StaffManager(mContext);
        StaffEntity staffEntity = TypeConverter.fromStaffToEntity(staff);
        mStaffManager.addStaff(staffEntity, new CallbackData<StaffEntity>() {
            @Override
            public void onSuccess(StaffEntity staffEntity) {
                callbackData.onSuccess("success");
            }

            @Override
            public void onFail(String message) {
                callbackData.onFail(message);
            }
        });
    }
}

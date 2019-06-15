package com.example.testloginfb.room.managers;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;

import com.example.testloginfb.callbacks.CallbackData;
import com.example.testloginfb.room.database.QlkDatabase;
import com.example.testloginfb.room.daos.StaffDAO;
import com.example.testloginfb.room.entities.StaffEntity;


public class StaffManager {
    private StaffDAO mStaffDAO;
    private Context mApplication;

    public StaffManager(Context mApplication) {
        this.mApplication = mApplication;
        QlkDatabase qlkDatabase = QlkDatabase.getDatabase(mApplication);
        this.mStaffDAO = qlkDatabase.getStaffDAO();
    }

    public void addStaff(StaffEntity staffEntity, CallbackData<StaffEntity> callbackData) {
        AddStaffAsync addStaffAsync = new AddStaffAsync(mStaffDAO, callbackData);
        addStaffAsync.execute(staffEntity);
    }

    public void deleteStaff(StaffEntity staffEntity, CallbackData<StaffEntity> callbackData) {
        DeleteStaffAsync deleteStaffAsync = new DeleteStaffAsync(mStaffDAO, callbackData);
        deleteStaffAsync.execute(staffEntity);
    }

    public void updateStaff(StaffEntity staffEntity, CallbackData<StaffEntity> callbackData) {
        UpdateStaffAsync updateStaffAsync = new UpdateStaffAsync(mStaffDAO, callbackData);
        updateStaffAsync.execute(staffEntity);
    }

    public void getStaff(CallbackData<StaffEntity> callbackData) {
        GetStaffAsync getStaffAsync = new GetStaffAsync(mStaffDAO, callbackData);
        getStaffAsync.execute();
    }

    private class AddStaffAsync extends AsyncTask<StaffEntity, Void, Void> {
        private StaffDAO mStaffDAO;
        private CallbackData<StaffEntity> mCallbackData;

        public AddStaffAsync(StaffDAO mStaffDAO, CallbackData<StaffEntity> mCallbackData) {
            this.mStaffDAO = mStaffDAO;
            this.mCallbackData = mCallbackData;
        }

        @Override
        protected Void doInBackground(StaffEntity... staffEntities) {
            try {
                mStaffDAO.insert(staffEntities);
                mCallbackData.onSuccess(null);
            } catch (SQLiteConstraintException e) {
                mCallbackData.onFail(e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

    private class DeleteStaffAsync extends AsyncTask<StaffEntity, Void, Void> {
        private StaffDAO mStaffDAO;
        private CallbackData<StaffEntity> mCallbackData;

        public DeleteStaffAsync(StaffDAO mStaffDAO, CallbackData<StaffEntity> callbackData) {
            this.mStaffDAO = mStaffDAO;
            this.mCallbackData = callbackData;
        }

        @Override
        protected Void doInBackground(StaffEntity... staffEntities) {
            try {
                mStaffDAO.delete(staffEntities);
                mCallbackData.onSuccess(null);
            } catch (SQLiteConstraintException e) {
                mCallbackData.onFail(e.getMessage());
            }
            return null;
        }
    }

    private class UpdateStaffAsync extends AsyncTask<StaffEntity, Void, Void> {
        private StaffDAO mStaffDAO;
        private CallbackData<StaffEntity> mCallbackData;

        private UpdateStaffAsync(StaffDAO mStaffDAO, CallbackData<StaffEntity> callbackData) {
            this.mStaffDAO = mStaffDAO;
            this.mCallbackData = callbackData;
        }

        @Override
        protected Void doInBackground(StaffEntity... staffEntities) {
            try {
                mStaffDAO.update(staffEntities);
                mCallbackData.onSuccess(null);
            } catch (SQLiteConstraintException e) {
                mCallbackData.onFail(e.getMessage());
            }
            return null;
        }
    }

    private class GetStaffAsync extends AsyncTask<Void, Void, Void> {
        private StaffDAO mStaffDAO;
        private CallbackData<StaffEntity> mCallbackData;
        private StaffEntity mStaffEntity;

        private GetStaffAsync(StaffDAO mStaffDAO, CallbackData<StaffEntity> callbackData) {
            this.mStaffDAO = mStaffDAO;
            this.mCallbackData = callbackData;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                mStaffEntity = mStaffDAO.getStaff();
            } catch (SQLiteConstraintException e) {

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mCallbackData.onSuccess(mStaffEntity);
        }
    }
}

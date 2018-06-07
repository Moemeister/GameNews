package com.moesystems.gamenews.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.moesystems.gamenews.API.GamenewsAPI;
import com.moesystems.gamenews.DAOs.UserDAO;
import com.moesystems.gamenews.Database.GameNewsRoomDatabase;
import com.moesystems.gamenews.Entity.User;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GameNewsRepository {
    private UserDAO mUserDao;
    private LiveData<List<User>> mAllUsers;
    private GamenewsAPI api;
    public GameNewsRepository(Application application){
        GameNewsRoomDatabase db = GameNewsRoomDatabase.getDatabase(application);
        mUserDao = db.userDAO();
        mAllUsers = mUserDao.getAllUsers();
    }
     public LiveData<List<User>> getAllUsers(){
        return mAllUsers;
    }
    public void insertUser(User user){
        new insertUserAsyncTask(mUserDao).execute(user);
    }
    private static class insertUserAsyncTask extends AsyncTask<User,Void,Void>{
        private UserDAO userDAO;

        public insertUserAsyncTask(UserDAO userDAO){
            this.userDAO = userDAO;
        }

        @Override
        protected Void doInBackground(final User... users) {
            userDAO.insertUser(users[0]);
            return null;
        }
    }
}

package com.moesystems.gamenews.Viewmodel;

import android.app.Application;
import android.app.ListActivity;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.moesystems.gamenews.Database.GameNewsRoomDatabase;
import com.moesystems.gamenews.Entity.User;
import com.moesystems.gamenews.Repository.GameNewsRepository;

import java.util.List;

public class GameNewsViewmodel extends AndroidViewModel {

    private GameNewsRepository gameNewsRepository;
    private LiveData<List<User>> mAllUsers;

    public GameNewsViewmodel(@NonNull Application application) {
        super(application);
        gameNewsRepository = new GameNewsRepository(application);
        mAllUsers = gameNewsRepository.getAllUsers();
    }
    public LiveData<List<User>> getmAllUsers(){
        return mAllUsers;
    }
    public void insertUser(User user){ gameNewsRepository.insertUser(user);}
}

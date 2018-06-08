package com.moesystems.gamenews.Viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.moesystems.gamenews.Entity.New;
import com.moesystems.gamenews.Entity.User;
import com.moesystems.gamenews.Repository.GameNewsRepository;

import java.util.List;

public class GameNewsViewmodel extends AndroidViewModel {

    private GameNewsRepository gameNewsRepository;
    private List<New> mAllNews;

    public GameNewsViewmodel(@NonNull Application application) {
        super(application);
        gameNewsRepository = new GameNewsRepository(application);
        mAllNews = gameNewsRepository.getAllNews();
    }
    public List<New> getmAllNews(){
        return mAllNews;
    }
    public void insertUser(New news){ gameNewsRepository.insertNew(news);}
}

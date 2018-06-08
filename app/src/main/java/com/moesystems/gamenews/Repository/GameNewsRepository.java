package com.moesystems.gamenews.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.moesystems.gamenews.API.GamenewsAPI;
import com.moesystems.gamenews.DAOs.NewDAO;
import com.moesystems.gamenews.Database.GameNewsRoomDatabase;
import com.moesystems.gamenews.Entity.New;

import java.util.List;

public class GameNewsRepository {
    private NewDAO mNewDao;
    private List<New> mAllNews;
    private GamenewsAPI api;
    public GameNewsRepository(Application application){
        GameNewsRoomDatabase db = GameNewsRoomDatabase.getDatabase(application);
        mNewDao = db.newDAO();
        mAllNews = mNewDao.getAllNews();
    }
    public List<New> getAllNews(){
        return mAllNews;
    }
    public void insertNew(New news){
        new insertNewAsyncTask(mNewDao).execute(news);
    }
    private static class insertNewAsyncTask extends AsyncTask<New,Void,Void>{
        private NewDAO newDAO;

        public insertNewAsyncTask(NewDAO newDAO){
            this.newDAO = newDAO;
        }

        @Override
        protected Void doInBackground(final New... news) {
            newDAO.insertNew(news[0]);
            return null;
        }
    }
}

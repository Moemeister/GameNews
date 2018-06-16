package com.moesystems.gamenews.Database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.moesystems.gamenews.DAOs.NewDAO;
import com.moesystems.gamenews.DAOs.UserDAO;
import com.moesystems.gamenews.Entity.New;
import com.moesystems.gamenews.Entity.User;

@Database(entities = {New.class}, version = 3)
public abstract class GameNewsRoomDatabase extends RoomDatabase {
    public abstract NewDAO newDAO();
    private static GameNewsRoomDatabase INSTANCE;

    public static GameNewsRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (GameNewsRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                            GameNewsRoomDatabase.class,"gamenews_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static  RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();

        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void,Void,Void>{
        private final NewDAO mDao;
        PopulateDbAsync(GameNewsRoomDatabase db){
            mDao = db.newDAO();
        }
        @Override
        protected Void doInBackground(Void... voids) {
//            mDao.deleteAllNews();
//            New news =  new New("RIP GAMBLING",null,null,"lel","lorem impsum","csgo");
//            mDao.insertNew(news);
//            news =  new New("NO SE NADA DE LOL",null,null,"lel2","lorem impsum2","lol");
//            mDao.insertNew(news);
//            news =  new New("QUE ES DOTA :v",null,null,"lel3","lorem impsum3","dota");
//            mDao.insertNew(news);
              return null;
        }
    }
}

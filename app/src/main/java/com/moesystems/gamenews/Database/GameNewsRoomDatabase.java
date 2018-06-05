package com.moesystems.gamenews.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.moesystems.gamenews.DAOs.UserDAO;
import com.moesystems.gamenews.Entity.User;

@Database(entities = {User.class}, version = 1)
public abstract class GameNewsRoomDatabase extends RoomDatabase {
    public abstract UserDAO userDAO();
    private static GameNewsRoomDatabase INSTANCE;

    public static GameNewsRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (GameNewsRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                            GameNewsRoomDatabase.class,"gamenews_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

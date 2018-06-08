package com.moesystems.gamenews.DAOs;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.moesystems.gamenews.Entity.New;

import java.util.List;

@Dao
public interface NewDAO {
    @Insert
    void insertNew(New news);
    @Query("SELECT * FROM new")
    List<New> getAllNews();
    @Query("DELETE FROM new")
    void deleteAllNews();


}


package com.moesystems.gamenews.DAOs;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.moesystems.gamenews.Entity.User;

import java.util.List;
@Dao
public interface UserDAO {
    @Insert
    void insertUser(User user);
    @Update
    void modifyUser(User... users);
    @Query("SELECT * FROM user WHERE user = :username")
    User getUser(String username);
    @Query("SELECT * FROM user")
    LiveData<List<User>> getAllUsers();
}

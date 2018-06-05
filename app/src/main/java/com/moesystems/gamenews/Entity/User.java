package com.moesystems.gamenews.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.List;

@Entity(tableName = "user")
public class User {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "_id")
    private String id;
    @ColumnInfo(name = "user")
    private String username;
    @ColumnInfo(name = "password")
    private String password;
    @Ignore
    @ColumnInfo(name = "favoriteNews")
    private List<String> favorite =null;

    public User() {
    }

    public User(@NonNull String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;

    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite.add(favorite);
    }
}

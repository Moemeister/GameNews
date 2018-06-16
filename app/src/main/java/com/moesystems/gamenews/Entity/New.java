package com.moesystems.gamenews.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "new")
public class New {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo (name = "_id")
    private int id;
    private String title;
    private String coverImage;
    @ColumnInfo(name = "create_date")
    private String createDate;
    private String description;
    private String body;
    private String game;

    public New() {
    }

    public New( String title, String coverImage, String createDate, String description, String body, String game) {
        this.title = title;
        this.coverImage = coverImage;
        this.createDate = createDate;
        this.description = description;
        this.body = body;
        this.game = game;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }
}

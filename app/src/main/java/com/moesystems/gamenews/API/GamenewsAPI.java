package com.moesystems.gamenews.API;


import com.moesystems.gamenews.Data.Post;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface GamenewsAPI {

    @POST("/login")
    @FormUrlEncoded
    Call<Post> savePost(@Field("user") String user, @Field("password") String pass);

}

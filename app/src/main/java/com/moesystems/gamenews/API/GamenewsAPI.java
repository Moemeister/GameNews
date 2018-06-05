package com.moesystems.gamenews.API;

import java.security.Security;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface GamenewsAPI {
    String ENDPOINT = "http://gamenewsuca.herokuapp.com";
    @POST("/login")
    @FormUrlEncoded
    Single<Token> getToken(@Field("user")String username, @Field("password")String password);

}

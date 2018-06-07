package com.moesystems.gamenews.Data.Remote;

import com.moesystems.gamenews.API.GamenewsAPI;

public class Utils {
    private Utils() {}

    public static final String BASE_URL = "http://gamenewsuca.herokuapp.com/";

    public static GamenewsAPI getAPIService() {

        return RetroClient.getClient(BASE_URL).create(GamenewsAPI.class);
    }
}

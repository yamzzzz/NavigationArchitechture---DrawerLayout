package com.yamikrish.app.mvpapplication.repository;
/*
 * Created by Yamini on 24/5/18.
 */

import com.yamikrish.app.mvpapplication.utils.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {

    public static Retrofit getClient() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Utils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
        return builder.build();
    }
}

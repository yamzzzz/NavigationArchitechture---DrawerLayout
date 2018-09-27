package com.yamikrish.app.mvpapplication.repository;
/*
 * Created by Yamini on 24/5/18.
 */

import com.yamikrish.app.mvpapplication.users.model.data.User;
import com.yamikrish.app.mvpapplication.utils.Utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("users")
    Call<List<User>> getUser();
}

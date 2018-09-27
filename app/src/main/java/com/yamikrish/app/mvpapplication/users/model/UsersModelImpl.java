package com.yamikrish.app.mvpapplication.users.model;
/*
 * Created by Yamini on 24/5/18.
 */

import com.yamikrish.app.mvpapplication.repository.APIInterface;
import com.yamikrish.app.mvpapplication.repository.APIService;
import com.yamikrish.app.mvpapplication.users.model.data.User;
import com.yamikrish.app.mvpapplication.utils.Utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersModelImpl implements UsersModel{

    @Override
    public void getUsers(final Utils.CallBack<List<User>> callBack) {
        APIInterface apiInterface = APIService.getClient().create(APIInterface.class);
        apiInterface.getUser().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                callBack.success(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                callBack.connectionFailure(t);
            }
        });
    }
}

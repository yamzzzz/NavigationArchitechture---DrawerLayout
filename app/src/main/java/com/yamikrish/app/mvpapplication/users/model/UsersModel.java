package com.yamikrish.app.mvpapplication.users.model;
/*
 * Created by Yamini on 24/5/18.
 */

import com.yamikrish.app.mvpapplication.users.model.data.User;
import com.yamikrish.app.mvpapplication.utils.Utils;

import java.util.List;

public interface UsersModel {
     void getUsers(Utils.CallBack<List<User>> callBack);
}

package com.yamikrish.app.mvpapplication.users;
/*
 * Created by Yamini on 24/5/18.
 */

import com.yamikrish.app.mvpapplication.BasePresenter;
import com.yamikrish.app.mvpapplication.BaseView;
import com.yamikrish.app.mvpapplication.users.model.data.User;

import java.util.List;

public interface UsersConnector {
    interface Presenter extends BasePresenter {

        void loadUsers();

    }

    interface View extends BaseView<Presenter> {

        void setUsers(List<User> myUserList);

        void showToast(String message);
    }
}

package com.yamikrish.app.mvpapplication.users;
/*
 * Created by Yamini on 24/5/18.
 */

import com.yamikrish.app.mvpapplication.repository.APIService;
import com.yamikrish.app.mvpapplication.users.model.UsersModelImpl;
import com.yamikrish.app.mvpapplication.users.model.data.User;
import com.yamikrish.app.mvpapplication.utils.Utils;

import java.util.List;


public class UsersPresenter implements UsersConnector.Presenter {

    private UsersModelImpl model;
    private UsersConnector.View view;

    public UsersPresenter(UsersModelImpl _model, UsersConnector.View _view) {
        this.model = _model;
        this.view = _view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        loadUsers();
        //getUsers();
    }



    @Override
    public void loadUsers() {
        model.getUsers(new Utils.CallBack<List<User>>(){

            @Override
            public void success(List<User> objects) {
                view.setUsers(objects);

            }

            @Override
            public void responseFailure(List<User> objects) {
            }

            @Override
            public void connectionFailure(Throwable errorThrowable) {
                view.showToast(errorThrowable.getMessage());
            }
        });
    }
}

package com.yamikrish.app.mvpapplication.users;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yamikrish.app.mvpapplication.R;
import com.yamikrish.app.mvpapplication.users.model.UsersModelImpl;
import com.yamikrish.app.mvpapplication.utils.Utils;

public class UsersActivity extends AppCompatActivity {

    UsersFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(fragment == null){
            fragment = UsersFragment.newInstance();
            new UsersPresenter(new UsersModelImpl(), fragment);
            Utils.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.container);
        }
    }
}

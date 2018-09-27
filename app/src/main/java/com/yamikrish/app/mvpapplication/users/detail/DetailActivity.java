package com.yamikrish.app.mvpapplication.users.detail;
/*
 * Created by Yamini on 24/5/18.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yamikrish.app.mvpapplication.R;

import com.yamikrish.app.mvpapplication.utils.Utils;

public class DetailActivity extends AppCompatActivity {

    DetailFragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(fragment == null){
            fragment = DetailFragment.newInstance();
            Utils.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.container);
        }
    }
}

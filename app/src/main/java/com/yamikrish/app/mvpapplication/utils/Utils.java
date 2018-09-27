package com.yamikrish.app.mvpapplication.utils;
/*
 * Created by Yamini on 24/5/18.
 */

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class Utils {

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static void addFragmentToActivity(@Nullable FragmentManager fragmentManager, @Nullable Fragment fragment, int frameId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment);
        transaction.commit();
    }


    public interface CallBack<T> {
        void success(T objects);

        void responseFailure(T objects);

        void connectionFailure(Throwable errorThrowable);
    }
}

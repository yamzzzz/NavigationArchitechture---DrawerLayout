package com.yamikrish.app.mvpapplication;
/*
 * Created by Yamini on 24/5/18.
 */

public interface BaseView<T> {
    /**
     * To set the presenter for base View Connection
     *
     * @param presenter presenter
     */
    void setPresenter(T presenter);
}

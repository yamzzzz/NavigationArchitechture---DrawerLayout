package com.yamikrish.app.navigationDemo.ui.profile

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.yamikrish.app.navigationDemo.model.User
import com.yamikrish.app.navigationDemo.repository.APIService

/* 
 * Created by Yamini on 15/5/18.
 */

class ProfileViewModel  : ViewModel() {
    var post: LiveData<User>

    init {
        post =  APIService.getUser()
    }

    fun fetchUser() : LiveData<User> = post
}
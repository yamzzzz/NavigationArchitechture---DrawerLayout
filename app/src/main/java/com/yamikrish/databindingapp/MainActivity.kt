package com.yamikrish.databindingapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.yamikrish.databindingapp.databinding.ActivityMainBinding
import android.databinding.DataBindingUtil
import com.yamikrish.databindingapp.handler.ClickHandlers
import com.yamikrish.databindingapp.model.User
import com.yamikrish.databindingapp.model.UserModel


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val user = UserModel()
        user.name = "Yami"
        user.mobile = "919999999999"
        binding.user = user

        val handlers =  ClickHandlers(this)
        binding.handler = handlers
    }
}

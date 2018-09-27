package com.yamikrish.app.navigationDemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.base_activity.*

class BaseActivity : AppCompatActivity() {

    //lateinit var controller: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_activity)

        // controller = supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment

        val controller = Navigation.findNavController(this, R.id.container)
        NavigationUI.setupWithNavController(bottomTab, controller)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.container).navigateUp()
    }

}

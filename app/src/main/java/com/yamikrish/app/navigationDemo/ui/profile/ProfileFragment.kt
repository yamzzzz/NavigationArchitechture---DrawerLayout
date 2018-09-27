package com.yamikrish.app.navigationDemo.ui.profile

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yamikrish.app.navigationDemo.R
import com.yamikrish.app.navigationDemo.model.User
import kotlinx.android.synthetic.main.profile_fragment.*

/* 
 * Created by Yamini on 15/5/18.
 */

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel
    lateinit var data: User


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        viewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)

        viewModel.fetchUser().observe(this, object : Observer<User> {
            override fun onChanged(t: User?) {
                Log.v("users", "users==" + t)
                setDataOnUI(t)
            }

        })


    }

    private fun setDataOnUI(user: User?) {
        user?.let {
            name.text = it.name
            email.text = it.email
            phone.text = it.phone
            address.text = it.address.suite + ", " + it.address.street+ ", " +
                    it.address.city+ " - " + it.address.zipcode
        }

    }

}

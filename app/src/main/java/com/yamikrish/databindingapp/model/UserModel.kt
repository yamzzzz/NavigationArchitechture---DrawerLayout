package com.yamikrish.databindingapp.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableField
import com.yamikrish.databindingapp.BR

/* 
 * Created by Yamini on 7/5/18.
 */

class UserModel {
    val _name = ObservableField<String>()
    var name: String?
        get() = _name.get()
        set(value) = _name.set(value)

    val _mobile = ObservableField<String>()
    var mobile: String?
        get() = _mobile.get()
        set(value) = _mobile.set(value)
}
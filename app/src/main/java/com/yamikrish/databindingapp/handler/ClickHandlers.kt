package com.yamikrish.databindingapp.handler

import android.app.Dialog
import android.content.Context
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.yamikrish.databindingapp.R
import com.yamikrish.databindingapp.model.UserModel

/* 
 * Created by Yamini on 4/5/18.
 */

class ClickHandlers(val context: Context) {
    fun onClicked(view: View, user: UserModel) {
        val dialog = Dialog(context)
        dialog.apply {
            setTitle(context.getString(R.string.update))
            setContentView(R.layout.edit_dialog)
            val inputName = findViewById<EditText>(R.id.input_name)
            val inputMobile = findViewById<EditText>(R.id.input_mobile)
            val updateMobile = findViewById<TextView>(R.id.update_mobile)
            updateMobile.setOnClickListener {
                if (inputMobile.text.toString().trim().length > 0 && inputName.text.toString().trim().length > 0){
                    user.name = inputName.text.toString().trim()
                    user.mobile = inputMobile.text.toString().trim()
                    dismiss()
                }else{
                    Toast.makeText(context, context.getString(R.string.fill_field),Toast.LENGTH_SHORT).show()
                }
            }
            show()
        }
    }
}
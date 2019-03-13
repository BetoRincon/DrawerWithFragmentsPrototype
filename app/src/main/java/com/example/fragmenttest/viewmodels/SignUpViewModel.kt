package com.example.fragmenttest.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log

class SignUpViewModel: ViewModel(){

    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

     var userNickName: String? = null
     var userName: String? = null
        set(value) {
            field = "hola $value-Jobber"
        }
     var userSurname: String? = null
     var userMail: String? = null
     var userPassword: String? = null
     var userPasswordConfirm: String? = null

    fun saludar(){
        Log.d("Test","asdasdasd")
    }

}
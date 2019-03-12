package com.example.fragmenttest


import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmenttest.viewmodels.SignUpViewModel
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    val vm: SignUpViewModel by lazy { ViewModelProviders.of(this).get(SignUpViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        sign_in.setOnClickListener {
            signIn()
        }
    }

    fun signIn(){
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }
}

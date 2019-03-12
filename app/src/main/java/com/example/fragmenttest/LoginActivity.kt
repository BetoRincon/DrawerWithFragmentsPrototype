package com.example.fragmenttest


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        sign_up.setOnClickListener{
            signUp()
        }
    }



    fun signUp(){
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }
}

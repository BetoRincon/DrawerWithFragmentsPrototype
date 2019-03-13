package com.example.fragmenttest


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmenttest.models.User
import kotlinx.android.synthetic.main.login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

//        val intent = getIntent()
//        val user: User = intent.getParcelableExtra("Nombre")
//
//        et_User.setText(user.name)

        sign_up.setOnClickListener{
            signUp()
        }

        bt_login.setOnClickListener{
            signIn()
        }
    }


    fun signIn(){
        val intentHome = Intent(this,MainActivity::class.java)
        startActivity(intentHome)
    }

    fun signUp(){
        val intentSignUp = Intent(this, SignUpActivity::class.java)
        startActivity(intentSignUp)
    }
}

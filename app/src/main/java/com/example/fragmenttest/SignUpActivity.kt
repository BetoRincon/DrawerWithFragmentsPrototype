package com.example.fragmenttest


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.fragmenttest.viewmodels.SignUpViewModel
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    val vm: SignUpViewModel by lazy { ViewModelProviders.of(this).get(SignUpViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        // get the viewModel

        // Create the Observer
        val nameObserver = Observer<String> { newName ->
            // Update the UI, in this case, a TextView.
            et_User.setText(newName)
        }

        vm.currentName.observe(this,nameObserver)
        et_userName.addTextChangedListener( object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var anotherName = et_userName.text.toString()
                vm.currentName.setValue(anotherName)
            }

        })

        sign_in.setOnClickListener {

            vm.userName = et_userName.text.toString()

            Toast.makeText(this,vm.userName,Toast.LENGTH_LONG).show()
            signIn()
        }


    }

    fun signIn(){
        val intent = Intent(this,LoginActivity::class.java)
        //intent.putExtra("Nombre",vm.userName)
        startActivity(intent)

    }
}

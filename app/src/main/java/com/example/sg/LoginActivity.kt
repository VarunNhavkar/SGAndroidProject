package com.example.sg

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.sg.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    lateinit var sharedPreferences: SharedPreferences

    var PREFS_KEY = "prefs"
    var UNAME_KEY = "username"
    var PWD_KEY = "pwd"

    var username = ""
    var pwd = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val uname = binding.username.text.toString()
        val pass = binding.password.text.toString()

        sharedPreferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)

        username = sharedPreferences.getString(UNAME_KEY, "").toString()
        pwd = sharedPreferences.getString(PWD_KEY, "").toString()


        binding.btnlogin.setOnClickListener(View.OnClickListener {
            if (binding.username.text.toString() == "sguser" && binding.password.text.toString() == "password") {

                // on below line we are creating variable for editor
                // of shared prefs and initializing it.
                val editor: SharedPreferences.Editor = sharedPreferences.edit()

                // on below line we are adding our email and
                // pwd to shared prefs to save them.
                editor.putString(UNAME_KEY, uname)
                editor.putString(PWD_KEY, pass)

                // on below line we are applying
                // changes to our shared prefs.
                editor.apply()


                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                Toast.makeText(this@LoginActivity, "Login Successful", Toast.LENGTH_SHORT).show()

            }
            else {
                binding.invalid.visibility = View.VISIBLE
            }


        })

    }

    override fun onStart() {
        super.onStart()
        // in this method we are checking if email and pwd are not empty.
        if (!username.equals("") && !pwd.equals("")) {
            // if email and pwd is not empty we
            // are opening our main 2 activity on below line.
            val i = Intent(this@LoginActivity, HomeActivity::class.java)

            // on below line we are calling start
            // activity method to start our activity.
            startActivity(i)

            // on below line we are calling
            // finish to finish our main activity.
            finish()
        }
    }



}
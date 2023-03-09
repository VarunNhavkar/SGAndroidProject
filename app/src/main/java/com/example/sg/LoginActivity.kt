package com.example.sg

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.sg.Session.LoginPref
import com.example.sg.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    private lateinit var etusername: EditText
    private lateinit var etpassword: EditText
    private lateinit var btnLogin: Button

    lateinit var session: LoginPref

//    lateinit var sharedPreferences: SharedPreferences
//
//    var PREFS_KEY = "prefs"
//    var UNAME_KEY = "username"
//    var PWD_KEY = "pwd"
//
//    var username = ""
//    var pwd = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //-------------------------

        session = LoginPref(this)

        if (session.isLoggedIn()) {
            var i: Intent = Intent(applicationContext, HomeActivity::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)
            finish()
        }

        etusername = binding.etusername
        etpassword = binding.etpassword
        btnLogin = binding.btnlogin

        btnLogin.setOnClickListener {
            var username = etusername.text.toString().trim()
            var password = etpassword.text.toString().trim()

            if (username == "sguser" && password == "password") {
                session.createLoginSession(username, password)
                var i: Intent = Intent(applicationContext, HomeActivity::class.java)
                startActivity(i)
                finish()
            } else
                binding.invalid.visibility = View.VISIBLE
        }


        //-------------------------


//        val uname = binding.etusername.text.toString()
//        val pass = binding.etpassword.text.toString()

//        sharedPreferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
//
//        username = sharedPreferences.getString(UNAME_KEY, "").toString()
//        pwd = sharedPreferences.getString(PWD_KEY, "").toString()


//        binding.btnlogin.setOnClickListener(View.OnClickListener {
//            if (binding.etusername.text.toString() == "sguser" && binding.etpassword.text.toString() == "password") {

//                // on below line we are creating variable for editor
//                // of shared prefs and initializing it.
//                val editor: SharedPreferences.Editor = sharedPreferences.edit()
//
//                // on below line we are adding our email and
//                // pwd to shared prefs to save them.
//                editor.putString(UNAME_KEY, uname)
//                editor.putString(PWD_KEY, pass)
//
//                // on below line we are applying
//                // changes to our shared prefs.
//                editor.apply()
//
//
//                val intent = Intent(this, HomeActivity::class.java)
//                startActivity(intent)
//                Toast.makeText(this@LoginActivity, "Login Successful", Toast.LENGTH_SHORT).show()
//
//            }
//            else {
//                binding.invalid.visibility = View.VISIBLE
//            }
//
//
//        })
//
//    }

//    override fun onStart() {
//        super.onStart()
//        // in this method we are checking if email and pwd are not empty.
//        if (!username.equals("") && !pwd.equals("")) {
//            // if email and pwd is not empty we
//            // are opening our main 2 activity on below line.
//            val i = Intent(this@LoginActivity, HomeActivity::class.java)
//
//            // on below line we are calling start
//            // activity method to start our activity.
//            startActivity(i)
//
//            // on below line we are calling
//            // finish to finish our main activity.
//            finish()
//        }
//    }
    }


}
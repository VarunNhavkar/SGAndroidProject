package com.example.sg

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.content.SharedPreferences
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil.setContentView
import com.example.sg.databinding.ActivityLoginBinding
import com.example.sg.databinding.FragmentProfileBinding

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class Profile : Fragment() {

    lateinit var binding : FragmentProfileBinding
    lateinit var sharedPreferences: SharedPreferences


    lateinit var userTV: TextView
    lateinit var logoutBtn: Button
    var PREFS_KEY = "prefs"
    var UNAME_KEY = "username"
    var username = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = FragmentProfileBinding.inflate(layoutInflater)
        

        val usertxt = binding.idTVUserName
        val logout = binding.idBtnLogOut

        // on below line we are initializing our shared preferences variable.
        //sharedPreferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)



        username = sharedPreferences.getString(UNAME_KEY, null)!!

        // on below line we are setting a text to user text view.
        userTV.setText("Welcome \n$username")

        binding.idBtnLogOut.setOnClickListener(View.OnClickListener {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()

            // on below line we are clearing our editor.
            editor.clear()

            // on below line we are applying changes which are cleared.
            editor.apply()

           // val i = Intent(this, LoginActivity::class.java)

            //startActivity(i)
        })


    }



}
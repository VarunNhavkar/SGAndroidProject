package com.example.sg

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.sg.Session.LoginPref
import com.example.sg.databinding.ActivityLoginBinding
import com.example.sg.databinding.FragmentProductsBinding
import com.example.sg.databinding.FragmentProfileBinding

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class Profile : Fragment() {


    private lateinit var tvUsername : TextView
    private lateinit var btnLogout : Button

    lateinit var session : LoginPref
//    lateinit var sharedPreferences: SharedPreferences
//
//
//    lateinit var userTV: TextView
//    lateinit var logoutBtn: Button
//    var PREFS_KEY = "prefs"
//    var UNAME_KEY = "username"
//    var username = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        

//        val usertxt = binding.idTVUserName
//        val logout = binding.idBtnLogOut
//
//        // on below line we are initializing our shared preferences variable.
//        //sharedPreferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
//
//
//
//        username = sharedPreferences.getString(UNAME_KEY, null)!!
//
//        // on below line we are setting a text to user text view.
//        userTV.setText("Welcome \n$username")
//
//        binding.idBtnLogOut.setOnClickListener(View.OnClickListener {
//            val editor: SharedPreferences.Editor = sharedPreferences.edit()
//
//            // on below line we are clearing our editor.
//            editor.clear()
//
//            // on below line we are applying changes which are cleared.
//            editor.apply()
//
//           // val i = Intent(this, LoginActivity::class.java)
//
//            //startActivity(i)
//        })


    }

    private var _binding : FragmentProfileBinding? = null
    private val binding : FragmentProfileBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        session = LoginPref(requireContext())

        tvUsername = binding.tvUserName
        btnLogout = binding.btnLogOut

        session.checkLogin()

        var user: HashMap<String, String> = session.getUserDetails()

        var username = user.get(LoginPref.KEY_USERNAME)

        tvUsername.setText(username)

        btnLogout.setOnClickListener {
            session.logoutUser()
        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}
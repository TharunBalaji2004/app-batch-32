package com.tharunbalaji.appbatch32

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tharunbalaji.appbatch32.databinding.ActivitySignupBinding

class SignupActivity: AppCompatActivity() {

    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // STEP 1: Create an instance of shared preferences
        val sharedPreferences = getSharedPreferences("USER", Context.MODE_PRIVATE)
        // STEP 2: Get the editor
        val editor = sharedPreferences.edit()

        binding.btnSignup.setOnClickListener {
            val emailAddress = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            //STEP 3: Put the value
            editor.putBoolean("isLoggedin", true)
            // STEP 4: Permanently store the value in phone storage
            editor.apply()

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

            Log.d("SIGNUP PAGE", "EMAIL: $emailAddress PASSWORD: $password")
        }

    }
}
package com.tharunbalaji.appbatch32

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tharunbalaji.appbatch32.databinding.ActivityLoginBinding

class LoginActivity: AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding // Declare

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater) // Define
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("USER", Context.MODE_PRIVATE)
        val isLoggedin = sharedPreferences.getBoolean("isLoggedin", false)

        if (isLoggedin) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val emailAddress = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (formValidation(emailAddress, password)) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }

            Log.d("LOGIN PAGE", "EMAIL: $emailAddress PASSWORD: $password")
        }

        binding.btnSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun formValidation(emailAddress: String, password: String) : Boolean {
        var validate = true

        // regex

        if (emailAddress.isEmpty()) {
            binding.tvErrorEmail.text = "Email address cannot be empty"
            validate = false
        } else if (!emailAddress.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$".toRegex())) {
            binding.tvErrorEmail.text = "Invalid Email Address"
            validate = false
        } else {
            binding.tvErrorEmail.text = ""
        }

        if (password.isEmpty()) {
            binding.tvErrorPassword.text = "Password cannot be empty"
            validate = false
        } else if (password.length < 5) {
            binding.tvErrorPassword.text = "Password length cannot be less than 5"
            validate = false
        } else {
            binding.tvErrorPassword.text = ""
        }

        return validate
    }
}
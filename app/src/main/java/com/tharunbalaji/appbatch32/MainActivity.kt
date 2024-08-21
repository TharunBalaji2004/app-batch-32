package com.tharunbalaji.appbatch32

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

// ANDROID BASICS DAY 2
// Intent (contd..), ViewBinding, Login Page Validation, Shared Preferences

class MainActivity : AppCompatActivity() {

    lateinit var btnHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHome = findViewById(R.id.btn_home)

        btnHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("name","Tharun")
            intent.putExtra("age", 21)
            intent.putExtra("gender", 'M')
            intent.putExtra("fees", true)
            startActivity(intent)
            finish()
        }

        Log.d("THARUN", "onCreate function called")
    }

    override fun onStart() {
        super.onStart()
        Log.d("THARUN", "onStart function called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("THARUN", "onResume function called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("THARUN", "onRestart function called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("THARUN", "onPause function called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("THARUN", "onStop function called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("THARUN", "onDestroy function called")
    }
}
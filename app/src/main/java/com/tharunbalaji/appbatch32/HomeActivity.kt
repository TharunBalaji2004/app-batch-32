package com.tharunbalaji.appbatch32

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class HomeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val name = intent.getStringExtra("name") ?: "balaji"
        val age = intent.getIntExtra("age", 0)
        val gender = intent.getCharExtra("gender", 'M')
        val fees = intent.getBooleanExtra("fees", false)

    }
}
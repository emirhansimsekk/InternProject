package com.emirhansimsek.internproject.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.emirhansimsek.internproject.R

class profileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val intent = intent
        val name_surname = intent.getStringExtra("name_surname")
        val age = intent.getStringExtra("age")
        val phone_number = intent.getStringExtra("phone_number")
        val email = intent.getStringExtra("email")
        val birthdate = intent.getStringExtra("birthdate")

        findViewById<TextView>(R.id.fullName).text = name_surname
    }
}
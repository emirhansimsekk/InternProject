package com.emirhansimsek.internproject.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.emirhansimsek.internproject.R

class profileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        this.setTitle("Profile")
        val intent = intent
        var name = " "
        var surname = " "
        val name_surname = intent.getStringExtra("name_surname")
        val age = intent.getStringExtra("age")
        val phone_number = intent.getStringExtra("phone_number")
        val email = intent.getStringExtra("email")
        val birthdate = intent.getStringExtra("birthdate")

        findViewById<TextView>(R.id.fullName).text = name_surname
        findViewById<TextView>(R.id.age).text = "${age} years old"
        val parts= name_surname?.split(" ")
        if (parts != null) {
            name= parts[0]
            surname=parts[1]
        }

        findViewById<TextView>(R.id.name).text= name
        findViewById<TextView>(R.id.surname).text= surname
        findViewById<TextView>(R.id.phone_number).text = phone_number
        findViewById<TextView>(R.id.email).text = email
        findViewById<TextView>(R.id.birthdate).text = birthdate

        val firstLetter = name.get(0)
        findViewById<TextView>(R.id.num_txt).text = firstLetter.toString()
    }
}
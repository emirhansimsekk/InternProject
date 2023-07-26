package com.emirhansimsek.internproject.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.emirhansimsek.internproject.R
import com.emirhansimsek.internproject.databinding.ActivityProfileBinding

class profileActivity : AppCompatActivity() {
    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.setTitle("Profile")
        val intent = intent
        var name = " "
        var surname = " "
        val name_surname = intent.getStringExtra("name_surname")
        val age = intent.getStringExtra("age")
        val phone_number = intent.getStringExtra("phone_number")
        val email = intent.getStringExtra("email")
        val birthdate = intent.getStringExtra("birthdate")

        binding.fullName.text = name_surname

        binding.age.text = "${age} years old"
        val parts= name_surname?.split(" ")
        if (parts != null) {
            name= parts[0]
            surname=parts[1]
        }

        binding.name.text= name
        binding.surname.text= surname
        binding.phoneNumber.text = phone_number
        binding.email.text = email
        binding.birthdate.text = birthdate

        val firstLetter = name.get(0)
        binding.numTxt.text = firstLetter.toString()


       /* navHostFragment =
            supportFragmentManager.findFragmentById(R.id.manFragment) as NavHostFragment


        navController = navHostFragment.findNavController()
        setupActionBarWithNavController(navController)*/

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        val intent =Intent(this, ManFragment::class.java)
        startActivity(intent)
    }
}
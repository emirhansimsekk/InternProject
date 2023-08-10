package com.emirhansimsek.internproject.View

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneNumberUtils
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.room.Room
import com.emirhansimsek.internproject.Controller.CelebrityDatabase
import com.emirhansimsek.internproject.Model.Celebrity
import com.emirhansimsek.internproject.R
import com.emirhansimsek.internproject.databinding.ActivityProfileBinding
import java.util.*

class profileActivity : AppCompatActivity() {
    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController
    private lateinit var binding: ActivityProfileBinding
    val SPREFS: String = "btn_prefs"
    val BTN_STATE:String = "btn_state"

    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var btn_state: Boolean
        this.setTitle("Profile")
        val intent = intent
        var name = " "
        var surname = " "
        val name_surname = intent.getStringExtra("name_surname")
        val age = intent.getStringExtra("age")
        val phone_number = intent.getStringExtra("phone_number")
        val email = intent.getStringExtra("email")
        val birthdate = intent.getStringExtra("birthdate")
        val gender = intent.getStringExtra("gender")
        val image = intent.getStringExtra("image")
        val position = intent.getStringExtra("position")

        binding.fullName.text = name_surname

        binding.age.text = "${age} years old"
        val parts= name_surname?.split(" ")
        if (parts != null) {
            name= parts[0]
            surname=parts[1]
        }


        binding.name.text= name
        binding.surname.text= surname
        binding.phoneNumber.text = phone_number?.let { formatNumber(it) }
        binding.email.text = email
        binding.birthdate.text = birthdate

        val firstLetter = name.get(0)
        binding.numTxt.text = firstLetter.toString()

        val celebrity = Celebrity.User.Celebrities(name+" "+ surname,age
            ,gender,phone_number,email,birthdate,image)


        val celebrityDatabase = Room.databaseBuilder(this,CelebrityDatabase::class.java,"celebritydb").
            allowMainThreadQueries().build()

        val celebrityCounter = celebrityDatabase.celebrityDao().getCelebrity(name+ " "+ surname)
        if(celebrityCounter != 0){
            binding.btnLike.isChecked = true
        }
        else{
            binding.btnLike.isChecked = false
        }





        binding.btnLike.setOnCheckedChangeListener { _, isChecked ->

            if(isChecked){
                //celebrityDatabase.celebrityDao().insert(celebrity)
                celebrityDatabase.celebrityDao().insert(celebrity)

                println(celebrity.celebrityID)

                /*editor.putBoolean(BTN_STATE,true)
                editor.apply()*/
                btn_state = true
            }
            else{
                celebrityDatabase.celebrityDao().delete(celebrity.name_surname)
                println(celebrity.celebrityID)

                /*editor.putBoolean(BTN_STATE,false)
                editor.apply()*/
                btn_state = false

            }

        }
        //binding.btnLike.isChecked = true
    }



    override fun onBackPressed() {

        val intent =Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun formatNumber(phone_number: String): String{
        val formattedNumber:String
        val countryCode = phone_number.substring(0,3)
        val provinceCode = phone_number.substring(4,7)
        val number = phone_number.substring(7)
        formattedNumber = "(${countryCode}) ${provinceCode} ${number}"


        return formattedNumber
    }

}
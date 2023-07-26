package com.emirhansimsek.internproject.View

import android.animation.Animator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView
import com.emirhansimsek.internproject.R

class LoadingScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading_screen)

        val intent = intent
        val name_surname = intent.getStringExtra("name_surname")
        val age = intent.getStringExtra("age")
        val phone_number = intent.getStringExtra("phone_number")
        val email = intent.getStringExtra("email")
        val birthdate = intent.getStringExtra("birthdate")


        val loadingAnimation = findViewById<LottieAnimationView>(R.id.lt_loadingAnimation)
        //loadingAnimation.repeatCount = 0


        loadingAnimation.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator) {
                //Do nothing
            }

            override fun onAnimationEnd(animation: Animator) {
                val intent = Intent(this@LoadingScreen, profileActivity::class.java)
                intent.putExtra("name_surname",name_surname)
                intent.putExtra("age",age)
                intent.putExtra("phone_number",phone_number)
                intent.putExtra("email",email)
                intent.putExtra("birthdate",birthdate)
                startActivity(intent)

            }

            override fun onAnimationCancel(animation: Animator) {
                //Do nothing
            }

            override fun onAnimationRepeat(animation: Animator) {
                //Do nothing
            }

        })
    }
}
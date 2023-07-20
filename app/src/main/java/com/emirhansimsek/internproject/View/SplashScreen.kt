package com.emirhansimsek.internproject.View

import android.animation.Animator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.airbnb.lottie.LottieAnimationView
import com.emirhansimsek.internproject.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val walkingAnimation = findViewById<LottieAnimationView>(R.id.lt_Animation)
        walkingAnimation.visibility = View.VISIBLE

        walkingAnimation.repeatCount = 1
        /*val timer = Handler()
       timer.postDelayed({
           walkingAnimation.visibility = View.GONE
           recyclerView.visibility = View.VISIBLE

       },1500)*/


        walkingAnimation.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator) {
                //Do nothing
            }

            override fun onAnimationEnd(animation: Animator) {
                val intent = Intent(this@SplashScreen,MainActivity::class.java)
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
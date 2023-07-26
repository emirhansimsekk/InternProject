package com.emirhansimsek.internproject.View

import android.animation.Animator
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.airbnb.lottie.LottieAnimationView
import com.emirhansimsek.internproject.R

class SplashScreen : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        val walkingAnimation = findViewById<LottieAnimationView>(R.id.lt_Animation)
        walkingAnimation.repeatCount = 0
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
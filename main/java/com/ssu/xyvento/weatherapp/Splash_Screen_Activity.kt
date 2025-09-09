package com.ssu.xyvento.weatherapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.view.animation.AnimationUtils
import com.ssu.xyvento.weatherapp.databinding.ActivitySplashScreenBinding

class Splash_Screen_Activity : AppCompatActivity() {
    private val binding: ActivitySplashScreenBinding by lazy {
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent  = Intent(this, Login_Screen_Activity::class.java)
            startActivity(intent)
            finish()
        },1800)


        val fadinanimation = AnimationUtils.loadAnimation(this,R.anim.fade_in_animation)

        val companyname = findViewById<TextView>(R.id.companyname)
        val sloganforcompany = findViewById<TextView>(R.id.textView7)
        val sponsername = findViewById<TextView>(R.id.footertext)


        companyname.startAnimation(fadinanimation)
        sloganforcompany.startAnimation(fadinanimation)
        sponsername.startAnimation(fadinanimation)
    }
}
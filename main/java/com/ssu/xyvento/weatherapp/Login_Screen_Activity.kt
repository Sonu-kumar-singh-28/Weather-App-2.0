package com.ssu.xyvento.weatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ssu.xyvento.weatherapp.databinding.ActivityLoginScreenBinding

class Login_Screen_Activity : AppCompatActivity() {
    private val binding: ActivityLoginScreenBinding by lazy {
        ActivityLoginScreenBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val getstartedbutton = findViewById<Button>(R.id.getstartedbutton)

        getstartedbutton.setOnClickListener {
            startActivity(Intent(this, Login2_Screen_Activity::class.java))
            finish()
        }
    }
}
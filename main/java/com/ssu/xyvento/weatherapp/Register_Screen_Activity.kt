package com.ssu.xyvento.weatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.ssu.xyvento.weatherapp.databinding.ActivityRegisterScreenBinding
import com.shashank.sony.fancytoastlib.FancyToast

class Register_Screen_Activity : AppCompatActivity() {
    private val binding: ActivityRegisterScreenBinding by lazy {
        ActivityRegisterScreenBinding.inflate(layoutInflater)
    }

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        val tvBackToLogin = findViewById<TextView>(R.id.tvBackToLogin)
        tvBackToLogin.setOnClickListener {
            startActivity(Intent(this, Login2_Screen_Activity::class.java))
            finish()
        }

        val btnRegister = findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener {

            val username = binding.nametextfield.editText?.text.toString().trim()
            val useremail = binding.emailtextfield.editText?.text.toString().trim()
            val userpassword = binding.passwordtextfield.editText?.text.toString().trim()
            val userrepeatpassword = binding.repeattextfield.editText?.text.toString().trim()

            if (username.isEmpty() || useremail.isEmpty() || userpassword.isEmpty() || userrepeatpassword.isEmpty()) {
                FancyToast.makeText(
                    this, "TextFields are Empty", FancyToast.LENGTH_SHORT,
                    FancyToast.ERROR, false
                ).show()
            } else if (userpassword != userrepeatpassword) {
                FancyToast.makeText(
                    this, "Passwords are not same", FancyToast.LENGTH_SHORT,
                    FancyToast.CONFUSING, false
                ).show()
            } else {
                auth.createUserWithEmailAndPassword(useremail, userpassword)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            FancyToast.makeText(
                                this, "Registered Successfully", FancyToast.LENGTH_SHORT,
                                FancyToast.SUCCESS, false
                            ).show()
                            startActivity(Intent(this, Login2_Screen_Activity::class.java))
                            finish()
                        } else {
                            FancyToast.makeText(
                                this, "Error: ${task.exception?.message}", FancyToast.LENGTH_SHORT,
                                FancyToast.WARNING, false
                            ).show()
                        }
                    }
            }
        }
    }
}

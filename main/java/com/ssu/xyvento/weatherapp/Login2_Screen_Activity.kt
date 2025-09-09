package com.ssu.xyvento.weatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.shashank.sony.fancytoastlib.FancyToast
import com.ssu.xyvento.weatherapp.databinding.ActivityLogin2ScreenBinding

class Login2_Screen_Activity : AppCompatActivity() {
    private val binding: ActivityLogin2ScreenBinding by lazy {
        ActivityLogin2ScreenBinding.inflate(layoutInflater)
    }

    private  lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        val SignuPOption = findViewById<TextView>(R.id.signupOption)

        SignuPOption.setOnClickListener {
            startActivity(Intent(this, Register_Screen_Activity::class.java))
            finish()
        }
        val LoginButton = findViewById<Button>(R.id.loginButton)

        LoginButton.setOnClickListener {
            val useremail = binding.emailtextfield.text.toString().trim()
            val userpassword = binding.passwordInputField.text.toString().trim()

            if (useremail.isEmpty() || userpassword.isEmpty()) {
                FancyToast.makeText(
                    this,
                    "Login UnsuccessFull",
                    FancyToast.LENGTH_SHORT,
                    FancyToast.ERROR,
                    false
                ).show()
            } else {
                auth.signInWithEmailAndPassword(useremail, userpassword)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            FancyToast.makeText(
                                this,
                                "Login SuccessFull",
                                FancyToast.LENGTH_SHORT,
                                FancyToast.SUCCESS,
                                false
                            ).show()
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        } else {
                            FancyToast.makeText(
                                this, "Error${task.exception?.message}", FancyToast.LENGTH_SHORT,
                                FancyToast.ERROR, false
                            ).show()
                        }
                    }
            }
        }

        val forgetpassword = findViewById<TextView>(R.id.forgotPassword)

        forgetpassword.setOnClickListener {
            startActivity(Intent(this, Forget_PassWord_Activity::class.java))
            finish()
        }

    }
}
package com.ssu.xyvento.weatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.shashank.sony.fancytoastlib.FancyToast
import com.ssu.xyvento.weatherapp.databinding.ActivityForgetPassWordBinding

class Forget_PassWord_Activity : AppCompatActivity() {

    private val binding: ActivityForgetPassWordBinding by lazy {
        ActivityForgetPassWordBinding.inflate(layoutInflater)
    }

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()

        val returnloginpage = findViewById<TextView>(R.id.txtbacktologin)
        returnloginpage.setOnClickListener {
            startActivity(Intent(this, Login2_Screen_Activity::class.java))
            finish()
        }

        val forgetmaterialbutton = findViewById<Button>(R.id.forgetmatrialbutton)

        forgetmaterialbutton.setOnClickListener {
            val emailtextfield = binding.forgetemailtextfield.editText?.text.toString().trim()

            if (emailtextfield.isEmpty()) {
                FancyToast.makeText(
                    this,
                    "Text Field is Empty",
                    FancyToast.LENGTH_SHORT,
                    FancyToast.ERROR,
                    false
                ).show()
            } else {
                // 🔑 Firebase built-in reset password email
                auth.sendPasswordResetEmail(emailtextfield)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            FancyToast.makeText(
                                this,
                                "Password reset email sent. Please check your inbox.",
                                FancyToast.LENGTH_LONG,
                                FancyToast.SUCCESS,
                                false
                            ).show()
                        } else {
                            FancyToast.makeText(
                                this,
                                "Error: ${task.exception?.message}",
                                FancyToast.LENGTH_LONG,
                                FancyToast.ERROR,
                                false
                            ).show()
                        }
                    }
            }
        }
    }
}

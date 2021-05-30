package com.haeyum.loginassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
    }

    fun onClick(v: View) {
        when(v.id) {
            R.id.cl_welcome_signInWithGoogle -> {

            }

            R.id.tv_welcome_signUp -> {
                startActivity(Intent(this, SignUpActivity::class.java))
            }

            R.id.ll_welcome_alreadySignIn -> {
                startActivity(Intent(this, SignInActivity::class.java))
            }
        }
    }

    private fun initListener() {
        val clSignInWithGoogle: ConstraintLayout = findViewById(R.id.cl_welcome_signInWithGoogle)
        val tvSignUp: TextView = findViewById(R.id.tv_welcome_signUp)
        val llSignIn: LinearLayout = findViewById(R.id.ll_welcome_alreadySignIn)

        clSignInWithGoogle.setOnClickListener {

        }

        tvSignUp.setOnClickListener {

        }

        llSignIn.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }
}
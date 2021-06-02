package com.haeyum.loginassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged

class SignUpActivity : AppCompatActivity() {
    lateinit var edtUsername: EditText
    lateinit var edtPassword: EditText
    lateinit var edtConfirmPassword: EditText

    lateinit var ivCheckUsername: ImageView
    lateinit var ivCheckPassword: ImageView
    lateinit var ivCheckConfirmPassword: ImageView

    lateinit var btnSignUp: Button

    private val usernameLength = 4
    private val passwordLength = 8

    private val checkUsername: Boolean get() = edtUsername.text.toString().length >= usernameLength
    private val checkPassword: Boolean get() = edtPassword.text.toString().length >= passwordLength
    private val checkConfirmPassword: Boolean get() = edtPassword.text.toString() == edtConfirmPassword.text.toString()
    private val checkSignUp: Boolean get() = checkUsername && checkPassword && checkConfirmPassword

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        initUI()
        initListener()
    }

    private fun initUI() {
        edtUsername = findViewById(R.id.edt_signUp_username)
        edtPassword = findViewById(R.id.edt_signUp_password)
        edtConfirmPassword = findViewById(R.id.edt_signUp_confirmPassword)

        ivCheckUsername = findViewById(R.id.iv_signUp_checkUsername)
        ivCheckPassword = findViewById(R.id.iv_signUp_checkPassword)
        ivCheckConfirmPassword = findViewById(R.id.iv_signUp_checkConfirmPassword)

        btnSignUp = findViewById(R.id.btn_signUp)
    }

    private fun initListener() {
        edtUsername.doAfterTextChanged {
            ivCheckUsername.setImageResource(if(checkUsername) R.drawable.check else R.drawable.remove)
            updateSignUp()
        }

        edtPassword.doAfterTextChanged {
            ivCheckPassword.setImageResource(if(checkPassword) R.drawable.check else R.drawable.remove)
            ivCheckConfirmPassword.setImageResource(if(checkConfirmPassword) R.drawable.check else R.drawable.remove)
            updateSignUp()
        }

        edtConfirmPassword.doAfterTextChanged {
            ivCheckPassword.setImageResource(if(checkPassword) R.drawable.check else R.drawable.remove)
            ivCheckConfirmPassword.setImageResource(if(checkConfirmPassword) R.drawable.check else R.drawable.remove)
            updateSignUp()
        }
    }

    private fun updateSignUp() {
        btnSignUp.apply {
            alpha = if(checkSignUp) 1f else 0.3f
            isEnabled = checkSignUp
        }
    }

    fun onClick(v: View) {
        when(v.id) {
            R.id.btn_signUp -> {
                Toast.makeText(this, "회원가입 완료", Toast.LENGTH_SHORT).show()
            }

            R.id.iv_signUp_back -> {
                finish()
            }
        }
    }
}
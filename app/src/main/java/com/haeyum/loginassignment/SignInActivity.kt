package com.haeyum.loginassignment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.haeyum.loginassignment.MainApp.Companion.appPref
import com.haeyum.loginassignment.statusBarManager.StatusBarManager

class SignInActivity : AppCompatActivity() {
    lateinit var edtUsername: EditText
    lateinit var edtPassword: EditText
    lateinit var btnSignIn: Button

    var isCheckUsername = false
    var isCheckPassword = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        initUI()
        initListener()
    }

    fun onClick(v: View) {
        when(v.id) {
            R.id.btn_signIn -> {
                if(appPref.username == null || appPref.password == null)
                    ToastHelper.showToast("회원가입을 먼저 해주세요")
                else if(appPref.username == edtUsername.text.toString())
                    if(appPref.password == edtPassword.text.toString())
                        ToastHelper.showToast("로그인 성공!")
                    else
                        ToastHelper.showToast("잘못된 비밀번호 입니다")
                else
                    ToastHelper.showToast("존재하지 않는 사용자이름 입니다.")
            }

            R.id.ll_signIn_signUp -> {

            }
        }
    }

    private fun initUI() {
        initStatusBar()

        edtUsername = findViewById(R.id.edt_signIn_username)
        edtPassword = findViewById(R.id.edt_signIn_password)
        btnSignIn = findViewById(R.id.btn_signIn)
    }

    private fun initListener() {
        edtUsername.doAfterTextChanged {
            if(edtUsername.text.toString().length >= 4)
                isCheckUsername = true
            else
                isCheckUsername = false

            if(isCheckUsername && isCheckPassword)
                changeSignIn(true)
            else
                changeSignIn(false)
        }

        edtPassword.doAfterTextChanged {
            isCheckPassword = edtPassword.text.toString().length >= 4
            changeSignIn(isCheckUsername && isCheckPassword)
        }
    }

    private fun changeSignIn(isCheck: Boolean) {
        if(isCheck) {
            btnSignIn.alpha = 1f
            btnSignIn.isEnabled = true
        } else {
            btnSignIn.apply {
                alpha = 0.3f
                isEnabled = false
            }
        }
    }

    private fun initStatusBar() {
        StatusBarManager.changeStatusBarTransparentWithWhiteText(window)
    }
}
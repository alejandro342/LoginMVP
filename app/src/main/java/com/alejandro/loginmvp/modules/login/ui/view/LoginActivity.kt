package com.alejandro.loginmvp.modules.login.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.alejandro.loginmvp.databinding.ActivityLoginBinding
import com.alejandro.loginmvp.modules.login.logininterface.MyProgressBar
import com.alejandro.loginmvp.modules.login.presenter.LoginPresenter

class LoginActivity : AppCompatActivity(), MyProgressBar, View.OnClickListener {
    private var mBinding: ActivityLoginBinding? = null
    private var mLoginPresenter: LoginPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        val mView: View = mBinding!!.root
        setContentView(mView)
        mLoginPresenter = LoginPresenter(this, this)
        mBinding!!.btnLoginSession.setOnClickListener(this)
        mBinding!!.TxtRegister.setOnClickListener(this)
        mLoginPresenter!!.getUserFromSessionLogin()

    }

    override fun showProgressBar() {
        mBinding!!.myProgressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        mBinding!!.myProgressBar.visibility = View.GONE
    }

    override fun onClick(myItem: View?) {
        when (myItem) {
            mBinding!!.btnLoginSession -> mLoginPresenter?.validateData(
                mBinding!!.EmailLogin.text.toString().trim(),
                mBinding!!.PasswordLogin.text.toString().trim()
            )
            mBinding!!.TxtRegister -> mLoginPresenter?.goRegisterUser()
        }
    }

}

package com.alejandro.loginmvp.modules.login.presenter

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.alejandro.loginmvp.base.BasePresenter
import com.alejandro.loginmvp.models.ResponseHttp
import com.alejandro.loginmvp.models.Users
import com.alejandro.loginmvp.modules.login.logininterface.LoginInterface
import com.alejandro.loginmvp.modules.login.logininterface.MyProgressBar
import com.alejandro.loginmvp.providers.UsersProviders
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(mContext: Context, var mMyProgressBar: MyProgressBar) : LoginInterface,
    BasePresenter(mContext),
    MyProgressBar {

    override var mContext: Context? = null
    private var mUserProvider = UsersProviders()

   var mUsers=Users("sincere@april.biz","Bret")
    init {
        this.mContext = mContext
    }

    override fun validateData(mEmail: String, mPassword: String): Boolean {
        if (mEmail.isEmpty()) {
            Toast.makeText(mContext, "Campo correo vacio", Toast.LENGTH_SHORT).show()
        } else if (!mEmail.mValidateEmail()) {
            Toast.makeText(mContext, "Correo no valido", Toast.LENGTH_SHORT).show()
            return false
        } else if (mPassword.isEmpty()) {
            Toast.makeText(mContext, "Campo contraseña vacio", Toast.LENGTH_SHORT).show()
        } else {
            mMyProgressBar.showProgressBar()
            mUserProvider.loginUsers(mEmail, mPassword)?.enqueue(object : Callback<Users> {
                override fun onResponse(call: Call<Users>,response: Response<Users>) {

                    Log.d("LoginPresenter", "Response: ${response.body()}")
                        if (response.body()?.email == mUsers.email && response.body()?.username == mUsers.username) {
                            response.body()?.toJson()?.let { saveUserSession(it) }
                        } else {
                        Toast.makeText(mContext, "Datos incorrectos", Toast.LENGTH_SHORT).show()
                    }
                    mMyProgressBar.hideProgressBar()
                }

                override fun onFailure(call: Call<Users>, t: Throwable) {
                    mMyProgressBar.hideProgressBar()
                    Toast.makeText(mContext, "Hubo un error", Toast.LENGTH_SHORT).show()
                }

            })
        }
        return true
    }

    override fun showProgressBar() {}

    override fun hideProgressBar() {}

    override fun goRegisterUser() = Toast.makeText(mContext, "Registrar", Toast.LENGTH_SHORT).show()

}


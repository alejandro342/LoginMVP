package com.alejandro.loginmvp.base

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import com.alejandro.loginmvp.modules.mainmenu.view.MainActivity
import com.alejandro.loginmvp.models.Users
import com.alejandro.loginmvp.utils.SharedPref
import com.google.gson.Gson

open class BasePresenter(mContext: Context) {
    open var mContext:Context?=null
    var mUser:Users?=null
    init {
    this.mContext=mContext
    }

    fun goToMainMenu(){
        val mIntent = Intent(mContext, MainActivity::class.java)
        mIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK //eliminar historial de pantallas
        mContext?.startActivity(mIntent)
    }
    fun String.mValidateEmail(): Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this)
            .matches()
    }
    fun saveUserSession(information: String) {

        val sharedPref = mContext?.let { SharedPref(it) }
        val gson = Gson()
        //aqui se almacena toda la informacion del usuario
        val user = gson.fromJson(information, Users::class.java)
        sharedPref?.saveSession("user", user)
        goToMainMenu()
    }

    fun getUserFromSession() {
        val sharedPref = mContext?.let { SharedPref(it) }
        val gson = Gson()

        if (!sharedPref?.getInformation("user").isNullOrBlank()) {
            //si el usuario esta en session
            mUser = gson.fromJson(sharedPref?.getInformation("user"), Users::class.java)
            // Log.d("TAG", "Usuario $user")
        }
    }

    fun getUserFromSessionLogin() {

        val sharedPref = mContext?.let { SharedPref(it) }
        val gson = Gson()

        if (!sharedPref?.getInformation("user").isNullOrBlank()) {
            //si el ususario esta en session
            mUser = gson.fromJson(sharedPref?.getInformation("user"), Users::class.java)

            goToMainMenu()

        }
    }


}
package com.alejandro.loginmvp.modules.mainmenu.presenter

import android.content.Context
import android.content.Intent
import com.alejandro.loginmvp.base.BasePresenter
import com.alejandro.loginmvp.modules.login.ui.view.LoginActivity
import com.alejandro.loginmvp.utils.SharedPref

class MainMenuPresenter(mContext: Context):BasePresenter(mContext) {
    override var mContext:Context?=null
    var mSharedPref=SharedPref(mContext)
    init {
        this.mContext=mContext
    }

    fun closeSession(){
        mSharedPref.closeSession("user")
        val mIntent = Intent(mContext, LoginActivity::class.java)
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK) //eliminar historial de pantallas
        mContext?.startActivity(mIntent)
    }

}
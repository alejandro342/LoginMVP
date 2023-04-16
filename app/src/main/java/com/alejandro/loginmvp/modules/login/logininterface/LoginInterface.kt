package com.alejandro.loginmvp.modules.login.logininterface

interface LoginInterface {
    fun goRegisterUser()
    fun validateData(mEmail: String, mPassword: String): Boolean
}
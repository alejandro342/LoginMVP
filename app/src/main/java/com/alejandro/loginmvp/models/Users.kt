package com.alejandro.loginmvp.models

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

class Users(
    @SerializedName("email") var email: String,
    @SerializedName("username") var username: String
) {

    fun toJson(): String {
        return Gson().toJson(this)
    }

    override fun toString(): String {
        return "Users(email=$email, username=$username)"
    }
}
package com.alejandro.loginmvp.models
import com.google.gson.annotations.SerializedName

class ResponseHttp (
    @SerializedName("email") val email: String,
    @SerializedName("username") val username: String
) {
    override fun toString(): String {
        return "ResponseHttp(email='$email', username='$username')"
    }

}
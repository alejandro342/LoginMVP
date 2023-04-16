package com.alejandro.loginmvp.routes


import com.alejandro.loginmvp.models.Users
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UsersRoutes {
    @FormUrlEncoded
    @POST("users")
    fun loginUser(
        @Field("email") email: String,
        @Field("username") username: String
    ): Call<Users>

}
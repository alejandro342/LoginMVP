package com.alejandro.loginmvp.providers

import com.alejandro.loginmvp.api.routes.ApiRoutes
import com.alejandro.loginmvp.models.ResponseHttp
import com.alejandro.loginmvp.models.Users
import com.alejandro.loginmvp.routes.UsersRoutes
import retrofit2.Call

class UsersProviders {
    private var usersRoutes: UsersRoutes? = null
    init {
        val api = ApiRoutes()
        usersRoutes = api.getUsersRoutes()
    }
    fun loginUsers(email: String, username: String): Call<Users>? {
        return usersRoutes?.loginUser(email, username)
    }
}
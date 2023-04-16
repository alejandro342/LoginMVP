package com.alejandro.loginmvp.api.routes

import com.alejandro.loginmvp.api.retrofit.RetrofitClient
import com.alejandro.loginmvp.routes.UsersRoutes

class ApiRoutes {
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private val retrofit = RetrofitClient()

    fun getUsersRoutes(): UsersRoutes {
        return retrofit.getClient(BASE_URL).create(UsersRoutes::class.java)
    }
}
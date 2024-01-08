package com.laxman.binarysemantics.network

import com.laxman.binarysemantics.model.UserResponse
import retrofit2.http.GET

interface ApiInterface {
    @GET("getUserData")
    suspend fun getUserDetails():UserResponse
}
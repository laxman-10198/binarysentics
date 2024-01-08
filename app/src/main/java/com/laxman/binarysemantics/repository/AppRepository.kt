package com.laxman.binarysemantics.repository

import com.laxman.binarysemantics.base.BaseRepository
import com.laxman.binarysemantics.network.ApiInterface
import javax.inject.Inject

class AppRepository  @Inject constructor(private val apiInterface: ApiInterface) :
    BaseRepository() {
    suspend fun getUser() = safeApiCall {
        apiInterface.getUserDetails()
    }
}
package com.laxman.binarysemantics.model

data class UserResponse(
    val status:Int?,
    val message:String?,
    val data: List<UserData>?
)
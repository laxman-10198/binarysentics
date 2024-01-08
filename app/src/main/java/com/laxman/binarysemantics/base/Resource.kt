package com.laxman.binarysemantics.base

sealed class Resource<out T> {
    data object Loading : Resource<Nothing>()
    data class Success<out T>(val value: T) : Resource<T>()
    data class Failure(val throwable: Throwable) : Resource<Nothing>()
}
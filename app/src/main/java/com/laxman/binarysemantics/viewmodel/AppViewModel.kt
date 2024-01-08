package com.laxman.binarysemantics.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.laxman.binarysemantics.base.Resource
import com.laxman.binarysemantics.model.UserData
import com.laxman.binarysemantics.model.UserResponse
import com.laxman.binarysemantics.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val appRepository: AppRepository):ViewModel(){
    /**user data*/
    private val _userLogin: MutableLiveData<Resource<UserResponse?>> = MutableLiveData()
    val userData: LiveData<Resource<UserResponse?>> get() = _userLogin
    suspend fun getUsers() {
        _userLogin.value = Resource.Loading
        _userLogin.value = appRepository.getUser()
    }
}

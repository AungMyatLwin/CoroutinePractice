package com.practice.coroutinepractice.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.coroutinepractice.room.ProfileEntity
import com.practice.coroutinepractice.room.Repository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MyViewModel(application: Application):AndroidViewModel(application) {
    val repository: Repository = Repository(application)
    private val _userList = MutableLiveData<List<ProfileEntity>?>()
    val userlist: MutableLiveData<List<ProfileEntity>?> = _userList

    fun getAllUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getAllUsers()
            _userList.postValue(result)
        }
    }

    fun insertUser(add:ProfileEntity){
        repository.inputUser(add)
    }
}
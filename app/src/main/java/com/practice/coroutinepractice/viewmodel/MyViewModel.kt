package com.practice.coroutinepractice.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.coroutinepractice.interfaces.Album
import com.practice.coroutinepractice.room.ProfileEntity
import com.practice.coroutinepractice.room.Repository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Response

class MyViewModel(application: Application):AndroidViewModel(application) {
    val repository: Repository = Repository(application)
    private val _userList = MutableLiveData<List<ProfileEntity>?>()
    val userlist: MutableLiveData<List<ProfileEntity>?> = _userList
    val mutableLiveDataResponse:MutableLiveData<Response<Album>> = MutableLiveData<Response<Album>>()
    private val _livedataResponse: LiveData<Response<Album>> = mutableLiveDataResponse

    fun getAllUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = async{
                repository.getAllUsers()
            }
            _userList.postValue(result.await())
        }
    }

    fun insertUser(add:ProfileEntity){
        repository.inputUser(add)
    }

    fun getData(){
        viewModelScope.launch (Dispatchers.IO){
            val test = async {
                repository.getData()
            }
            mutableLiveDataResponse.postValue(test.await())
        }
    }
}
package com.practice.coroutinepractice.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.coroutinepractice.room.ObjectsDao.SelectedObjects
import com.practice.coroutinepractice.room.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel:ViewModel() {
    val repository:Repository = Repository(application = Application())
    fun getAllUsers():List<String>{
        var li:List<String> = listOf("1","2")
        val ls = viewModelScope.launch(Dispatchers.IO) {
            repository.getAllUsers()
        }
        return li
    }
}
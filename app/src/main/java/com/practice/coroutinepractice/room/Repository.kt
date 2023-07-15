package com.practice.coroutinepractice.room

import android.app.Application
import com.practice.coroutinepractice.room.ObjectsDao.SelectedObjects
import kotlinx.coroutines.Deferred

class Repository(application: Application) {
    private var profileDao:ProfileDao?
    init {
        val db:ProfileDatabase?=
            ProfileDatabase.getDatabase(application)
        profileDao= db?.profileDao()
    }
    suspend fun getAllUsers(): List<SelectedObjects>? {
        return profileDao?.getAllUsers()
    }
}
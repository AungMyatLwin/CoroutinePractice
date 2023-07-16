package com.practice.coroutinepractice.room

import android.app.Application
import kotlinx.coroutines.Deferred

class Repository(application: Application) {
    private var profileDao:ProfileDao?
    init {
        val db:ProfileDatabase?=
            ProfileDatabase.getDatabase(application)
        profileDao= db?.profileDao()
    }
    suspend fun getAllUsers(): List<ProfileEntity>? {
        return profileDao?.getAllUsers()
    }
    fun inputUser( addUser:ProfileEntity): Unit? {
        return profileDao?.insertUsers(addUser)
    }
}
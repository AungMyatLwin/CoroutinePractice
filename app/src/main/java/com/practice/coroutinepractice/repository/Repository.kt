package com.practice.coroutinepractice.room

import android.app.Application
import com.practice.coroutinepractice.interfaces.Album
import com.practice.coroutinepractice.interfaces.AlbumService
import com.practice.coroutinepractice.interfaces.RetrofitInstance
import kotlinx.coroutines.Deferred
import retrofit2.Response

class Repository(application: Application) {
    private var profileDao:ProfileDao?
    private var response = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)
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

    suspend fun getData(): Response<Album> {
        return response.getAlbums()
    }

    suspend fun getAlbumTitle(id:Int):Response<Album>{
        return response.getQueryAlbum(id)
    }
}
package com.practice.coroutinepractice.interfaces

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {
    @GET("/albums")
    suspend fun getAlbums():Response<Album>

    @GET("/albums")
    suspend fun getQueryAlbum(@Query("id") id:Int):Response<Album>
}
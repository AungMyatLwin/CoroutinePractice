package com.practice.coroutinepractice.interfaces

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{
        val base_url="https://jsonplaceholder.typicode.com/"
        fun getRetrofitInstance(): Retrofit{
            return Retrofit.Builder().baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())).build()
        }
    }
}
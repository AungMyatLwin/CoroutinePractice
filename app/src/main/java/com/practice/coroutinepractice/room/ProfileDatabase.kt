package com.practice.coroutinepractice.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = ([ProfileEntity::class]), version = 1)
abstract class ProfileDatabase:RoomDatabase() {
    abstract fun profileDao():ProfileDao

    companion object{
        private var INSTANCE: ProfileDatabase?=null
        internal fun getDatabase(context: Context):ProfileDatabase?{
         if(INSTANCE == null){
             synchronized(ProfileDatabase::class.java){
                 if(INSTANCE == null){
                     INSTANCE = Room.databaseBuilder(
                         context.applicationContext,
                         ProfileDatabase::class.java,
                         "profile_database"
                     ).build()
                 }
             }
         }
            return INSTANCE
        }
    }
}
package com.practice.coroutinepractice.room

import androidx.room.*

@Dao
interface ProfileDao {

    @Query("SELECT * FROM Profile_Table")
    suspend fun getAllUsers():List<ProfileEntity>

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(profile:ProfileEntity)
}
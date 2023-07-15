package com.practice.coroutinepractice.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.practice.coroutinepractice.room.ObjectsDao.SelectedObjects

@Dao
interface ProfileDao {
    @Query("SELECT * FROM Profile_Table ")
    suspend fun getAllUsers():List<SelectedObjects>

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(profile:SelectedObjects)
}
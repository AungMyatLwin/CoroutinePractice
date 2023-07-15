package com.practice.coroutinepractice.room.ObjectsDao

import androidx.room.ColumnInfo

data class SelectedObjects(
    @ColumnInfo(name = "profile_id")
    val profile_id:Int,
    @ColumnInfo(name = "profile_name")
    val profile_name:Int,
    @ColumnInfo(name = "profile_age")
    val profile_age:Int
)
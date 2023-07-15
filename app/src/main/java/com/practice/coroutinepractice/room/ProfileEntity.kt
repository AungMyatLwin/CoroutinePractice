package com.practice.coroutinepractice.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "Profile_Table")
data class ProfileEntity(@PrimaryKey(autoGenerate = true)
                         @ColumnInfo(name= "profile_id")
                         var id:Int,
                         @ColumnInfo(name = "profile_name")
                         var name:String,
                         @ColumnInfo(name = "profile_age")
                         var age:Int)
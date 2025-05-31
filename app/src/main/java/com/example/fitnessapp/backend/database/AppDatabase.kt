package com.example.fitnessapp.backend.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import com.example.fitnessapp.backend.dao.UserDao
import com.example.fitnessapp.backend.model.User

@Database(
    entities = [User::class],
    version = 6,

)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}
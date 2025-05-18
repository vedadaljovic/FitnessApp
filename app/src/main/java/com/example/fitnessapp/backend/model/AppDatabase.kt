package com.example.fitnessapp.backend.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fitnessapp.backend.dao.UserDao

@Database(entities = [User::class], version = 1, exportSchema = false )
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

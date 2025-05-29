package com.example.fitnessapp

import android.app.Application
import androidx.room.Room
import com.example.fitnessapp.backend.database.AppDatabase

class MyApplication : Application() {
    lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java, "fitnessapp-database"
        ).build()
    }
}
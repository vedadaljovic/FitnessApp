package com.example.fitnessapp.backend.di

import android.content.Context
import androidx.room.Room
import com.example.fitnessapp.backend.dao.UserDao
import com.example.fitnessapp.backend.database.AppDatabase
import com.example.fitnessapp.backend.repository.UserRepository
import com.example.fitnessapp.backend.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    /**
     * Provide missing annotations for database instance...
     *
     * You should uncomment the below code and start working on it...
     */
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "fitness-app.db",
        ).fallbackToDestructiveMigration(true).build()
    }

    /**
     * Provide other functions that are gonna be used for dependency injection...
     */
    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao = appDatabase.userDao()

    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): UserRepository = UserRepositoryImpl(userDao)
}
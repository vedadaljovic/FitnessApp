package com.example.fitnessapp.backend.repository

import android.util.Log
import com.example.fitnessapp.backend.dao.UserDao
import com.example.fitnessapp.backend.model.User
import javax.inject.Inject


class UserRepositoryImpl @Inject constructor(private val userDao: UserDao): UserRepository {
    override suspend fun delete(entity: User) {
        return userDao.delete(entity)
    }

    override suspend fun insert(entity: User) {
        Log.d("UserRepositoryImpl", "Attempting to insert user: ${entity.email}")
        try {
            userDao.insert(entity)
            Log.d("UserRepositoryImpl", "User insertion successful for: ${entity.email}")
        } catch (e: Exception) {
            Log.e("UserRepositoryImpl", "Error inserting user: ${entity.email}", e)
            // Ovdje možete odlučiti da li želite da re-throwujete izuzetak
            // ili da ga obradite na neki drugi način
            throw e // Primjer: ponovno bacanje izuzetka da bi ViewModel bio svjestan greške
        }
    }

    override suspend fun update(entity: User) {
        return userDao.update(entity)
    }

    override suspend fun getUserById(id: Int): User? {
        return userDao.getUserById(id)
    }

    override suspend fun getUser(username: String, password: String): User? {
        Log.d("UserRepositoryImpl", "Attempting to get user. Username: '$username', Password: '$password'")
        val user = userDao.getUser(username, password)
        if (user != null) {
            Log.d("UserRepositoryImpl", "User found: ${user.email}")
        } else {
            Log.d("UserRepositoryImpl", "User not found for Username: '$username'")
        }
        return user
    }

    override suspend fun isSetupComplete(userId: Int): Boolean? {
        return userDao.isSetupComplete(userId)
    }

    override suspend fun updateGender(userId: Int, gender: String) {
        userDao.updateGender(userId, gender)
    }

}
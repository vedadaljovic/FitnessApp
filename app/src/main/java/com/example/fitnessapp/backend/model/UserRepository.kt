package com.example.fitnessapp.backend.model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(private val userDao: UserDao) {

    suspend fun insertUser(user: User) {
        withContext(Dispatchers.IO) {
            userDao.insertUser(user)
        }
    }

    suspend fun getUser(username: String, password: String): User? {
        return withContext(Dispatchers.IO) {
            userDao.getUser(username, password)
        }
    }
}


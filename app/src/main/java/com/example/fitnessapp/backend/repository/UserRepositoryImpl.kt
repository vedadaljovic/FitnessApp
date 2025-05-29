package com.example.fitnessapp.backend.repository

import com.example.fitnessapp.backend.dao.UserDao
import com.example.fitnessapp.backend.model.User
import javax.inject.Inject


class UserRepositoryImpl @Inject constructor(private val userDao: UserDao): UserRepository {
    override suspend fun delete(entity: User) {
        return userDao.delete(entity)
    }

    override suspend fun insert(entity: User) {
        return userDao.insert(entity)
    }

    override suspend fun update(entity: User) {
        return userDao.update(entity)
    }

    override suspend fun getUserById(id: Int): User? {
        return userDao.getUserById(id)
    }

    override suspend fun getUser(username: String, password: String): User? {
        return userDao.getUser(username, password)
    }

}
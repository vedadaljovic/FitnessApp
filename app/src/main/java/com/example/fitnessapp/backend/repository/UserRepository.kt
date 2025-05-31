package com.example.fitnessapp.backend.repository

import com.example.fitnessapp.backend.model.User

interface UserRepository : BaseRepository<User> {
    suspend fun getUserById(id: Int): User?

    suspend fun getUser(username: String, password: String): User?

    suspend fun isSetupComplete(userId: Int): Boolean?

    suspend fun updateGender(userId: Int, gender: String)

    suspend fun updateAge(userId: Int, age: Int)

    suspend fun updateWeight(userId: Int, weight: Double)

    suspend fun updateHeight(userId: Int, height: Double)
}
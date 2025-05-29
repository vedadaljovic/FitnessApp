package com.example.fitnessapp.backend.repository

import com.example.fitnessapp.backend.model.User

interface UserRepository : BaseRepository<User> {
    suspend fun getUserById(id: Int): User?

    suspend fun getUser(username: String, password: String): User?
}
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

    suspend fun updateGoal(userId: Int, goal: String)

    suspend fun updateActivityLevel(userId: Int, activityLevel: String)

    suspend fun updateUserProfileDetails(userId: Int, fullName: String?, nickname: String?, email: String?, mobileNumber: String?)

    suspend fun updateIsSetupComplete(userId: Int, isSetupComplete: Boolean)
}
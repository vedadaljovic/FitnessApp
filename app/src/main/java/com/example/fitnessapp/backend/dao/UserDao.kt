package com.example.fitnessapp.backend.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fitnessapp.backend.model.User
import com.example.fitnessapp.backend.dao.BaseDao

@Dao
interface UserDao : BaseDao<User>{
    @Query("SELECT * FROM users WHERE id = :id")
    suspend fun getUserById(id: Int): User?

    @Query("SELECT * FROM users WHERE (username = :username OR email = :username) AND password = :password")
    suspend fun getUser(username: String, password: String): User?

    @Query("SELECT isSetupComplete FROM users WHERE id = :userId")
    suspend fun isSetupComplete(userId: Int): Boolean?

    @Query("UPDATE users SET gender = :gender WHERE id = :userId")
    suspend fun updateGender(userId: Int, gender: String)

    @Query("UPDATE users SET age = :age WHERE id = :userId")
    suspend fun updateAge(userId: Int, age: Int)

    @Query("UPDATE users SET weight = :weight WHERE id = :userId")
    suspend fun updateWeight(userId: Int, weight: Double)

    @Query("UPDATE users SET height = :height WHERE id = :userId")
    suspend fun updateHeight(userId: Int, height: Double)
}
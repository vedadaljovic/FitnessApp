package com.example.fitnessapp.backend.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val username: String,
    val password: String,
    val email: String,
    val fullName: String,
    val nickname: String,
    val mobileNumber: String,
    val age: Int,
    val height: Double,
    val weight: Double,
    val gender: String,
    val activityLevel: String
)

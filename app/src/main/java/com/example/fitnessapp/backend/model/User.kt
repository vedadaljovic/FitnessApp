package com.example.fitnessapp.backend.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val username: String = "",
    val password: String,
    val email: String,
    val fullName: String = "",
    val nickname: String = "",
    val mobileNumber: String = "",
    val age: Int = 0,
    val height: Double = 0.0,
    val weight: Double = 0.0,
    val gender: String = "",
    val activityLevel: String = "",
    val isSetupComplete: Boolean = false,
    val goal: String = "",
)

package com.example.fitnessapp.backend.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.backend.model.User
import com.example.fitnessapp.backend.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser

    private val _loginErrorOccurred = MutableStateFlow<Boolean>(false)
    val loginErrorOccurred: StateFlow<Boolean> = _loginErrorOccurred

    private val _isSetupComplete = MutableStateFlow<Boolean?>(null)
    val isSetupComplete: StateFlow<Boolean?> = _isSetupComplete

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val user = userRepository.getUser(username, password)
            _currentUser.value = user
            if (user == null) {
                _loginErrorOccurred.value = true
            } else {
                val setupComplete = userRepository.isSetupComplete(user.id)
                _isSetupComplete.value = setupComplete
                Log.d("UserViewModel", "User setup complete status: $setupComplete")
            }
        }
    }

    fun resetLoginError() {
        _loginErrorOccurred.value = false
    }

    fun insertUser(user: User) {
        viewModelScope.launch {
            userRepository.insert(user)
            _isSetupComplete.value = false
            Log.d("UserViewModel", "User inserted - Email: ${user.email}, FullName: ${user.fullName}, SetupComplete: false")
        }
    }

    fun updateUserGender(userId: Int, gender: String) {
        viewModelScope.launch {
            try {
                userRepository.updateGender(userId, gender)
                Log.d("UserViewModel", "User gender updated for userId: $userId, gender: $gender")
            } catch (e: Exception) {
                Log.e("UserViewModel", "Error updating user gender for userId: $userId", e)
            }
        }
    }

    fun updateUserAge(userId: Int, age: Int) {
        viewModelScope.launch {
            try {
                userRepository.updateAge(userId, age)
                Log.d("UserViewModel", "User age updated for userId: $userId, age: $age")
            } catch (e: Exception) {
                Log.e("UserViewModel", "Error updating user age for userId: $userId", e)
            }
        }
    }

    fun updateUserWeight(userId: Int, weight: Double) {
        viewModelScope.launch {
            try {
                userRepository.updateWeight(userId, weight)
                Log.d("UserViewModel", "User weight updated for userId: $userId, weight: $weight")
            } catch (e: Exception) {
                Log.e("UserViewModel", "Error updating user weight for userId: $userId", e)
            }
        }
    }

    fun updateUserHeight(userId: Int, height: Double) {
        viewModelScope.launch {
            try {
                userRepository.updateHeight(userId, height)
                Log.d("UserViewModel", "User height updated for userId: $userId, height: $height")
            } catch (e: Exception) {
                Log.e("UserViewModel", "Error updating user height for userId: $userId", e)
            }
        }
    }

    fun updateUserGoal(userId: Int, goal: String) {
        viewModelScope.launch {
            try {
                userRepository.updateGoal(userId, goal)
                Log.d("UserViewModel", "User goal updated for userId: $userId, goal: $goal")
            } catch (e: Exception) {
                Log.e("UserViewModel", "Error updating user goal for userId: $userId", e)
            }
        }
    }

    fun updateUserActivityLevel(userId: Int, activityLevel: String) {
        viewModelScope.launch {
            try {
                userRepository.updateActivityLevel(userId, activityLevel)
                Log.d("UserViewModel", "User activity level updated for userId: $userId, activityLevel: $activityLevel")
            } catch (e: Exception) {
                Log.e("UserViewModel", "Error updating user activity level for userId: $userId", e)
            }
        }
    }

    fun updateUserProfileDetails(userId: Int, fullName: String?, nickname: String?, email: String?, mobileNumber: String?) {
        viewModelScope.launch {
            try {
                userRepository.updateUserProfileDetails(userId, fullName, nickname, email, mobileNumber)
                Log.d("UserViewModel", "User profile details updated for userId: $userId")
                 // Refresh currentUser to reflect changes in UI if needed immediately
                _currentUser.value = userRepository.getUserById(userId)
            } catch (e: Exception) {
                Log.e("UserViewModel", "Error updating user profile details for userId: $userId", e)
            }
        }
    }

    fun updateUserIsSetupComplete(userId: Int, isSetupComplete: Boolean) {
        viewModelScope.launch {
            try {
                userRepository.updateIsSetupComplete(userId, isSetupComplete)
                _isSetupComplete.value = isSetupComplete
                Log.d("UserViewModel", "User isSetupComplete updated for userId: $userId to $isSetupComplete")
            } catch (e: Exception) {
                Log.e("UserViewModel", "Error updating user isSetupComplete for userId: $userId", e)
            }
        }
    }
}

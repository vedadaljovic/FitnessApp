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
}

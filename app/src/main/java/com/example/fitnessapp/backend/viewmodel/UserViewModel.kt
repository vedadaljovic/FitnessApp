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

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val user = userRepository.getUser(username, password)
            _currentUser.value = user
            if (user == null) {
                _loginErrorOccurred.value = true
            }
        }
    }

    fun resetLoginError() {
        _loginErrorOccurred.value = false
    }

    fun insertUser(user: User) {
        viewModelScope.launch {
            userRepository.insert(user)
            Log.d("UserViewModel", "User inserted - Email: ${user.email}, FullName: ${user.fullName}")
        }
    }
}

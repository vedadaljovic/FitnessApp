package com.example.fitnessapp.backend.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.backend.model.User
import com.example.fitnessapp.backend.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    var currentUser: User? = null
        private set

    fun login(username: String, password: String) {
        viewModelScope.launch {
            currentUser = userRepository.getUser(username, password)
        }
    }

    fun insertUser(user: User) {
        viewModelScope.launch {
            userRepository.insert(user)
        }
    }
}

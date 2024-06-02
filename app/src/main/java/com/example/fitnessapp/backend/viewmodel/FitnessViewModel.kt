package com.example.fitnessapp.backend.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.backend.model.BmiRequest
import com.example.fitnessapp.backend.model.MealPlan
import com.example.fitnessapp.backend.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FitnessViewModel : ViewModel() {
    private val _mealPlans = MutableStateFlow<List<MealPlan>>(emptyList())
    val mealPlans: StateFlow<List<MealPlan>> get() = _mealPlans

    private val _bmi = MutableStateFlow<Float?>(null)
    val bmi: StateFlow<Float?> get() = _bmi

    init {
        fetchMealPlans()
    }

    private fun fetchMealPlans() {
        viewModelScope.launch {
            try {
                val plans = RetrofitInstance.api.getMealPlans()
                _mealPlans.value = plans
            } catch (e: Exception) {
                // Handle the error appropriately
            }
        }
    }

    fun calculateBmi(weight: Float, height: Float) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.calculateBmi(BmiRequest(weight, height))
                _bmi.value = response.bmi
            } catch (e: Exception) {
                // Handle the error appropriately
            }
        }
    }
}

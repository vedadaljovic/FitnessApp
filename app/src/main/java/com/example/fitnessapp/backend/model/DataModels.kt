package com.example.fitnessapp.backend.model

data class MealPlan(val id: Int, val name: String, val details: String)
data class BmiRequest(val weight: Float, val height: Float)
data class BmiResponse(val bmi: Float)
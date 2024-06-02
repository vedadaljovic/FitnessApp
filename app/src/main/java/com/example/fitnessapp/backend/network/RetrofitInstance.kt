package com.example.fitnessapp.backend.network

import com.example.fitnessapp.backend.model.BmiRequest
import com.example.fitnessapp.backend.model.BmiResponse
import com.example.fitnessapp.backend.model.MealPlan
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface FitnessApi {
    @GET("meal-plans")
    suspend fun getMealPlans(): List<MealPlan>

    @POST("bmi-calculator")
    suspend fun calculateBmi(@Body request: BmiRequest): BmiResponse
}

object RetrofitInstance {
    val api: FitnessApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/") // Use 10.0.2.2 to access localhost from Android emulator
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FitnessApi::class.java)
    }
}

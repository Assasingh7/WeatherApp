package com.google.weather.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance{
//    7aefaef5f21c43b7a9f123654240906
    private const val BASE_URL =" https://api.weatherapi.com"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
    val weatherApi:ApiInterface= getInstance().create(ApiInterface::class.java)
}
package com.google.weather.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/v1/current.json")
   suspend fun getWeather(@Query("key") apikey:String,@Query("q") city:String):Response<WeatherModel>
}
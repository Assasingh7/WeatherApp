package com.google.weather

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.weather.api.Constant
import com.google.weather.api.NetworkResponse
import com.google.weather.api.RetrofitInstance
import com.google.weather.api.WeatherModel
import kotlinx.coroutines.launch

class WeatherViewModel:ViewModel() {
    private val weatherApi=RetrofitInstance.weatherApi
    private val _weatherResult=MutableLiveData<NetworkResponse<WeatherModel>>()
    val weatherResult:LiveData<NetworkResponse<WeatherModel>> =_weatherResult

     @SuppressLint("SuspiciousIndentation")
     fun getData(city:String){
         _weatherResult.value=NetworkResponse.Loading
         viewModelScope.launch {

try {

    val response=  weatherApi.getWeather(Constant.api_key,city)
    if(response.isSuccessful){
        response.body()?.let {
            _weatherResult.value=NetworkResponse.Success(it)
        }
    }else{

        _weatherResult.value=NetworkResponse.Error("Failed to load data")
    }
}catch (e:Exception){
    _weatherResult.value=NetworkResponse.Error("Failed to load data")
}

         }
     }
}
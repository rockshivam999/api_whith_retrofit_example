package com.example.Restapiexample.Api

import retrofit2.Call
import retrofit2.http.GET

interface ApiViewHolder {

    @GET("photos")
    fun getImage():Call<List<ModelClass>>
}
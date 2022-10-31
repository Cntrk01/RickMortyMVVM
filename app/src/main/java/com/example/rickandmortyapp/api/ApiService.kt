package com.example.rickandmortyapp.api

import com.example.rickandmortyapp.models.ResponseApi
import com.example.rickandmortyapp.utils.Constants.END_POINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(END_POINT)
    suspend fun getAllCharacters(@Query("page") page:Int):Response<ResponseApi>
}
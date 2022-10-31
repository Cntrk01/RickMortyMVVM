package com.example.rickandmortyapp.di

import com.example.rickandmortyapp.api.ApiService
import com.example.rickandmortyapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun baseUrl()=BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(baseUrl:String):ApiService{
       return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
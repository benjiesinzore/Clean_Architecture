package com.benjaminsinzore.data.network.di

import com.benjaminsinzore.data.network.ApiService
import com.benjaminsinzore.data.repository.GetBlogsRepositoryImpl
import com.benjaminsinzore.domain.repository.GetBlogsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object DataModel {

    @Provides
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl("").addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit) : ApiService{
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideGetBlogsRepository(apiService : ApiService) : GetBlogsRepository{
        return GetBlogsRepositoryImpl(apiService = apiService)
    }
}
package com.benjaminsinzore.data.repository

import com.benjaminsinzore.data.mappers.toDomain
import com.benjaminsinzore.data.network.ApiService
import com.benjaminsinzore.data.network.utils.SafeApiRequest
import com.benjaminsinzore.domain.di.Blog
import com.benjaminsinzore.domain.repository.GetBlogsRepository
import retrofit2.Response
import javax.inject.Inject

class GetBlogsRepositoryImpl @Inject constructor(private val apiService: ApiService) : GetBlogsRepository, SafeApiRequest() {

    override suspend fun getBlogs(): List<Blog> {

        val response = safeApiRequest { apiService.getBlogs() }
        return response.data?.toDomain()?: emptyList()
    }

}
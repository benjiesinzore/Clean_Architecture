package com.benjaminsinzore.data.network

import com.benjaminsinzore.data.network.model.BlogsDTO
import retrofit2.Response

interface ApiService {

    suspend fun getBlogs() : Response<BlogsDTO>
}
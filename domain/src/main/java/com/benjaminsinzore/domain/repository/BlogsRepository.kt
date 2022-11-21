package com.benjaminsinzore.domain.repository

import com.benjaminsinzore.domain.di.Blog
import retrofit2.Response

interface BlogsRepository {

    suspend fun getBlogs() : Response<List<Blog>>
}
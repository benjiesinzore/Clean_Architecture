package com.benjaminsinzore.domain.repository

import com.benjaminsinzore.domain.di.Blog

interface GetBlogsRepository {

    suspend fun getBlogs() : List<Blog>
}
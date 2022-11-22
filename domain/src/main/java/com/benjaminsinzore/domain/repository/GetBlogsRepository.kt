package com.benjaminsinzore.domain.repository

import com.benjaminsinzore.domain.model.Blog

interface GetBlogsRepository {

    suspend fun getBlogs() : List<Blog>
}
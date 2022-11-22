package com.benjaminsinzore.data.network.model

data class BlogsDTO(
    val `data`: List<BlogDTO>?,
    val limit: Int?,
    val page: Int?,
    val total: Int?
)
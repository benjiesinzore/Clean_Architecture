package com.benjaminsinzore.data.network.model

data class CleanAppDTO(
    val id: String,
    val image: String,
    val likes: Int,
    val owner: OwnerDTO,
    val publishDate: String,
    val tags: List<String>,
    val text: String
)
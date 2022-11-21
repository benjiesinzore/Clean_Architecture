package com.benjaminsinzore.data.network.model

data class CleanAppsDTO(
    val `data`: List<CleanAppDTO>,
    val limit: Int,
    val page: Int,
    val total: Int
)
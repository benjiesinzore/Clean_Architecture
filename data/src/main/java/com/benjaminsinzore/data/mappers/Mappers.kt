package com.benjaminsinzore.data.mappers

import com.benjaminsinzore.data.network.model.BlogDTO
import com.benjaminsinzore.data.network.model.OwnerDTO
import com.benjaminsinzore.domain.di.Blog
import com.benjaminsinzore.domain.di.Owner

fun List<BlogDTO>.toDomain() : List<Blog>{

    return map {
        Blog(
            id = it.id,
            image = it.image,
            likes = it.likes,
            owner = it.owner.toDomain(),
            publishDate = it.publishDate,
            tags = it.tags,
            text = it.text
        )
    }
}

fun OwnerDTO.toDomain() : Owner {

    return Owner(
        firstName, id, lastName,
        picture, title
    )
}
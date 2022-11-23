package com.benjaminsinzore.domain.use_case

import com.benjaminsinzore.comons.Resource
import com.benjaminsinzore.domain.model.Blog
import com.benjaminsinzore.domain.repository.GetBlogsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetBlogsUseCase @Inject constructor(private val getBlogsRepository: GetBlogsRepository) {

    operator fun invoke() : Flow<Resource<List<Blog>>> = flow {

        emit(Resource.Loading(null))

        try {

            val response = getBlogsRepository.getBlogs()
            emit(Resource.Success(data = response))
        } catch (e : Exception){
            emit(Resource.Error("Error occurred, $e"))
        }
    }
}
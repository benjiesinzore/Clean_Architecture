package com.benjaminsinzore.domain.di

import com.benjaminsinzore.domain.repository.GetBlogsRepository
import com.benjaminsinzore.domain.use_case.GetBlogsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {


    @Provides
    fun provideGetBlogsUseCase(getBlogsRepository: GetBlogsRepository) : GetBlogsUseCase{
        return GetBlogsUseCase(getBlogsRepository)
    }
}
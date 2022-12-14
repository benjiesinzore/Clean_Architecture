package com.benjaminsinzore.cleanarchitectureappilication.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.benjaminsinzore.comons.Resource
import com.benjaminsinzore.domain.use_case.GetBlogsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getBlogsUseCase: GetBlogsUseCase) : ViewModel() {

    private val _blogs = mutableStateOf<HomeState>(HomeState())
    val blogs : State<HomeState> = _blogs

    fun getBlogs(){

        getBlogsUseCase().onEach {

            when(it){
                is Resource.Loading -> {

                    _blogs.value = HomeState(isLoading = true)
                }
                is Resource.Success -> {

                    _blogs.value = HomeState(data = it.data)
                }
                is Resource.Error -> {

                    _blogs.value = HomeState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}
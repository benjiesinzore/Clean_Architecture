package com.benjaminsinzore.cleanarchitectureappilication.screens.home

import com.benjaminsinzore.domain.model.Blog

data class HomeState (

    var isLoading : Boolean = false,
    var data : List<Blog> ?= null,
    var error : String = ""
)
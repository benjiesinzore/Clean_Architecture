package com.benjaminsinzore.cleanarchitectureappilication.navigation

sealed class NavigationItem (val route: String){

    object Home: NavigationItem("Home")
    object DetailedScreen: NavigationItem("Details")
}

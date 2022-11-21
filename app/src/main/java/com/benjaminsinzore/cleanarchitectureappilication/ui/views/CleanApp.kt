package com.benjaminsinzore.cleanarchitectureappilication.ui.views


import androidx.compose.material.Text
import androidx.compose.runtime.Composable


@Composable
fun CleanApp (
    name: String
){

    Text(text = "Hello Benjamin Sinzore? $name!")
}
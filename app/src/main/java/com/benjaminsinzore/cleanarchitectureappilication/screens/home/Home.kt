package com.benjaminsinzore.cleanarchitectureappilication.screens.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.benjaminsinzore.domain.model.Blog

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()){

    val res = viewModel.blogs.value

    if (res.isLoading){
        Box(modifier = Modifier.fillMaxSize()){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
    
    if (res.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize()){
            Text(text = res.error.toString(), modifier = Modifier.align(Alignment.Center))
        }
    }

    LazyColumn {

        res.data?.let{
            items(it){
                PostItem(it)
            }
        }
    }

}

@Composable
fun PostItem(it: Blog) {
    
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        
        Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {

            CircleImage(50.0, 50.0, 25.0, it.owner.picture)
        }
        
    }

}


@Composable
fun CircleImage(width : Double, height : Double, radius : Double, imageUrl : String){

    Card(modifier = Modifier
        .width(width = width.dp)
        .height(height = height.dp),
        shape = RoundedCornerShape(radius.dp)
    ) {
        Image(painter = rememberAsyncImagePainter(model = imageUrl), contentDescription = null,
        contentScale = ContentScale.Crop)
    }

}
package com.benjaminsinzore.cleanarchitectureappilication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.benjaminsinzore.cleanarchitectureappilication.navigation.NavigationItem
import com.benjaminsinzore.cleanarchitectureappilication.screens.home.HomeScreen
import com.benjaminsinzore.cleanarchitectureappilication.ui.theme.CleanArchitectureAppilicationTheme
import com.benjaminsinzore.cleanarchitectureappilication.ui.views.TestClass
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Turn off the decor fitting system windows, which allows us to handle insets,
        // including IME animations
//        WindowCompat.setDecorFitsSystemWindows(window, false)


        setContent {
            CleanArchitectureAppilicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val navController = rememberNavController()
                    MyApp {

                        NavHost(
                            navController = navController,
                            startDestination = NavigationItem.Home.route
                        ){

                            composable(NavigationItem.Home.route){
                                HomeScreen(navController = navController)
                            }


                        }
                    }

                }

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val ss = TestClass()
    val st = ss.testMethod(name)
    Text(text = "Hello $st")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CleanArchitectureAppilicationTheme {
        Greeting("Android")
    }
}




@Composable
fun MyApp(content : @Composable () -> Unit){
    content()
}
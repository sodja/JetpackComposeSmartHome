package com.codesodja.modernhomeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codesodja.modernhomeui.ui.screen.DetailScreen
import com.codesodja.modernhomeui.ui.screen.HomeScreen
import com.codesodja.modernhomeui.ui.theme.ModernHomeuiTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModernHomeuiTheme {
                ScreenNavigator()
                //HomeScreen()
                //DetailScreen()
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun ScreenNavigator() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("detail") { DetailScreen(navController) }
        /*composable("my_detail/{code}",
            arguments = listOf(navArgument("detailsContent") {
                type = NavType.StringType
            })) {backStackEntry ->
                backStackEntry.arguments?.getString("code")?.let {json->
                    DetailsItemSection(code = json)
                }
            }*/
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ModernHomeuiTheme {
        // Greeting("Android")
    }
}
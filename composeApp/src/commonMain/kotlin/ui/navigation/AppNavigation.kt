package ui.navigation

import androidx.compose.runtime.*
import moe.tlaster.precompose.navigation.*
import ui.screens.*

@Composable
fun AppNavigation() {
    val navigator = rememberNavigator()
    NavHost(navigator = navigator, initialRoute = NavigationRoute.Home.route){
        scene(route = NavigationRoute.Home.route){
            HomeScreen(navigator = navigator)
        }
    }
}

sealed class NavigationRoute(val route: String) {
    data object Home: NavigationRoute("home")
}
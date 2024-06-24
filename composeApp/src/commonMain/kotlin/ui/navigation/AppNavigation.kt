package ui.navigation

import androidx.compose.runtime.Composable
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import ui.screens.HomeScreen

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
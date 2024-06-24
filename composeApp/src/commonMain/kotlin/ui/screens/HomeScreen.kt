package ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import moe.tlaster.precompose.navigation.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.components.TopBar
import ui.theme.Body_Color
import ui.theme.PoppinsFamily
import ui.theme.TitleColor

@Composable
fun HomeScreen(
    navigator: Navigator
) {
    Scaffold(
        topBar = {
            TopBar()
        },
//        backgroundColor = Color(0xFF0A111E)
        backgroundColor = Body_Color
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Hello, I'm",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = TitleColor,
                fontFamily = PoppinsFamily()
            )
            Text(
                text = "Sharjeel Karim",
                fontSize = 40.sp,
                fontWeight = FontWeight.SemiBold,
                color = TitleColor,
                fontFamily = PoppinsFamily()
            )
            Text(
                text = "Software Developer",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = TitleColor,
                fontFamily = PoppinsFamily()
            )
        }
    }

}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(navigator = rememberNavigator())
}
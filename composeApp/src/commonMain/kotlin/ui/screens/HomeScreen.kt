package ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import models.*
import moe.tlaster.precompose.navigation.*
import ui.components.*
import ui.theme.*

@Composable
fun HomeScreen(
    navigator: Navigator,
    modifier: Modifier = Modifier
) {
    var deviceWidth by remember { mutableStateOf(0.dp) }
    val isMobile by remember { derivedStateOf { deviceWidth < 576.dp } }
    val isTablet by remember { derivedStateOf { deviceWidth > 576.dp && deviceWidth < 968.dp } }
    val isDesktop by remember { derivedStateOf { deviceWidth > 968.dp } }
    val responsive = Responsive(isMobile = isMobile, isTablet = isTablet, isDesktop = isDesktop)

    Scaffold(
        topBar = {
            TopBar(modifier = modifier)
        },
        backgroundColor = Body_Color
    ) {

        BoxWithConstraints {
            LaunchedEffect(this.maxWidth){
                deviceWidth = this@BoxWithConstraints.maxWidth
            }
            Column(
                modifier = modifier.fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(100.dp)
            ) {
                HomeSection(modifier = modifier)
                AboutMe(responsive = responsive, modifier = modifier)
                MySkills(responsive = responsive, modifier = modifier)
                RecentWorks(responsive = responsive, modifier = modifier)
                ContactMe(responsive = responsive, modifier = modifier)
                Footer(modifier = modifier, responsive = responsive)

            }
        }

    }
}
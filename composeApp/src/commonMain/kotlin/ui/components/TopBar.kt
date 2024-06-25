package ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.*
import kmmportfolioapp.composeapp.resources.*
import org.jetbrains.compose.resources.painterResource
import ui.theme.*

@Composable
fun TopBar(modifier: Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().height(100.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(Res.drawable.logo_capsule),
            contentDescription = "logo",
            modifier = modifier.fillMaxSize(),
            alignment = Alignment.CenterStart,
            colorFilter = ColorFilter.tint(FirstColor)
        )
    }

}
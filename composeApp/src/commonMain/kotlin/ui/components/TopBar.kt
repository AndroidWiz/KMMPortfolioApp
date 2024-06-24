package ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.*
import kmmportfolioapp.composeapp.resources.Res
import kmmportfolioapp.composeapp.resources.logo_capsule
import org.jetbrains.compose.resources.painterResource

@Composable
fun TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth().height(100.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(Res.drawable.logo_capsule),
            contentDescription = "logo",
            modifier = Modifier.fillMaxSize(),
            colorFilter = ColorFilter.tint()
//            colorFilter = ColorFilter.tint(Color.White)
        )
    }

}
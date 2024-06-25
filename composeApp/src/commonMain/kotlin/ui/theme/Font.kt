package ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.*
import kmmportfolioapp.composeapp.resources.*
import org.jetbrains.compose.resources.Font

@Composable
fun PoppinsFamily() = FontFamily(
    Font(Res.font.Poppins_Medium, FontWeight.Medium),
    Font(Res.font.Poppins_Regular, FontWeight.Normal),
    Font(Res.font.Poppins_SemiBold, FontWeight.SemiBold),
)
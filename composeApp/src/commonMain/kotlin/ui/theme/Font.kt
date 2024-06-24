package ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.*
import kmmportfolioapp.composeapp.resources.*
import org.jetbrains.compose.resources.Font

@Composable
fun PoppinsFamily() = FontFamily(
    Font(Res.font.Poppins_Bold, FontWeight.Bold),
    Font(Res.font.Poppins_ExtraBold, FontWeight.ExtraBold),
    Font(Res.font.Poppins_ExtraLight, FontWeight.ExtraLight),
    Font(Res.font.Poppins_Light, FontWeight.Light),
    Font(Res.font.Poppins_Medium, FontWeight.Medium),
    Font(Res.font.Poppins_Regular, FontWeight.Normal),
    Font(Res.font.Poppins_SemiBold, FontWeight.SemiBold),
    Font(Res.font.Poppins_Thin, FontWeight.Thin)
)
package ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import org.jetbrains.compose.resources.*
import ui.theme.*

@Composable
fun SectionHeader(modifier: Modifier, title: StringResource, subTitle: StringResource){
    Text(
        text = stringResource(title),
        color = TextColor,
        fontSize = 12.sp,
        fontFamily = PoppinsFamily(),
        fontWeight = FontWeight.Medium
    )
    Text(
        text = stringResource(subTitle),
        color = FirstColor,
        fontSize = 24.sp,
        fontFamily = PoppinsFamily(),
        fontWeight = FontWeight.SemiBold
    )
    Spacer(modifier = modifier.height(30.dp))
}
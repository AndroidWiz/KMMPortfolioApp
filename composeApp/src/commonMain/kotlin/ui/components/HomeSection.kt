package ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import kmmportfolioapp.composeapp.resources.*
import org.jetbrains.compose.resources.*
import ui.theme.*

@Composable
fun HomeSection() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(Res.string.hello),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = TitleColor,
            fontFamily = PoppinsFamily()
        )
        Text(
            text = stringResource(Res.string.name),
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold,
            color = TitleColor,
            fontFamily = PoppinsFamily()
        )
        Text(
            text = stringResource(Res.string.position),
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextColor,
            fontFamily = PoppinsFamily()
        )

        Spacer(modifier = Modifier.height(50.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            OutlinedButton(
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(width = 2.dp, color = FirstColor),
                modifier = Modifier
                    .wrapContentWidth()
                    .height(50.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = FirstColor
                ),
                onClick = {}
            ) {
                Text(
                    text = stringResource(Res.string.download_cv),
                    fontSize = 16.sp,
                    color = FirstColor,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = PoppinsFamily(),

                    )
            }
            Button(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .wrapContentWidth()
                    .height(50.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = FirstColor,
                    contentColor = Color.Transparent
                ),
                onClick = {}
            ) {
                Text(
                    text = stringResource(Res.string.about_me),
                    fontSize = 16.sp,
                    color = Body_Color,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = PoppinsFamily()
                )
            }
        }

        Spacer(modifier = Modifier.height(50.dp))
        Image(
            painter = painterResource(Res.drawable.image),
            "image",
            modifier = Modifier.width(300.dp)
                .height(400.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop,
        )
    }
}
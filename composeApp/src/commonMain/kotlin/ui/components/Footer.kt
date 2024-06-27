package ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import kmmportfolioapp.composeapp.resources.*
import models.*
import org.jetbrains.compose.resources.*
import ui.theme.*

@Composable
fun Footer(modifier: Modifier, responsive: Responsive) {
    val footerTextItems = listOf("About", "Projects", "Testimonial")
    val socialLinkItem = remember { getSocialLinks() }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = FirstColor)
            .padding(top = 32.dp, bottom = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(Res.string.name),
            color = Body_Color,
            fontFamily = PoppinsFamily(),
            fontSize = 36.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = modifier.height(10.dp))
        /*LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = modifier.height(30.dp).fillMaxWidth(if(responsive.isDesktop)0.2f else 0.6f),
            horizontalArrangement = Arrangement.spacedBy(3.dp, alignment = Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.SpaceBetween,
            content = {
                items(footerTextItems) {
                    Text(
                        text = it,
                        color = Body_Color,
                        fontFamily = PoppinsFamily(),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
//                        modifier = modifier.wrapContentWidth()
                    )
                }
            }
        )*/
        Row(
            modifier = modifier.wrapContentWidth()
                .wrapContentHeight()
        ) {
            footerTextItems.forEach {
                Text(
                    text = it,
                    color = Body_Color,
                    fontFamily = PoppinsFamily(),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    modifier = modifier.padding(horizontal = 5.dp)
                )
            }
        }
        Spacer(modifier = modifier.height(20.dp))
        Row(
            modifier = modifier.wrapContentWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterHorizontally)
        ) {
            socialLinkItem.forEach {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = modifier.size(30.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(Body_Color)
                        .padding(5.dp),
                ) {
                    Image(
                        painter = painterResource(it.icon),
                        contentDescription = "",
                        modifier = modifier.size(21.dp),
                        colorFilter = ColorFilter.tint(FirstColor)
                    )
                }

            }
        }

        Spacer(modifier = modifier.height(10.dp))

        Text(
            text = stringResource(Res.string.copyright),
            color = ContainerColor,
            fontFamily = PoppinsFamily(),
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(top = 20.dp)
                .wrapContentSize()
        )
    }
}
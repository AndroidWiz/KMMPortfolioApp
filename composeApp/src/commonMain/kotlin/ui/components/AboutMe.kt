package ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import kmmportfolioapp.composeapp.resources.Res
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.*
import androidx.compose.ui.unit.*
import kmmportfolioapp.composeapp.resources.*
import models.*
import org.jetbrains.compose.resources.*
import ui.theme.*

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AboutMe(responsive: Responsive, modifier: Modifier) {

    Column(
        modifier = modifier.fillMaxWidth().wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SectionHeader(modifier = modifier, title = Res.string.my_intro, subTitle = Res.string.about_me)

        // About Me Details
        FlowRow(
            modifier = modifier.fillMaxWidth().padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(30.dp, alignment = Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterVertically),
            maxItemsInEachRow = if (responsive.isDesktop) 2 else 1
        ) {
            // left part
            // Image logo
            Box(
                modifier = modifier.fillMaxWidth(if (responsive.isDesktop) 0.25f else 1f),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    painter = painterResource(Res.drawable.logo_capsule),
                    modifier = modifier.size(if (responsive.isMobile) 220.dp else 400.dp),
                    contentDescription = "logo",
                    colorFilter = ColorFilter.tint(FirstColor),
                )
            }
            // right part
            Column(
                modifier = modifier.fillMaxWidth(if (responsive.isDesktop) 0.25f else 1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                // Experience and Projects Card Row
                AboutMeCard(responsive = responsive, modifier = modifier)

                // About Me Description
                Text(
                    text = stringResource(Res.string.about_me_description),
                    color = TextColor,
                    textAlign = TextAlign.Justify,
                    fontFamily = PoppinsFamily(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    overflow = TextOverflow.Clip,
                    softWrap = true,
                )
                // Button Contact Me
                Button(
                    shape = RoundedCornerShape(10.dp),
                    modifier = modifier
                        .wrapContentWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = FirstColor,
                        contentColor = Color.Transparent
                    ),
                    onClick = {}
                ) {
                    Text(
                        text = stringResource(Res.string.contact_me),
                        fontSize = 16.sp,
                        color = Body_Color,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = PoppinsFamily()
                    )
                }
            }
        }
    }
}


@Composable
fun AboutMeCard(responsive: Responsive, modifier: Modifier) {
    val aboutMeItems = remember { getAboutMeItems() }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.height(110.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterHorizontally),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        content = {
            items(aboutMeItems) { aboutMeItem ->
                AboutMeCardView(aboutMeItem = aboutMeItem, modifier = modifier)
            }
        }
    )

}

@Composable
fun AboutMeCardView(aboutMeItem: AboutMeItem, modifier: Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .width(200.dp)
            .height(110.dp)
            .background(color = ContainerColor)
            .padding(vertical = 16.dp, horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(3.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(aboutMeItem.image),
            alignment = Alignment.Center,
            contentDescription = stringResource(Res.string.experience),
            modifier = modifier.size(22.dp).background(Color.Transparent),
            colorFilter = ColorFilter.tint(FirstColor)
        )
        Text(
            text = stringResource(aboutMeItem.title),
            color = TitleColor,
            fontSize = 14.sp,
            fontFamily = PoppinsFamily(),
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = stringResource(aboutMeItem.subtitle),
            color = TextColor,
            fontSize = 10.sp,
            fontFamily = PoppinsFamily(),
            fontWeight = FontWeight.Normal
        )
    }
}
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
fun AboutMe(responsive: Responsive) {
    Text(
        text = stringResource(Res.string.my_intro),
        color = TextColor,
        fontSize = 12.sp,
        fontFamily = PoppinsFamily(),
        fontWeight = FontWeight.Medium
    )
    Text(
        text = stringResource(Res.string.about_me),
        color = FirstColor,
        fontSize = 24.sp,
        fontFamily = PoppinsFamily(),
        fontWeight = FontWeight.SemiBold
    )

    Spacer(modifier = Modifier.height(30.dp))

    // About Me Details
    FlowRow(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(30.dp, alignment = Alignment.CenterHorizontally),
//        verticalArrangement = Arrangement.spacedBy(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterVertically),
//        verticalArrangement = Arrangement.Center,
        maxItemsInEachRow = if (responsive.isDesktop) 2 else 1
    ) {
        // left part
        // Image logo
        Box(
            modifier = Modifier.fillMaxWidth(if (responsive.isDesktop) 0.25f else 1f),
//                .fillMaxHeight(if(responsive.isDesktop) 1f else 0.25f),
//            modifier = Modifier.fillMaxWidth(if (responsive.isDesktop) 0.25f else 0.75f),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(Res.drawable.logo_capsule),
//                modifier = Modifier.size(400.dp),
                modifier = Modifier.size(if(responsive.isMobile)220.dp else 400.dp),
                contentDescription = "logo",
                colorFilter = ColorFilter.tint(FirstColor),
//                alignment = Alignment.Center,
            )
        }
        // right part
        Column(
            modifier = Modifier.fillMaxWidth(if (responsive.isDesktop) 0.25f else 1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Experience and Projects Card Row
            AboutMeCard(responsive)

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


@Composable
fun AboutMeCard(responsive: Responsive) {
    val aboutMeItems = remember { getAboutMeCards() }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.height(110.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterHorizontally),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        content = {
            items(aboutMeItems) { aboutMeItem ->
                AboutMeCardView(aboutMeItem = aboutMeItem)
            }
        }
    )

}

@Composable
fun AboutMeCardView(aboutMeItem: AboutMeItem) {
    Column(
        modifier = Modifier
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
            modifier = Modifier.size(22.dp).background(Color.Transparent),
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


/*if (responsive.isMobile or responsive.isTablet) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(200.dp),
//            columns = GridCells.Fixed(1), //TODO: uncommented.. previously upper line
        modifier = Modifier.height(320.dp),
        horizontalArrangement = Arrangement.spacedBy(
            20.dp,
            alignment = Alignment.CenterHorizontally
        ),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        content = {
            items(aboutMeItems) { aboutMeItem ->
                AboutMeCardView(aboutMeItem = aboutMeItem)
            }
        }
    )
} else {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
//            rows = GridCells.Fixed(if (responsive.isMobile) 1 else 2),
//            modifier = Modifier.width(400.dp).height(if (responsive.isMobile) 320.dp else 150.dp),
        modifier = Modifier.width(600.dp).height(320.dp),
//        modifier = Modifier.width(300.dp).height(150.dp),
//        modifier = Modifier.wrapContentSize(),
        horizontalArrangement = Arrangement.spacedBy(
            20.dp,
            alignment = Alignment.CenterHorizontally
        ),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        content = {
            items(aboutMeItems) { aboutMeItem ->
                AboutMeCardView(aboutMeItem = aboutMeItem)
            }
        }
    )
    *//*Text(
            text = "Not Mobile",
            color = TextColor
        )*//*
    }*/


/*Box(
                modifier = Modifier
                    .wrapContentSize()
                    .weight(1f),
                contentAlignment = Alignment.CenterEnd
            ) {
                Image(
                    painter = painterResource(Res.drawable.logo_capsule),
                    contentDescription = "logo",
                    modifier = Modifier.size(350.dp),
                    colorFilter = ColorFilter.tint(FirstColor),
                )
            }*/

/*Row(
    modifier = Modifier.padding(8.dp).wrapContentWidth(),
    horizontalArrangement = Arrangement.spacedBy(10.dp)
) {
    Card(
        backgroundColor = ContainerColor,
        elevation = 8.dp,
        shape = RoundedCornerShape(12.dp),
//                        modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 20.dp)
                .width(200.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(Res.drawable.about_me),
                alignment = Alignment.Center,
                contentDescription = stringResource(Res.string.experience),
                modifier = Modifier.size(20.dp).padding(bottom = 2.dp),
                colorFilter = ColorFilter.tint(FirstColor)
            )
            Text(
                text = stringResource(Res.string.experience),
                color = TitleColor,
                fontSize = 13.sp,
                fontFamily = PoppinsFamily(),
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(Res.string.experience_subtitle),
                color = TextColor,
                fontSize = 10.sp,
                fontFamily = PoppinsFamily(),
                fontWeight = FontWeight.Normal
            )
        }
    }
    Card(
        backgroundColor = ContainerColor,
        elevation = 8.dp,
        shape = RoundedCornerShape(12.dp),
//                        modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 20.dp)
                .width(200.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(Res.drawable.briefcase),
                alignment = Alignment.Center,
                contentDescription = "Completed Projects",
                modifier = Modifier.size(18.dp).padding(bottom = 2.dp),
                colorFilter = ColorFilter.tint(FirstColor)
            )
            Text(
                text = stringResource(Res.string.completed),
                color = TitleColor,
                fontSize = 13.sp,
                fontFamily = PoppinsFamily(),
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = stringResource(Res.string.completed_subtitle),
                color = TextColor,
                fontSize = 10.sp,
                fontFamily = PoppinsFamily(),
                fontWeight = FontWeight.Normal
            )
        }
    }
}*/
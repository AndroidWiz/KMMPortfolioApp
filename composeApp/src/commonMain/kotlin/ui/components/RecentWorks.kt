package ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.*
import androidx.compose.runtime.*
import androidx.compose.material.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import kmmportfolioapp.composeapp.resources.*
import models.*
import org.jetbrains.compose.resources.*
import ui.theme.*

@Composable
fun RecentWorks(responsive: Responsive, modifier: Modifier) {
    Text(
        text = stringResource(Res.string.my_portfolio),
        color = TextColor,
        fontSize = 12.sp,
        fontFamily = PoppinsFamily(),
        fontWeight = FontWeight.Medium
    )
    Text(
        text = stringResource(Res.string.recent_works),
        color = FirstColor,
        fontSize = 24.sp,
        fontFamily = PoppinsFamily(),
        fontWeight = FontWeight.SemiBold
    )
    Spacer(modifier = modifier.height(30.dp))
    RecentWorkCard(modifier = modifier, responsive = responsive)
}

@Composable
fun RecentWorkCard(modifier: Modifier, responsive: Responsive) {
    val recentWorkItems = remember { getRecentWorkItems() }

    LazyVerticalGrid(
//        columns = GridCells.Adaptive(240.dp),
        columns = GridCells.Fixed(if(responsive.isMobile) 1 else 2),
        contentPadding = PaddingValues(20.dp),
//        modifier = modifier.height(if (responsive.isMobile) 640.dp else 400.dp)
        modifier = modifier.height(if (responsive.isMobile) 450.dp else 640.dp)
            .fillMaxWidth(if (responsive.isDesktop) 0.48f else 1f),
        horizontalArrangement = Arrangement.spacedBy(
            30.dp,
            alignment = Alignment.CenterHorizontally
        ),
        verticalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterVertically),
        content = {
            items(recentWorkItems) { recentWorkItem ->
                RecentWorkCardView(recentWorkItem = recentWorkItem, modifier = modifier, responsive = responsive)
            }
        }
    )
}

@Composable
fun RecentWorkCardView(recentWorkItem: RecentWorkItem, modifier: Modifier, responsive: Responsive) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .width(260.dp)
//            .width(250.dp)
            .wrapContentHeight()
            .background(color = ContainerColor)
            .padding(if(responsive.isDesktop)16.dp else 10.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth(1f)
                .height(180.dp)
//                .fillMaxHeight(0.75f)
                .clip(RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(recentWorkItem.image),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
            )
        }
/*        Image(
            painter = painterResource(recentWorkItem.image),
            contentDescription = "",
            alignment = Alignment.TopCenter,
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .clip(RoundedCornerShape(12.dp)),
//            colorFilter = ColorFilter.tint(FirstColor)
            contentScale = ContentScale.Crop
        )*/
        Text(
            text = recentWorkItem.name,
            color = TitleColor,
            fontSize = 16.sp,
            fontFamily = PoppinsFamily(),
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Demo",
            color = FirstColor,
            fontSize = 12.sp,
            fontFamily = PoppinsFamily(),
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}
package ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.*
import androidx.compose.runtime.*
import androidx.compose.material.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
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
//    var selectedProjectType by remember { mutableStateOf(ProjectType.All) }
    val recentWorkItems = remember { getRecentWorkItems() }

    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
//        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        SectionHeader(modifier = modifier, title = Res.string.my_portfolio, subTitle = Res.string.recent_works)

        // radio buttons to filter the recent work items
        /*Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterHorizontally)
    ){
        RadioButton(
            selected = selectedProjectType == ProjectType.All,
            onClick = {selectedProjectType = ProjectType.All}
        )
        Text(text = "All", color = Color.White)
        RadioButton(
            selected = selectedProjectType == ProjectType.Web,
            onClick = {selectedProjectType = ProjectType.Web}
        )
        Text(text = "Web", color = Color.White)
        RadioButton(
            selected = selectedProjectType == ProjectType.Mobile,
            onClick = {selectedProjectType = ProjectType.Mobile}
        )
        Text(text = "Mobile", color = Color.White)
    }

    Spacer(modifier = modifier.height(10.dp))

    val filteredRecentWorksItems = when(selectedProjectType){
        ProjectType.Web -> recentWorkItems.filter { it.type == ProjectType.Web }
        ProjectType.Mobile -> recentWorkItems.filter { it.type == ProjectType.Mobile }
        else -> {recentWorkItems}
    }

    RecentWorkCard(modifier = modifier, responsive = responsive, recentWorkItems = filteredRecentWorksItems)*/
        RecentWorkCard(modifier = modifier, responsive = responsive, recentWorkItems = recentWorkItems)
    }
}

@Composable
fun RecentWorkCard(modifier: Modifier, responsive: Responsive, recentWorkItems: List<RecentWorkItem>) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(if(responsive.isMobile) 1 else 2),
        contentPadding = PaddingValues(20.dp),
        modifier = modifier.heightIn( min = 1500.dp,max =3000.dp)
            .fillMaxWidth(if (responsive.isDesktop) 0.45f else 1f),
        horizontalArrangement = Arrangement.spacedBy(40.dp, alignment = Alignment.CenterHorizontally),
        verticalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterVertically),
        content = {
            items(recentWorkItems) {
                RecentWorkCardView(recentWorkItem = it, modifier = modifier, responsive = responsive)
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
                .clip(RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(recentWorkItem.image),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
            )
        }
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
            textAlign = TextAlign.Center,
            modifier = modifier.clickable {  }
        )
    }
}
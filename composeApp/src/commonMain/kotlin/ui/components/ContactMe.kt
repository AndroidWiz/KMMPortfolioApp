package ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import kmmportfolioapp.composeapp.resources.*
import models.*
import org.jetbrains.compose.resources.*
import ui.theme.*

@Composable
fun ContactMe(responsive: Responsive, modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxWidth().wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SectionHeader(
            modifier = modifier,
            title = Res.string.get_in_touch,
            subTitle = Res.string.contact_me
        )

        Text(
            text = stringResource(Res.string.talk_to_me),
            color = TitleColor,
            fontSize = 20.sp,
            fontFamily = PoppinsFamily(),
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = modifier.height(10.dp))

        ContactMeCard(modifier = modifier, responsive = responsive)
    }
}

@Composable
fun ContactMeCard(modifier: Modifier, responsive: Responsive) {
    val contactMeItems = remember { getContactMeItems() }

    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        modifier = modifier.height(600.dp)
            .fillMaxWidth(if (responsive.isDesktop) 0.2f else 0.9f),
        horizontalArrangement = Arrangement.spacedBy(30.dp, alignment = Alignment.CenterHorizontally),
        verticalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterVertically),
        content = {
            items(contactMeItems){
                ContactMeCardView(modifier = modifier, contactMeItem = it)
            }
        }
    )
}

@Composable
fun ContactMeCardView(modifier: Modifier, contactMeItem: ContactMeItem) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .width(300.dp)
            .height(145.dp)
            .background(color = ContainerColor)
            .padding(all = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(contactMeItem.icon),
            contentDescription = "",
            modifier = modifier.size(20.dp).background(Color.Transparent),
            colorFilter = ColorFilter.tint(Color.White)
        )
        Text(
            text = contactMeItem.title,
            color = TitleColor,
            fontSize = 14.sp,
            fontFamily = PoppinsFamily(),
            fontWeight = FontWeight.Medium
        )
        Text(
            text = contactMeItem.subtitle,
            color = TextColor,
            fontSize = 14.sp,
            fontFamily = PoppinsFamily(),
            fontWeight = FontWeight.Medium
        )
        Text(
            text = stringResource(Res.string.write_to_me),
            color = FirstColor,
            fontSize = 13.sp,
            fontFamily = PoppinsFamily(),
            fontWeight = FontWeight.Medium
        )
    }
}
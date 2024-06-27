package ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import kmmportfolioapp.composeapp.resources.*
import models.*
import org.jetbrains.compose.resources.*
import ui.theme.*

@Composable
fun MySkills(responsive: Responsive, modifier: Modifier) {

    Column(
        modifier = modifier.fillMaxWidth().wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SectionHeader(modifier = modifier, title = Res.string.my_abilities, subTitle = Res.string.my_skills)

        MySkillCard(modifier = modifier, responsive = responsive)
    }
}

@Composable
fun MySkillCard(modifier: Modifier, responsive: Responsive) {
    val mySkillItems = remember { getMySkillItems() }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(260.dp),
        contentPadding = PaddingValues(20.dp),
        modifier = modifier.height(if (responsive.isMobile) 640.dp else 400.dp)
            .fillMaxWidth(if (responsive.isDesktop) 0.48f else 1f),
        horizontalArrangement = Arrangement.spacedBy(30.dp, alignment = Alignment.CenterHorizontally),
        verticalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterVertically),
        content = {
            items(mySkillItems) { mySkillItem ->
                MySkillCardView(mySkillItem = mySkillItem, modifier = modifier)
            }
        }
    )
}

@Composable
fun MySkillCardView(mySkillItem: MySkillItem, modifier: Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .width(260.dp)
            .height(230.dp)
            .background(color = ContainerColor)
            .padding(vertical = 16.dp, horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(mySkillItem.title),
            color = FirstColor,
            fontSize = 16.sp,
            fontFamily = PoppinsFamily(),
            fontWeight = FontWeight.Medium
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(10.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp, alignment = Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterVertically),
            content = {
                items(mySkillItem.skillList) { skill ->
                    SkillItemRow(modifier = modifier, skill = skill, mySkillItem = mySkillItem)
                }
            }
        )
    }
}

@Composable
fun SkillItemRow(modifier: Modifier, skill: String, mySkillItem: MySkillItem){
    Row(
        modifier = modifier.padding(vertical = 3.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(mySkillItem.image),
            contentDescription = "verified",
            modifier = modifier.size(16.dp).background(Color.Transparent),
            colorFilter = ColorFilter.tint(FirstColor)
        )
        Spacer(modifier = modifier.width(5.5.dp))
        Text(
            text = skill,
            color = TitleColor,
            fontSize = 14.sp,
            fontFamily = PoppinsFamily(),
            fontWeight = FontWeight.Medium
        )
    }
}
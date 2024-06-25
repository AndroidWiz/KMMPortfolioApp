package ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import kmmportfolioapp.composeapp.resources.Res
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.*
import androidx.compose.ui.unit.*
import kmmportfolioapp.composeapp.resources.*
import org.jetbrains.compose.resources.*
import ui.theme.*

@Composable
fun AboutMe() {
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

    Box(
//        modifier = Modifier.fillMaxWidth(),
        modifier = Modifier.wrapContentSize()
            .padding(horizontal = 50.dp),
        contentAlignment = Alignment.Center,

        ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.weight(0.5f))
            // left part
            Box(
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
            }

            // right part
            Column(
                modifier = Modifier.wrapContentWidth().weight(1f),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                // Experience and Projects Card Row
                Row(
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
                }

                Text(
                    text = stringResource(Res.string.about_me_description),
                    color = TextColor,
                    textAlign = TextAlign.Justify,
                    fontFamily = PoppinsFamily(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    overflow = TextOverflow.Clip,
                    softWrap = true,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Button(
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .wrapContentWidth()
                        .height(50.dp)
                        .padding(start = 16.dp),
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
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = PoppinsFamily()
                    )
                }
            }
            Spacer(modifier = Modifier.weight(0.5f))
        }
    }

}
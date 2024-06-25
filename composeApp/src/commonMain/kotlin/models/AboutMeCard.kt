package models

import androidx.compose.runtime.Composable
import kmmportfolioapp.composeapp.resources.*
import org.jetbrains.compose.resources.*

data class AboutMeItem(
    val image: DrawableResource,
    val title: StringResource,
    val subtitle: StringResource
)


fun getAboutMeCards(): List<AboutMeItem> {
    return mutableListOf(
        AboutMeItem(
            image = Res.drawable.about_me,
            title = Res.string.experience,
            subtitle = Res.string.experience_subtitle
        ),
        AboutMeItem(
            image = Res.drawable.briefcase,
            title = Res.string.completed,
            subtitle = Res.string.completed_subtitle
        )
    ).toList()
}

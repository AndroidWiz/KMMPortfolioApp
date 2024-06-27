package models

import kmmportfolioapp.composeapp.resources.*
import org.jetbrains.compose.resources.*

data class AboutMeItem(
    val image: DrawableResource,
    val title: StringResource,
    val subtitle: StringResource
)


fun getAboutMeItems(): List<AboutMeItem> {
    return mutableListOf(
        AboutMeItem(
            image = Res.drawable.ic_about_me,
            title = Res.string.experience,
            subtitle = Res.string.experience_subtitle
        ),
        AboutMeItem(
            image = Res.drawable.ic_briefcase,
            title = Res.string.completed,
            subtitle = Res.string.completed_subtitle
        )
    ).toList()
}

package models

import kmmportfolioapp.composeapp.resources.*
import org.jetbrains.compose.resources.*

enum class ProjectType {
    Web,
    Mobile
}

data class RecentWorkItem(
    val image: DrawableResource,
    val name: String,
    val link: String,
    val type: ProjectType
)

fun getRecentWorkItems(): List<RecentWorkItem> {
    return mutableListOf(
        RecentWorkItem(
            image = Res.drawable.KenyaLiveTv,
            name = "Kenya Live TV",
            link = "",
            type = ProjectType.Mobile
        ),
        RecentWorkItem(
            image = Res.drawable.KenyaRadioLive,
            name = "Kenya Live Radio",
            link = "",
            type = ProjectType.Mobile
        ),
        RecentWorkItem(
            image = Res.drawable.Achiev,
            name = "Achiev",
            link = "",
            type = ProjectType.Mobile
        ),
        RecentWorkItem(
            image = Res.drawable.anime_app,
            name = "Anime App",
            link = "",
            type = ProjectType.Mobile
        ),
        RecentWorkItem(
            image = Res.drawable.discount_bd,
            name = "Discount BD",
            link = "",
            type = ProjectType.Mobile
        ),
        RecentWorkItem(
            image = Res.drawable.eyymama_ecommerce_website,
            name = "EyyMama Ecommerce",
            link = "",
            type = ProjectType.Web
        ),
        RecentWorkItem(
            image = Res.drawable.free_parking_spot,
            name = "Free Parking Spot",
            link = "",
            type = ProjectType.Mobile
        ),
        RecentWorkItem(
            image = Res.drawable.key_face,
            name = "Key Face",
            link = "",
            type = ProjectType.Mobile
        ),
        RecentWorkItem(
            image = Res.drawable.shopapp_1,
            name = "Shop App",
            link = "",
            type = ProjectType.Mobile
        ),
        RecentWorkItem(
            image = Res.drawable.SMPlayer_Android,
            name = "SM Player",
            link = "",
            type = ProjectType.Mobile
        )
    ).toList()
}
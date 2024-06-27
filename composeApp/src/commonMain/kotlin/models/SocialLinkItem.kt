package models

import kmmportfolioapp.composeapp.resources.Res
import kmmportfolioapp.composeapp.resources.ic_facebook
import kmmportfolioapp.composeapp.resources.ic_instagram
import kmmportfolioapp.composeapp.resources.ic_twitter
import org.jetbrains.compose.resources.DrawableResource

data class SocialLinkItem(
    val icon: DrawableResource,
    val link: String
)

fun getSocialLinks(): List<SocialLinkItem> {
    return mutableListOf(
        SocialLinkItem(
            icon = Res.drawable.ic_facebook,
            link = "https://www.facebook.com/"
        ),
        SocialLinkItem(
            icon = Res.drawable.ic_instagram,
            link = "https://www.instagram.com/"
        ),
        SocialLinkItem(
            icon = Res.drawable.ic_twitter,
            link = "https://www.twitter.com/"
        )
    ).toList()
}
package models

import kmmportfolioapp.composeapp.resources.*
import org.jetbrains.compose.resources.DrawableResource

data class ContactMeItem(
    val icon: DrawableResource,
    val title: String,
    val subtitle: String
)

fun getContactMeItems(): List<ContactMeItem> {
    return mutableListOf(
        ContactMeItem(
            icon = Res.drawable.ic_email,
            title = "Email",
            subtitle = "email@email.com"
        ),
        ContactMeItem(
            icon = Res.drawable.ic_whatsapp,
            title = "Whatsapp",
            subtitle = "+880-000-000-0000"
        ),
        ContactMeItem(
            icon = Res.drawable.ic_messenger,
            title = "Messenger",
            subtitle = "Sharjeel Karim"
        )
    ).toList()
}

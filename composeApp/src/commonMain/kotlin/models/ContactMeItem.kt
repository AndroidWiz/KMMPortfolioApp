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
            subtitle = "poko.sk.tolu@gmail.com"
        ),
        ContactMeItem(
            icon = Res.drawable.ic_whatsapp,
            title = "Whatsapp",
            subtitle = "+60-16-799-459"
        ),
        ContactMeItem(
            icon = Res.drawable.ic_messenger,
            title = "Messenger",
            subtitle = "Sharjeel Karim"
        )
    ).toList()
}

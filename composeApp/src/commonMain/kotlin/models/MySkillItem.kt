package models

import kmmportfolioapp.composeapp.resources.*
import org.jetbrains.compose.resources.*

data class MySkillItem(
    val title: StringResource,
    val image: DrawableResource,
    val skillList: List<String>
)

fun getMySkillItems(): List<MySkillItem> {
    return mutableListOf(
        MySkillItem(
            title = Res.string.frontend_developer,
            image = Res.drawable.ic_verified,
            skillList = listOf(
                "Jetpack Compose",
                "XML",
                "HTML",
                "CSS",
                "Bootstrap",
                "TypeScript"
            )
        ),
        MySkillItem(
            title = Res.string.backend_developer,
            image = Res.drawable.ic_verified,
            skillList = listOf(
                "Java",
                "Kotlin",
                "Spring Security",
                "Spring Boot",
                "MySQL",
                "Firebase"
            )
        )
    ).toList()
}

import androidx.compose.material.*
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import moe.tlaster.precompose.PreComposeApp
import ui.navigation.AppNavigation

@Composable
@Preview
fun App() {
    PreComposeApp {
        MaterialTheme {
            AppNavigation()
        }
    }
}
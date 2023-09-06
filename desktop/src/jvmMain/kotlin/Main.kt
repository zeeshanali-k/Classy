import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.devscion.classy.App

fun main() = application {
    val windowState = rememberWindowState(
        size = DpSize(450.dp, 800.dp)
    )

    Window(
        onCloseRequest = ::exitApplication,
        state = windowState,
        title = "Classy"
    ) {
        App()
    }
}
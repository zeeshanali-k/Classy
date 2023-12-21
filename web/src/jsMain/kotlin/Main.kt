import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import com.devscion.classy.App
import org.jetbrains.skiko.wasm.onWasmReady
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun main() {
    onWasmReady {
        Window("Classy") {
            Box(Modifier.fillMaxSize()) {
                App()
            }
        }
    }
}

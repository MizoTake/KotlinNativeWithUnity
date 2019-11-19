package sample

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

actual class Platform {
    actual val name: String = "Native"
    actual fun api(url: String): String = runBlocking {
        return@runBlocking ApplicationApi().request(url)
    }
}

internal actual val ApplicationDispatcher: CoroutineDispatcher = Dispatchers.Default

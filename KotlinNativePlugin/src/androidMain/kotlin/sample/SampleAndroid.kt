package sample

import kotlinx.coroutines.*

actual class Platform {
    actual val name: String = "Android"
    fun name(): String { return name }
    actual fun api(url: String): String = runBlocking {
        return@runBlocking ApplicationApi().request(url)
    }
}

internal actual val ApplicationDispatcher: CoroutineDispatcher = Dispatchers.Default
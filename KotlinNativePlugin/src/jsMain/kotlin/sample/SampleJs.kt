package sample

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlin.browser.*

actual class Platform {
    actual val name: String = "js"

    actual fun api(url: String): String = runBlocking {
        return@runBlocking ApplicationApi().request(url)
    }.toString() // error回避 動作未検証
}

internal actual val ApplicationDispatcher: CoroutineDispatcher = Dispatchers.Default

internal fun <T> runBlocking(block: suspend () -> T) {
    runBlocking { block() }
}
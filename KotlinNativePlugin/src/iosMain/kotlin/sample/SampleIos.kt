package sample

import kotlin.coroutines.*
import kotlinx.coroutines.*
import platform.darwin.*

actual class Platform {
    actual val name: String = "iOS"
    actual fun api(url: String): String = runBlocking {
        return@runBlocking ApplicationApi().request(url)
    }
}

internal actual val ApplicationDispatcher: CoroutineDispatcher = NsQueueDispatcher(dispatch_get_main_queue())

internal class NsQueueDispatcher(
    private val dispatchQueue: dispatch_queue_t
) : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatchQueue) {
            block.run()
        }
    }
}
package sample

import io.ktor.client.*
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.Url
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.*

expect class Platform constructor() {
    val name: String
    fun api(url: String): String
}

internal expect val ApplicationDispatcher: CoroutineDispatcher

internal class ApplicationApi {
    private val client = HttpClient()

    suspend fun request(url: String): String {
        return suspendCoroutine<String> { continuation ->
            call(url) {
                continuation.resume(it)
            }
        }
    }

    private fun call(urlString: String, callback: (String) -> Unit) {
        val address = Url(urlString)
        GlobalScope.apply {
            launch(ApplicationDispatcher) {
                val result: String = client.get {
                    url(address.toString())
                }
                callback(result)
            }
        }
    }
}

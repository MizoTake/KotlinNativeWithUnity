package sample

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.awaitAll
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.test.Test
import kotlin.test.assertTrue

class SampleTests {
    @Test
    fun testMe() {
        assertTrue(Platform().name.isNotEmpty())
    }
}
package sample

import kotlin.test.Test
import kotlin.test.assertTrue

class SampleTestsNative {
    @Test
    fun testHello() {
        assertTrue("Native" in Platform().name)
    }

    @Test
    fun testApi() {
        val response = Platform().api("https://github.com/MizoTake/KotlinNativeWithUnity/blob/master/Response.txt")
        assertTrue(response.isNotEmpty())
    }
}
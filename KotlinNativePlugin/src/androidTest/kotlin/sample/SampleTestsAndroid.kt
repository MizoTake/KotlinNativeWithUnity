package sample

import kotlin.test.Test
import kotlin.test.assertTrue

class SampleTestsAndroid {
    @Test
    fun testHello() {
        assertTrue("Android" in Platform().name)
    }

    @Test
    fun testApi() {
        val response = Platform().api("https://github.com/MizoTake/KotlinNativeWithUnity/blob/master/Response.txt")
        println(response)
        assertTrue(response.isNotEmpty())
    }
}
package baekjoon

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.lang.StringBuilder

internal class Step08KtTest {

    @Test
    fun test1() {

        val a = 1
        val b = 100

        assertEquals(ex0902().run(1,2).key, Pair(1,2).first)
        assertEquals(ex0902().run(1,2).value, Pair(1,2).second)

    }


}


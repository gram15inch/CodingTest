import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class BigOTest {

    var array = Array(20) { 0 }

    @Test
    fun o1() {
        println("o1(${array.size}): ${o1(array)}")
    }

    @Test
    fun oN() {
        println("oN(${array.size}): ${oN(array)}")
    }

    @Test
    fun oN2() {
        println("oN2(${array.size}): ${oN2(array)}")
    }
    @Test
    fun oN3() {
        println("oN3(${array.size}): ${oN3(array)}")
    }

    @Test
    fun o2N() {
        println("o2N(${array.size}): ${o2N(array.size)}")
    }

}
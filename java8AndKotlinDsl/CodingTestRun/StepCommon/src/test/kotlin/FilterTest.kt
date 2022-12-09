import kotlinx.coroutines.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@OptIn(ExperimentalTime::class)
class FilterTest {


    @Test
    @DisplayName("람다로 필터조건 초기화하기")
    fun createFilterWithLambda() {
        val list = mutableListOf<Int>()
        for (n in 1..10) {
            list.add(n)
        }

        Assertions.assertEquals(5, list.filter { it % 2 == 0 }.size)
    }


    /* array -> filter -> typeArray 35ms */
    @Test
    fun timeCheckFilterWithArrayToTypeArray() {
        val size = 1000000
        val times = 6
        measureTimedValue {
            val array = Array(size) { i -> i }
            var filteredArray = array
            for (time in 2..times) {
                filteredArray = filteredArray.filter { it % time == 0 }.toTypedArray()
            }
        }.duration.also { println(it) }
    }


    /* array -> list -> filter 68ms */
    @Test
    fun timeCheckFilterWithArrayToList() {
        val size = 1000000
        val times = 6
        measureTimedValue {
            val array = Array(size) { i -> i }
            var list = array.toList()
            for (time in 2..times)
                list = list.filter { it % time == 0 }
        }.duration.also { println(it) }
    }

    /*  mutableList -> filter 47ms */
    @Test
    fun timeCheckFilterWithMutableListToList() {
        val size = 1000000
        val times = 6
        measureTimedValue {
            val listInit = mutableListOf<Int>()
            for (n in 0..size)
                listInit.add(n)
            var list: List<Int> = listInit
            for (time in 2..times)
                list = list.filter { it % time == 0 }
        }.duration.also { println(it) }
    }

}
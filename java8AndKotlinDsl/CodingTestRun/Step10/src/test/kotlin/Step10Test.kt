import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Step10Test {

    @Test
    fun selectSortTest() {
        val arr = arrayOf(6, -5, -2, 8, 4, 10, 7)
        val sortedArr = arrayOf(-5, -2, 4, 6, 7, 8, 10)
        val rsArr = selectSortArr(arr)
        repeat(arr.size) {
            assertEquals(sortedArr[it], rsArr[it])
        }
    }

    @Test
    fun insertSortTest() {
        val arr = arrayOf(6, -5, -2, 8, 4, 10, 7)
        val sortedArr = arrayOf(-5, -2, 4, 6, 7, 8, 10)
        val rsArr = insertSortArr(arr)
        repeat(arr.size) {
            assertEquals(sortedArr[it], rsArr[it])
        }
    }


    @Test
    fun selectSort100kBestTest() {
        val list = mutableListOf<Int>()
        val size = 400000
        for (i in 1..size)
            list.add(i)
        val arr = list.toTypedArray()
        val sortedArr = Array(size) { it + 1 }
        val rsArr = selectSortArr(arr)

        repeat(rsArr.size) {
            assertEquals(sortedArr[it], rsArr[it])
        }

    }

    @Test
    fun insertSort100kBestTest() {
        val list = mutableListOf<Int>()
        val size = 1000000
        for (i in 1..size)
            list.add(i)
        val arr = list.toTypedArray()
        val sortedArr = Array(size) { it + 1 }
        val rsArr = insertSortArr(arr)

        repeat(rsArr.size) {
            assertEquals(sortedArr[it], rsArr[it])
        }
    }

    @Test
    fun selectSort100kWorstTest() {

        val list = mutableListOf<Int>()
        for (i in 100000 downTo 1)
            list.add(i)
        val arr = list.toTypedArray()
        val sortedArr = Array(100000) { it + 1 }
        val rsArr = selectSortArr(arr)

        repeat(rsArr.size) {
            assertEquals(sortedArr[it], rsArr[it])
        }

    }

    @Test
    fun insertSort100kWorstTest() {

        val list = mutableListOf<Int>()
        for (i in 100000 downTo 1)
            list.add(i)
        val arr = list.toTypedArray()
        val sortedArr = Array(100000) { it + 1 }
        val rsArr = insertSortArr(arr)

        repeat(rsArr.size) {
            assertEquals(sortedArr[it], rsArr[it])
        }

    }

    @Test
    fun middleArrTest() {
        val arr = arrayOf(10, 40, 30, 60, 30)
        assertEquals("34\n30", middleArr(arr))
    }

    @Test
    fun kotlinArrWorstTest() {
        val list = mutableListOf<Int>()
        for (i in 1000000 downTo 1)
            list.add(i)
        val rsArr = kotlinSort(list.toTypedArray())
        val sortedArr = Array(1000000) { it + 1 }

        repeat(rsArr.size) {
            assertEquals(sortedArr[it], rsArr[it])
        }

    }

    @Test
    fun countingArrTest() {
        val arr = arrayOf<Short>(5, 2, 3, 1, 4, 2, 3, 5, 1, 7)
        val rsArr = countingSort(arr, 7)
        val sortedArr = arrayOf<Short>(1, 1, 2, 2, 3, 3, 4, 5, 5, 7)

        repeat(rsArr.size) {
            assertEquals(sortedArr[it], rsArr[it])
        }

    }

    @Test
    fun countingArrWorstTest() {
        val size = 10000
        val arr = Array(size){(size-it).toShort()}
        val rsArr = countingSort(arr, size)
        val sortedArr = Array(size) { (it + 1).toShort() }
        repeat(rsArr.size) {
            assertEquals(sortedArr[it], rsArr[it])
        }

    }


}
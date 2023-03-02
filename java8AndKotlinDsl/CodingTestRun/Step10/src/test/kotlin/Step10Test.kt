import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test



class Step10Test {

    @Test
    fun selectSortTest(){
        val arr = arrayOf(6,-5,-2,8,4,10,7)
        val sortedArr= arrayOf(-5,-2,4,6,7,8,10)
        val rsArr =selectSortArr(arr)
        repeat(arr.size){
            assertEquals(sortedArr[it],rsArr[it])
        }
    }
    @Test
    fun insertSortTest(){
        val arr = arrayOf(6,-5,-2,8,4,10,7)
        val sortedArr= arrayOf(-5,-2,4,6,7,8,10)
        val rsArr =insertSortArr(arr)
        repeat(arr.size){
            assertEquals(sortedArr[it],rsArr[it])
        }
    }


    @Test
    fun selectSort100kBestTest(){
        val list = mutableListOf<Int>()
        val size = 400000
        for (i in 1 .. size)
            list.add(i)
        val arr = list.toTypedArray()
        val sortedArr= Array(size){it+1}
        val rsArr =selectSortArr(arr)

        repeat(rsArr.size){
            assertEquals(sortedArr[it],rsArr[it] )
        }

    }
    @Test
    fun insertSort100kBestTest(){
        val list = mutableListOf<Int>()
        val size= 1000000
        for (i in 1 .. size)
            list.add(i)
        val arr = list.toTypedArray()
        val sortedArr= Array(size){it+1}
        val rsArr =insertSortArr(arr)

        repeat(rsArr.size){
            assertEquals(sortedArr[it],rsArr[it])
        }
    }

    @Test
    fun selectSort100kWorstTest(){

        val list = mutableListOf<Int>()
        for (i in 100000 downTo 1)
            list.add(i)
        val arr = list.toTypedArray()
        val sortedArr= Array(100000){it+1}
        val rsArr =selectSortArr(arr)

        repeat(rsArr.size){
            assertEquals(sortedArr[it],rsArr[it])
        }

    }
    @Test
    fun insertSort100kWorstTest(){

        val list = mutableListOf<Int>()
        for (i in 100000 downTo 1)
            list.add(i)
        val arr = list.toTypedArray()
        val sortedArr= Array(100000){it+1}
        val rsArr =insertSortArr(arr)

        repeat(rsArr.size){
            assertEquals(sortedArr[it],rsArr[it])
        }

    }

    @Test
    fun middleArrTest(){
        val arr = arrayOf(10,40,30,60,30)
        assertEquals("34\n30",middleArr(arr))
    }

     @Test
    fun kotlinArrWorstTest(){
         val list = mutableListOf<Int>()
         for (i in 1000000 downTo 1)
             list.add(i)
        val rsArr = kotlinSort(list.toTypedArray())
        val sortedArr = Array(1000000){it+1}

         repeat(rsArr.size){
             assertEquals(sortedArr[it],rsArr[it])
         }

    }



}
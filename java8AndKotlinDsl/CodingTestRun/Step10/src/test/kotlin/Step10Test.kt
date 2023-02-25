import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test



class Step10Test {

    @Test
    fun sortArrTest(){
        val arr = arrayOf(6,-5,-2,8,4,10,7)
        val sortedArr= arrayOf(-5,-2,4,6,7,8,10)
        val rsArr =selectSortArr(arr)
        repeat(arr.size){
            assertEquals(sortedArr[it],rsArr[it])
        }
    }
    @Test
    fun sortArr1Test(){
        val arr = arrayOf(1)
        val sortedArr= arrayOf(1)
        val rsArr =selectSortArr(arr)
        repeat(arr.size){
            assertEquals(sortedArr[it],rsArr[it])
        }
    }
    @Test
    fun sortArr25Test(){
        val arr = arrayOf(5,2)
        val sortedArr= arrayOf(2,5)
        val rsArr =selectSortArr(arr)
        repeat(arr.size){
            assertEquals(sortedArr[it],rsArr[it])
        }
    }
    @Test
    fun sortArr1mTest(){

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
}
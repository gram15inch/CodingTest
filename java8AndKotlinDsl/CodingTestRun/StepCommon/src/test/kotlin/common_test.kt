import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.test.timeCheck

@OptIn(ExperimentalCoroutinesApi::class)
class CommonTest {


    /* Array 초기화 -> arrayLambda 가 압도적 빠름*/
    @Test fun timeCheckDataInitWithArray(): Unit =
        runBlocking {
            val size = 1000000
            timeCheck {
                val arr= Array(size){0}
                for (i in 0 until size) {
                    arr[i] = i
                }
                "${arr.first()} - ${arr.last()}"
            }
            timeCheck {
                val arr= Array(size){0}
                for (i in 0 until size) {
                    arr[i] = i
                }
                "${arr.first()} - ${arr.last()}"
            }
            // 초기값 보정

            /* [Array] */
            /* for */
            timeCheck("[array] \nfor") {
                val arr= Array(size){0}
                for (i in 0 until size) {
                    arr[i] = i
                }
                "${arr.first()} - ${arr.last()}"
            }

            /* forEach */
            timeCheck("forEach") {
                val arr= Array(size){0}
                (0 until size).forEach {
                    arr[it]=it
                }
                "${arr.first()} - ${arr.last()}"
            }

            /* while */
            timeCheck("while") {
                val arr= Array(size){0}
                var i =0
                while(i < size){
                    arr[i]=i++
                }
                "${arr.first()} - ${arr.last()}"
            }
            /* arrayLambda */
            timeCheck("arrayLambda") {
                val arr= Array(size){i -> i}
                "${arr.first()} - ${arr.last()}"
            }

            /* intRange */
            timeCheck("intRange") {
                val arr= (0 until size).toList().toTypedArray()
                "${arr.first()} - ${arr.last()}"
            }


            /* [List] */
            /* for */
            timeCheck("[List]\nfor") {
                val arr= mutableListOf<Int>()
                for(i in 0 until size){
                    arr.add(i)
                }
                "${arr.first()} - ${arr.last()}"
            }
            /* toList */
            timeCheck("(1..size).toList()"){
                val arr= (0..size).toList()
                "${arr.first()} - ${arr.last()}"
            }
            val tmpList1= Array(size){0}
            timeCheck("Array.toList()"){
                val arr= tmpList1.toList()
                "${arr.first()} - ${arr.last()}"
            }

            timeCheck("Array(size){}.toList().toTypeArray"){
                val arr= Array(size){0}.toList().toTypedArray()
                "${arr.first()} - ${arr.last()}"
            }
            timeCheck("Array(size){} -> toList() ->toTypeArray"){
                val arr1= Array(size){0}
                val list =arr1.toList()
                val arr = list.toTypedArray()
                "${arr.first()} - ${arr.last()}"
            }
        }

    /* List 초기화 -> for <= while < forEach  */
    @Test fun timeCheckDataInitWithList(): Unit =

        runBlocking {
            val size = 1000000
            timeCheck {
                val arr= Array(size){0}
                for (i in 0 until size) {
                    arr[i] = i
                }
                "${arr.first()} - ${arr.last()}"
            }
            timeCheck {
                val arr= mutableListOf<Int>()
                for (i in 0 until size) {
                    arr.add(i)
                }
                "${arr.first()} - ${arr.last()}"
            }
            // 초기값 보정

            /* for */


            /* forEach */
            timeCheck("forEach") {
                val arr= mutableListOf<Int>()
                (0 until size).forEach {
                    arr.add(it)
                }
                "${arr.first()} - ${arr.last()}"
            }

            /* while */
            timeCheck("while") {
                val arr= mutableListOf<Int>()
                var i =0
                while(i < size){
                    arr.add(i++)
                }
                "${arr.first()} - ${arr.last()}"
            }

            /* for */
            timeCheck("[array] \nfor") {
                val arr= mutableListOf<Int>()
                for (i in 0 until size) {
                    arr.add(i)
                }
                "${arr.first()} - ${arr.last()}"
            }
            /* for */
            timeCheck("[array] \nfor") {
                val arr= mutableListOf<Int>()
                for (i in 0 until size) {
                    arr.add(i)
                }
                "${arr.first()} - ${arr.last()}"
            }
        }



}
import com.sun.xml.internal.fastinfoset.util.StringArray
import kotlinx.coroutines.*
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.test.timeCheck
import java.util.*
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@OptIn(ExperimentalTime::class,ExperimentalCoroutinesApi::class)
class CommonTest {



    @Test fun filterConditionTest() {
        val list = mutableListOf<Int>()

        for (n in 1..10) {
            list.add(n)
        }

        assertEquals(5, list.filter { it % 2 == 0 }.size)
    }

    /* Array 초기화 -> arrayLambda 가 제일빠름*/
    @Test fun initTimeCheckWithLoop(): Unit =
        runBlocking {
            val size = 1000000
            // 초기값 보정
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


            /* List */
            /* for */
            timeCheck("[List]\nfor") {
                val arr= mutableListOf<Int>()
                for(i in 0 until size){
                    arr.add(i)
                }
                "${arr.first()} - ${arr.last()}"
            }
        }

    /* List 초기화 -> 가 제일빠름*/
    @Test fun initTimeCheckWithLoop2(): Unit =

        runBlocking {
            val size = 1000000
            // 초기값 보정
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
                    arr[i] = i
                }
                "${arr.first()} - ${arr.last()}"
            }

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


            /* List */
            /* for */
            timeCheck("[List]\nfor") {
                val arr= mutableListOf<Int>()
                for(i in 0 until size){
                    arr.add(i)
                }
                "${arr.first()} - ${arr.last()}"
            }
        }

    @Test fun timeCheckToTypeArray() = runTest{
        timeCheck(){

            ""
        }
    }

    //todo typeArray 변환비용 계산




}
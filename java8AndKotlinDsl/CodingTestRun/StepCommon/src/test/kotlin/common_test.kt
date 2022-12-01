import com.sun.xml.internal.fastinfoset.util.StringArray
import kotlinx.coroutines.*
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@OptIn(ExperimentalTime::class,ExperimentalCoroutinesApi::class)
class CommonTest {

    @Test
    fun getCharInToken() {
        val value = "a b"
        val tokens = StringTokenizer(value)

        val value1 = tokens.nextToken().first()
        val value2 = tokens.nextToken().first()
        assertEquals('a', value1)
        assertEquals('b', value2)

    }

    @Test
    @Suppress("SpellCheckingInspection")
    fun getStringArrayInToken() {
        val value =
            """ aaaaaabbb
                    bcccccccc
                    ccddddddd
                """.trimMargin()
        val tokens = StringTokenizer(value)

        val valueArray = StringArray()
        while (tokens.hasMoreTokens())
            valueArray.add(tokens.nextToken())

        assertEquals("aaaaaabbb", valueArray[0])
        assertEquals("bcccccccc", valueArray[1])
        assertEquals("ccddddddd", valueArray[2])

    }

    @Test  /* 첫행의 글자의 갯수 */
    fun numberOfCharWithFirstLine() {
        @Suppress("SpellCheckingInspection")
        val value =
            """ a b
                aaaaaabbb
                bcccccccc
            """.trimMargin()
        val tokens = StringTokenizer(value)

        val valueChar1 = tokens.nextToken().first()
        val valueChar2 = tokens.nextToken().first()
        val valueArray = StringArray()
        while (tokens.hasMoreTokens())
            valueArray.add(tokens.nextToken())

        assertEquals("6 4", numberOfChar(valueChar1, valueChar2, valueArray))
        assertEquals("4 8", numberOfChar('b', 'c', valueArray))

    }

    @Test  /* 첫행의 글자의 갯수 */
    fun primeFactorizationFirstLine() {
        val values = listOf(
            Pair("3", "3"),
            Pair("6", "2\n3"),
            Pair("2", "2"),
            Pair("9991", "97\n103"),
        )

        for (value in values) {
            val tokensInput = StringTokenizer(value.first)
            val valueInt = tokensInput.nextToken().toInt()
            val tokensOutput = StringTokenizer(value.second)

            var idx = 0
            primeFactorization(valueInt)
                .also { results ->
                    while (tokensOutput.hasMoreTokens()) {
                        assertEquals(tokensOutput.nextToken(), results[idx++])
                    }
                }
        }
    }

    @Test
    fun checkSameListString() {
        val list = mutableListOf<String>()
        val str = "a\nb\nc\nd"

        list.add("a")
        list.add("b")
        list.add("c")
        list.add("d")

        val token = StringTokenizer(str)

        val it = list.iterator()
        while (token.hasMoreTokens())
            assertEquals(token.nextToken(), it.next())

    }

    @Test
    fun listNextWithIterator() {
        val list = mutableListOf<String>()

        list.add("a")
        list.add("b")
        list.add("c")
        list.add("d")
        val it = list.iterator()
        assertEquals("a", it.next())
        assertEquals("b", it.next())
        assertEquals("c", it.next())
        assertEquals("d", it.next())
    }

    @Test
    fun arrayInitTest() {
        val boolArr = BooleanArray(11)
        assertEquals(false, boolArr[0])
        assertEquals(false, boolArr[10])

        val falseArr = BooleanArray(11) { false }
        assertEquals(false, falseArr[0])
        assertEquals(false, falseArr[10])

        val trueArr = BooleanArray(11) { true }
        assertEquals(true, trueArr[0])
        assertEquals(true, trueArr[10])

        val intArr = IntArray(11)
        assertEquals(0, intArr[0])
        assertEquals(0, intArr[10])

    }

    @Test
    fun filterTest() {
        val list = mutableListOf<Int>()

        for (n in 1..10) {
            list.add(n)
        }

        assertEquals(5, list.filter { it % 2 == 0 }.size)
    }

    @Test
    fun timeCheckWithLoopForInit(): Unit =
        runBlocking {
            val size = 1000000
            /* 초기값 보정 */
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

    @Test
    fun timeCheckWithLoopForFilter() =
        runTest {
            val size = 1000000
            /* 초기값 보정 */
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


            /* arrayLambda */
            timeCheck("arrayLambda") {
                var arr = Array(size) { i -> i }

                for (multi in 2..10)
                    arr = arr.filter { (it != 0) && it % multi == 0 }.toTypedArray()
                var str =""
                for(s in arr)
                    str += "$s "
                "${str}"
            }


        //todo 필터속도 계산하기

        }

    @Test
    fun timeCheckWithNormal() {
        runTest {
            val size = 4000000
            /* 초기값 보정 */
            timeCheck {
                val arr = Array(size) { 0 }
                for (i in 0 until size) {
                    arr[i] = i
                }
                "${arr.first()} - ${arr.last()}"
            }
            timeCheck {
                val arr = Array(size) { 0 }
                for (i in 0 until size) {
                    arr[i] = i
                }
                "${arr.first()} - ${arr.last()}"
            }
            timeCheck {
                val arr = Array(size) { 0 }
                for (i in 0 until size) {
                    arr[i] = i
                }
                "${arr.first()} - ${arr.last()}"
            }
            timeCheck {
                val arr = Array(size) { 0 }
                for (i in 0 until size) {
                    arr[i] = i
                }
                "${arr.first()} - ${arr.last()}"
            }
            timeCheck {
                val arr = Array(size) { 0 }
                for (i in 0 until size) {
                    arr[i] = i
                }
                "${arr.first()} - ${arr.last()}"
            }
        }
    }
    @Test
    fun timeCheckWithLaunch() =
        runTest {
            val size = 4000000
            /* 초기값 보정 */
            launch{
                timeCheck {
                    val arr= Array(size){0}
                    for (i in 0 until size) {
                        arr[i] = i
                    }
                    "${arr.first()} - ${arr.last()}"
                }
            }
            launch{
                timeCheck {
                    val arr= Array(size){0}
                    for (i in 0 until size) {
                        arr[i] = i
                    }
                    "${arr.first()} - ${arr.last()}"
                }
            }
            launch{
                timeCheck {
                    val arr= Array(size){0}
                    for (i in 0 until size) {
                        arr[i] = i
                    }
                    "${arr.first()} - ${arr.last()}"
                }
            }
            launch{
                timeCheck {
                    val arr= Array(size){0}
                    for (i in 0 until size) {
                        arr[i] = i
                    }
                    "${arr.first()} - ${arr.last()}"
                }
            }
            launch{
                timeCheck {
                    val arr= Array(size){0}
                    for (i in 0 until size) {
                        arr[i] = i
                    }
                    "${arr.first()} - ${arr.last()}"
                }
            }
        }
    @Test
    fun timeCheckWithCoroutineScope() =
        runTest {
            val size = 3000000
            /* 초기값 보정 */
            CoroutineScope(Dispatchers.Default).launch{
                timeCheck {
                    val arr= Array(size){0}
                    for (i in 0 until size) {
                        arr[i] = i
                    }
                    "${arr.first()} - ${arr.last()}"
                }
            }
            CoroutineScope(Dispatchers.Default).launch{
                timeCheck {
                    val arr= Array(size){0}
                    for (i in 0 until size) {
                        arr[i] = i
                    }
                    "${arr.first()} - ${arr.last()}"
                }
            }
            CoroutineScope(Dispatchers.Default).launch{
                timeCheck {
                    val arr= Array(size){0}
                    for (i in 0 until size) {
                        arr[i] = i
                    }
                    "${arr.first()} - ${arr.last()}"
                }
            }
            CoroutineScope(Dispatchers.Default).launch{
                timeCheck {
                    val arr= Array(size){0}
                    for (i in 0 until size) {
                        arr[i] = i
                    }
                    "${arr.first()} - ${arr.last()}"
                }
            }
            CoroutineScope(Dispatchers.Default).launch{
                timeCheck {
                    val arr= Array(size){0}
                    for (i in 0 until size) {
                        arr[i] = i
                    }
                    "${arr.first()} - ${arr.last()}"
                }
            }
        }

    suspend fun timeCheck( timeName: String="----start----", m: suspend () -> String) {
       var invokeStr :String
        val timeMillie = measureTimedValue {
            invokeStr= m.invoke()
        }
        if(timeName=="----start----")
            println(timeName)
        else
            println("$timeName : ${timeMillie.duration} / $invokeStr")

    }
    @Test
    fun runTestLaunchTest(){
        runTest {
            launch { delay(1000) }
            launch { delay(1000) }
            launch { delay(1000) }
            launch { delay(1000) }
            launch { delay(1000) }
            launch { delay(1000) }
            launch { delay(1000) }
        }
    }

    @Test
    fun runBlockingTest(){
        runBlocking {
            launch { delay(1000) }
            launch { delay(1000) }
            launch { delay(1000) }
            launch { delay(1000) }
            launch { delay(1000) }
            launch { delay(1000) }
            launch { delay(1000) }
        }

    }
    @Test
    fun checkTimeNoneLaunch(){
        runBlocking {
            delay(1000)
            delay(1000)
            delay(1000)
        }

    }
}
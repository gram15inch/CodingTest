import kotlinx.coroutines.*
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import util.test.timeCheck
import util.test.timeCheckAsync
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@OptIn(ExperimentalCoroutinesApi::class)
class CoroutineTest {

    /* 자식 코루틴이 끝나기전에 종료됨 */
    @Test
    fun timingCheckExitInCoroutineScope() {
        CoroutineScope(Dispatchers.Default).launch {
            launch { delay(1000); println("child run!") }
            launch { delay(1000); println("child run!") }
            launch { delay(1000); println("child run!") }
            launch { delay(1000); println("child run!") }
        }
        println("parent exit")
    }

    /* 자식 코루틴이 모두 실행후 종료  */
    @Test
    fun timingCheckExitInRunBlocking() {
        runBlocking {
            launch { delay(1000); println("child run!") }
            launch { delay(1000); println("child run!") }
            launch { delay(1000); println("child run!") }
            launch { delay(1000); println("child run!") }
        }
        println("parent exit")
    }


    /* 직렬로 실행됨 4sec */
    @Test
    fun runSerialFunWithoutLaunch() {
        runBlocking {
            delay(1000)
            delay(1000)
            delay(1000)
            delay(1000)
        }
    }

    /* 병렬로 실행됨 1sec */
    @Test
    fun runParallelFunWithLaunch() {
        runBlocking {
            launch { delay(1000) }
            launch { delay(1000) }
            launch { delay(1000) }
            launch { delay(1000) }
        }

    }


    /* 자식 코루틴이 모두 병렬로 실행되나 delay 무시 0.1sec */
    @Test
    fun avoidDelayInRunTest() {
        runTest {
            launch { delay(1000) }
            launch { delay(1000) }
            launch { delay(1000) }
            launch { delay(1000) }
        }
    }


    /* Dispatchers 타입별 속도 차이없음 */
    @Test
    fun timeCheckDispatchers() =
        runTest {
            val size = 3000000

            // Dispatchers.Main 은 오류
            CoroutineScope(Dispatchers.Default).launch {
                timeCheck("Default") {
                    val arr = Array(size) { 0 }
                    for (i in 0 until size) {
                        arr[i] = i
                    }
                    "${arr.first()} - ${arr.last()}"
                }
            }
            CoroutineScope(Dispatchers.IO).launch {
                timeCheck("IO") {
                    val arr = Array(size) { 0 }
                    for (i in 0 until size) {
                        arr[i] = i
                    }
                    "${arr.first()} - ${arr.last()}"
                }
            }
            CoroutineScope(Dispatchers.Unconfined).launch {
                timeCheck("Unconfined") {
                    val arr = Array(size) { 0 }
                    for (i in 0 until size) {
                        arr[i] = i
                    }
                    "${arr.first()} - ${arr.last()}"
                }
            }
        }




    /* launch 로만 시간 측정시 불안정한 값이 나옴 */
    @Test
    fun stableCheckSameTimeWithLaunch() =
        runTest {
            val size = 1000000
            val times = 9
            launch {
                timeCheck("toTypedArray") {
                    val array = Array(size) { i -> i }
                    var filteredArray = array
                    for (time in 2..times) {
                        filteredArray = filteredArray.filter { it % time == 0 }.toTypedArray()
                    }
                    ""
                }
            }
            launch {
                timeCheck("toTypedArray") {
                    val array = Array(size) { i -> i }
                    var filteredArray = array
                    for (time in 2..times) {
                        filteredArray = filteredArray.filter { it % time == 0 }.toTypedArray()
                    }
                    ""
                }
            }
            launch {
                timeCheck("toTypedArray") {
                    val array = Array(size) { i -> i }
                    var filteredArray = array
                    for (time in 2..times) {
                        filteredArray = filteredArray.filter { it % time == 0 }.toTypedArray()
                    }
                    ""
                }
            }
        }

    /* 새로운 코루틴을 async 받아 함수 끝에 await 을 실행시키면 안정된 값이 나옴 */
    // 대신 전체수행시간이 올라감 ex) 30ms * 6개 병렬 => 180ms * 6
    @Test
    fun stableCheckSameTimeWithAsync() =
        runTest {
            val size = 1000000 // size 4백만 이상부터 급속도로 느려짐
            val times = 9
            // 생성방법 1
            // default = 추천 6, size 9 이상부터 급격한 오류 발생
            // io = 추천 12,  size 14 이상부터 급격한 오류 발생
            val arrs = Array(3) {
                timeCheckAsync("toTypedArray") {
                    val array = Array(size) { i -> i }
                    var filteredArray = array
                    for (time in 2..times) {
                        filteredArray = filteredArray.filter { it % time == 0 }.toTypedArray()
                    }
                    "생성방법 1-$it"
                }
            }
            for (arr in arrs)
                arr.await()
        }

    /* 함수 하나만 메인스레드에서 측정하는것이 가장 정확함 */
    @OptIn(ExperimentalTime::class)
    @Test
    fun stableCheckSameTimeWithNoneCoroutine() {
        val size = 1000000 // size 4백만 이상부터 급속도로 느려짐
        val times = 9
        repeat(1){
            measureTimedValue {
                val array = Array(size) { i -> i }
                var filteredArray = array
                for (time in 2..times) {
                    filteredArray = filteredArray.filter { it % time == 0 }.toTypedArray()
                }
            }.also { println(it.duration) }
        }
    }
}

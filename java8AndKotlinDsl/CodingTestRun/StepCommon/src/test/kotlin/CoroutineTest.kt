import kotlinx.coroutines.*
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import util.test.timeCheck

@OptIn(ExperimentalCoroutinesApi::class)
class CoroutineTest {
    /* delay 무시 */
    @Test fun parallelTestInRunTest(){
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

    /* launch 유,무 속도 차이없음 */
    @Test fun parallelTestInRunBlocking(){
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
    @Test fun parallelTestWithoutLaunchInRunBlocking(){
        runBlocking {
            delay(1000)
            delay(1000)
            delay(1000)
        }

    }

    /* Dispatchers 타입별 속도 차이없음 */
    @Test fun checkSpeedWithDispatchers() =
        runTest {
            val size = 3000000
            // 초기값 보정
            CoroutineScope(Dispatchers.Default).launch{
                timeCheck() {
                    val arr= Array(size){0}
                    for (i in 0 until size) {
                        arr[i] = i
                    }
                    "${arr.first()} - ${arr.last()}"
                }
            }

            // Dispatchers.Main 은 오류
            CoroutineScope(Dispatchers.Default).launch{
                timeCheck("Default") {
                    val arr= Array(size){0}
                    for (i in 0 until size) {
                        arr[i] = i
                    }
                    "${arr.first()} - ${arr.last()}"
                }
            }
            CoroutineScope(Dispatchers.IO).launch{
                timeCheck("IO") {
                    val arr= Array(size){0}
                    for (i in 0 until size) {
                        arr[i] = i
                    }
                    "${arr.first()} - ${arr.last()}"
                }
            }
            CoroutineScope(Dispatchers.Unconfined).launch{
                timeCheck("Unconfined") {
                    val arr= Array(size){0}
                    for (i in 0 until size) {
                        arr[i] = i
                    }
                    "${arr.first()} - ${arr.last()}"
                }
            }
        }
}
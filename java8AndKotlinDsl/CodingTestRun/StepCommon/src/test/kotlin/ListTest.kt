import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import util.test.timeCheck
import util.test.timeCheckAsync
import java.util.*

class ListTest {

    @Test fun dataCheckSameListString() {
        val list = mutableListOf<String>()
        val str = "a\nb\nc\nd"

        list.add("a")
        list.add("b")
        list.add("c")
        list.add("d")

        val token = StringTokenizer(str)

        val it = list.iterator()
        while (token.hasMoreTokens())
            Assertions.assertEquals(token.nextToken(), it.next())

    }

    @Test fun runIteratorNextWithList() {
        val list = mutableListOf<String>()

        list.add("a")
        list.add("b")
        list.add("c")
        list.add("d")
        val it = list.iterator()
        Assertions.assertEquals("a", it.next())
        Assertions.assertEquals("b", it.next())
        Assertions.assertEquals("c", it.next())
        Assertions.assertEquals("d", it.next())
    }

    @Test fun timeCheckWithValAndVar()= runBlocking {
        val size = 100000
        val rp = 100
        arrayOf(
            timeCheckAsync("mutableListFor") { // 70ms
                val mutList = mutableListOf<Int>()
                repeat(rp){
                    mutList.clear()
                    for (value in 0..size)
                        mutList.add(value)
                }
                ""
            },
            timeCheckAsync("mutableListForEach") { //90ms
                val mutList = mutableListOf<Int>()
                repeat(rp){
                    mutList.clear()
                    (0..size).forEach(){
                        mutList.add(it)
                    }
                }
                ""
            },
            timeCheckAsync("List") { // 95ms
                var list = listOf<Int>()
                repeat(rp){
                    list =  (0..size).toList()
                }
                ""
            }
        ).forEach { it.await() }

    }


}
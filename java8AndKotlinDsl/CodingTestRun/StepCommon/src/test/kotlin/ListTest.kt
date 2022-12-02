import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import util.test.timeCheck
import java.util.*

class ListTest {

    @Test fun checkSameListString() {
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

    @Test fun listNextWithIterator() {
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

    @Test fun initTimeCheckValAndVar()= runBlocking {
        val size = 100000
        val rp = 100
        timeCheck() {
            val mutList = mutableListOf<Int>()
            repeat(10){
                mutList.clear()
                for (value in 0..size)
                    mutList.add(value)
            }
            ""
        }

        timeCheck("mutableListFor") {
            val mutList = mutableListOf<Int>()
            repeat(rp){
                mutList.clear()
                for (value in 0..size)
                    mutList.add(value)
            }
                ""
        }
        timeCheck("mutableListForEach") {
            val mutList = mutableListOf<Int>()
            repeat(rp){
                mutList.clear()
                (0..size).forEach(){
                    mutList.add(it)
                }
            }
                ""
        }
        timeCheck("List") {
            var list = listOf<Int>()
            repeat(rp){
              list =  (0..size).toList()
            }
            ""
        }

    }


}
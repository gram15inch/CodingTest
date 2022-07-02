
import org.junit.Test
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.test.assertEquals


class Step09 {
    val br1978 = listOf(
        Pair(listOf("4","1 2 3 4"),2),
        Pair(listOf("4","1 3 5 7"),3)
    )

    @Test
    fun test_1978(){
        for(br in br1978)
            assertEquals(ex1978(br.first[0],br.first[1]),br.second)
    }



}
import com.sun.xml.internal.fastinfoset.util.StringArray
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class CommonTest {

    @Test
    fun getCharInToken(){
        val value ="a b"
        val tokens = StringTokenizer(value)

        val value1 = tokens.nextToken().first()
        val value2 = tokens.nextToken().first()
        Assertions.assertEquals('a', value1)
        Assertions.assertEquals('b', value2)

    }

    @Test
    fun getStringArrayInToken(){
        val value =
                """ aaaaaabbb
                    bcccccccc
                    ccddddddd
                """.trimMargin()
        val tokens = StringTokenizer(value)

        val valueArray = StringArray()
        while(tokens.hasMoreTokens())
            valueArray.add(tokens.nextToken())

        Assertions.assertEquals("aaaaaabbb", valueArray[0])
        Assertions.assertEquals("bcccccccc", valueArray[1])
        Assertions.assertEquals("ccddddddd", valueArray[2])

    }

    @Test  /* 첫행의 글자의 갯수 */
    fun numberOfCharWithFirstLine(){
        val value =
            """ a b
                aaaaaabbb
                bcccccccc
            """.trimMargin()
            val tokens = StringTokenizer(value)

            val valueChar1 = tokens.nextToken().first()
            val valueChar2 = tokens.nextToken().first()
            val valueArray = StringArray()
            while(tokens.hasMoreTokens())
                valueArray.add(tokens.nextToken())

            Assertions.assertEquals("6 4", numberOfChar(valueChar1, valueChar2, valueArray))
            Assertions.assertEquals("4 8", numberOfChar('b', 'c', valueArray))

    }
    @Test  /* 첫행의 글자의 갯수 */
    fun primeFactorizationFirstLine(){
        val values = listOf(
            Pair("3","3"),
            Pair("6","2\n3"),
            Pair("2","2"),
            Pair("9991","97\n103"),
        )

            for(value in values){
                val tokensInput = StringTokenizer(value.first)
                val valueInt = tokensInput.nextToken().toInt()
                val tokensOutput = StringTokenizer(value.second)

                var idx = 0
                primeFactorization(valueInt)
                    .also { results->
                        while(tokensOutput.hasMoreTokens()){
                            Assertions.assertEquals(tokensOutput.nextToken(), results.get(idx++)?:"null")
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
            assertEquals(token.nextToken(),it.next())

    }
    @Test
    fun listNextWithIterator(){
        val list = mutableListOf<String>()

        list.add("a")
        list.add("b")
        list.add("c")
        list.add("d")
        val it = list.iterator()
        assertEquals("a",it.next())
        assertEquals("b",it.next())
        assertEquals("c",it.next())
        assertEquals("d",it.next())


    }
}
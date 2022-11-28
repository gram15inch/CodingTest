import com.sun.xml.internal.fastinfoset.util.StringArray
import org.junit.jupiter.api.Assertions
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



    fun createValueList():List<String>{
        val values = mutableListOf<String>()
        values.add(
            """ a b
                aaaaaabbb
                bcccccccc
            """.trimMargin()
        )
        return values
    }
}
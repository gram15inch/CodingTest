import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.StringTokenizer

class Step08Test{

    @Test
    fun exactPrimeNumberRange(){

        val values = listOf(
            Pair("3 16","3\n5\n7\n11\n13"),
        )

        for(value in values){
            val tokensInput = StringTokenizer(value.first)
            val valueInt1 = tokensInput.nextToken().toInt()
            val valueInt2 = tokensInput.nextToken().toInt()
            val tokensOutput = StringTokenizer(value.second)

            primeNumberInRange(valueInt1,valueInt2)
                .also { results->

                    val it = results.iterator()
                    while(tokensOutput.hasMoreTokens()){
                        assertEquals(tokensOutput.nextToken(), it.next())
                    }
                }
        }
    }
    @Test
    fun exactPrimeNumber(){

        assertEquals(false,primeNumber(1))
        assertEquals(true,primeNumber(3))
        assertEquals(true,primeNumber(5))
        assertEquals(true,primeNumber(7))
        assertEquals(false,primeNumber(8))
        assertEquals(false,primeNumber(28))
        assertEquals(true,primeNumber(29))

    }
}


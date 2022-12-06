import kotlinx.coroutines.*
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.StringTokenizer
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@OptIn(ExperimentalTime::class)
class Step08Test {

    @Test
    fun exactNumberOfPrimeWithBertrandPostulate() {
        val values = listOf(
            Pair(
                "1\n" +
                "10\n" +
                "13\n" +
                "100\n" +
                "1000\n" +
                "10000\n" +
                "100000"
                ,
                "1\n" +
                "4\n" +
                "3\n" +
                "21\n" +
                "135\n" +
                "1033\n" +
                "8392"
            ),
        )

        for (value in values) {
            val tokensInput = StringTokenizer(value.first)
            val tokensOutput = StringTokenizer(value.second)

            val arrStringIn = Array(tokensInput.countTokens()){tokensInput.nextToken().toInt()}
            val arrStringOut :Array<Int>

            val arrStringExpect = Array<String>(tokensOutput.countTokens()){tokensOutput.nextToken()}

            val timeMillie = measureTimedValue {
                arrStringOut = numberOfPrimesWithBertrandPostulate(arrStringIn)
            }
            for(i in arrStringExpect.indices)
                assertEquals(arrStringExpect[i], arrStringOut[i].toString())

            println("측정시간 : $timeMillie")
        }
    }

    @Test
    fun timeTrack() {
        runTest {



        }

    }

    @Test
    fun exactPrimeNumberRange() {

        val values = listOf(
            Pair("3 16", "3\n5\n7\n11\n13"),
        )

        for (value in values) {
            val tokensInput = StringTokenizer(value.first)
            val valueInt1 = tokensInput.nextToken().toInt()
            val valueInt2 = tokensInput.nextToken().toInt()
            val tokensOutput = StringTokenizer(value.second)
            val resultList: Array<Int>
            val timeMillie = measureTimedValue {
                resultList = primeNumbersInRangeWithSieve(valueInt1, valueInt2)
            }

            resultList.also { results ->
                val it = results.iterator()
                while (tokensOutput.hasMoreTokens()) {
                    assertEquals(tokensOutput.nextToken(), it.next())
                }
            }
            println("측정시간 : $timeMillie")
        }
    }

    @Test
    fun exactPrimeNumber() {

        assertEquals(false, isPrimeNumber(1))
        assertEquals(true, isPrimeNumber(3))
        assertEquals(true, isPrimeNumber(5))
        assertEquals(true, isPrimeNumber(7))
        assertEquals(false, isPrimeNumber(8))
        assertEquals(false, isPrimeNumber(28))
        assertEquals(true, isPrimeNumber(29))

    }

    @Test
    fun exactPrimeNumberWithSqrt() {
        assertEquals(false, isPrimeNumberWithSqrt(1))
        assertEquals(true, isPrimeNumberWithSqrt(3))
        assertEquals(true, isPrimeNumberWithSqrt(5))
        assertEquals(true, isPrimeNumberWithSqrt(7))
        assertEquals(false, isPrimeNumberWithSqrt(8))
        assertEquals(false, isPrimeNumberWithSqrt(28))
        assertEquals(true, isPrimeNumberWithSqrt(29))

    }

    @Test
    fun exactPrimeNumberWithArray() {
        val values = listOf(
            Pair("3 16", "3\n5\n7\n11\n13"),
            Pair("1 16", "2\n3\n5\n7\n11\n13"),
        )

        for (value in values) {
            val tokensInput = StringTokenizer(value.first)
            val valueInt1 = tokensInput.nextToken().toInt()
            val valueInt2 = tokensInput.nextToken().toInt()
            val tokensOutput = StringTokenizer(value.second)

            primeNumbersInRangeWithSieve(valueInt1, valueInt2)
                .also { results ->
                    val it = results.iterator()
                    while (tokensOutput.hasMoreTokens()) {
                        assertEquals(tokensOutput.nextToken(), it.next())
                    }
                }
        }
    }
}


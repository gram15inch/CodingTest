
import kotlinx.coroutines.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import java.util.StringTokenizer
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

class Step08Test{


    @OptIn(ExperimentalTime::class)
    @Test
    @Timeout(2)
    fun timeTrack() {

        runBlocking {
            this.launch {
                 val timeMillie = measureTimedValue { primeNumbersInRangeWithFilteredList(1,1000000) }
                println("측정시간1 : ${timeMillie.duration}")
            }
            this.launch {
                 val timeMillie2 = measureTimedValue { primeNumbersInRange(1,1000000) }
                println("측정시간2 : ${timeMillie2.duration}")
            }
        }

    }
    @OptIn(ExperimentalTime::class)
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
            val resultList :List<String>
            val timeMillie = measureTimedValue {
                resultList =  primeNumbersInRangeWithFilteredList(valueInt1,valueInt2)
            }

            resultList.also { results->
                    val it = results.iterator()
                    while(tokensOutput.hasMoreTokens()){
                        assertEquals(tokensOutput.nextToken(), it.next())
                    }
                }
            println("측정시간 : $timeMillie")
        }
    }
    @Test
    fun exactPrimeNumber(){

        assertEquals(false,isPrimeNumber(1))
        assertEquals(true,isPrimeNumber(3))
        assertEquals(true,isPrimeNumber(5))
        assertEquals(true,isPrimeNumber(7))
        assertEquals(false,isPrimeNumber(8))
        assertEquals(false,isPrimeNumber(28))
        assertEquals(true,isPrimeNumber(29))

    }
    @Test
    fun exactPrimeNumberWithSqrt(){
        assertEquals(false,isPrimeNumberWithSqrt(1))
        assertEquals(true,isPrimeNumberWithSqrt(3))
        assertEquals(true,isPrimeNumberWithSqrt(5))
        assertEquals(true,isPrimeNumberWithSqrt(7))
        assertEquals(false,isPrimeNumberWithSqrt(8))
        assertEquals(false,isPrimeNumberWithSqrt(28))
        assertEquals(true,isPrimeNumberWithSqrt(29))

    }
    @Test
    fun exactPrimeNumberWithArray(){
        val values = listOf(
            Pair("3 16","3\n5\n7\n11\n13"),
        )

        for(value in values){
            val tokensInput = StringTokenizer(value.first)
            val valueInt1 = tokensInput.nextToken().toInt()
            val valueInt2 = tokensInput.nextToken().toInt()
            val tokensOutput = StringTokenizer(value.second)

            primeNumbersInRangeWithFilteredList(valueInt1,valueInt2)
                .also { results->
                    val it = results.iterator()
                    while(tokensOutput.hasMoreTokens()){
                        assertEquals(tokensOutput.nextToken(), it.next())
                    }
                }
        }
    }
}


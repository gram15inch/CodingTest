
import kotlinx.coroutines.*
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.StringTokenizer
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

class Step08Test{


    @OptIn(ExperimentalTime::class)
    @Test
    fun timeTrack() {
    val size = 10000000
        runTest {
            val arr1 : Array<Int>
            val arr2 : Array<Int>
            val arr3 : Array<Int>
            val timeMillie3 = measureTimedValue { arr3= primeNumbersInRange(1,size)}

            val timeMillie = measureTimedValue { arr1= primeNumbersInRangeWithSieve(1,size)}
            println("측정시간1 : ${timeMillie.duration}")
             val timeMillie2 = measureTimedValue { arr2= primeNumbersInRange(1,size) }
            println("측정시간2 : ${timeMillie2.duration}")


            val ar1it= arr1.iterator()
            val ar2it= arr2.iterator()

          println("${arr1.size} /${arr1.first() } - ${arr1.last()}")
          println("${arr2.size} /${arr2.first() } - ${arr2.last()}")


            while (ar2it.hasNext())
                assertEquals(ar2it.next(),ar1it.next())
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
            val resultList :Array<Int>
            val timeMillie = measureTimedValue {
                resultList =  primeNumbersInRangeWithSieve(valueInt1,valueInt2)
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
            Pair("1 16","2\n3\n5\n7\n11\n13"),
        )

        for(value in values){
            val tokensInput = StringTokenizer(value.first)
            val valueInt1 = tokensInput.nextToken().toInt()
            val valueInt2 = tokensInput.nextToken().toInt()
            val tokensOutput = StringTokenizer(value.second)

            primeNumbersInRangeWithSieve(valueInt1,valueInt2)
                .also { results->
                    val it = results.iterator()
                    while(tokensOutput.hasMoreTokens()){
                        assertEquals(tokensOutput.nextToken(), it.next())
                    }
                }
        }
    }
}


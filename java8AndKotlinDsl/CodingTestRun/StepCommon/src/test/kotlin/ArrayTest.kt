import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.StringTokenizer

class ArrayTest {

    @Test
    fun dataCheckDefaultFalseWithBoolArray() {
        val boolArr = BooleanArray(11)
        Assertions.assertEquals(false, boolArr[0])
        Assertions.assertEquals(false, boolArr[10])

        val falseArr = BooleanArray(11) { false }
        Assertions.assertEquals(false, falseArr[0])
        Assertions.assertEquals(false, falseArr[10])

        val trueArr = BooleanArray(11) { true }
        Assertions.assertEquals(true, trueArr[0])
        Assertions.assertEquals(true, trueArr[10])

        val intArr = IntArray(11)
        Assertions.assertEquals(0, intArr[0])
        Assertions.assertEquals(0, intArr[10])

    }


    @Test
    fun dataCheckSameArray(){
        val arr1= Array(10){it}

        arr1.forEach { print(it) }

        assertEquals(true,arr1 == arr1)
        assertEquals(true, arr1.equals(arr1))
        assertEquals(true, arr1.contentEquals(arr1))
        assertEquals(true,arr1 === arr1)

        arr1[0]=213

        assertEquals(true,arr1 == arr1)
        assertEquals(true, arr1.equals(arr1))
        assertEquals(true, arr1.contentEquals(arr1))
        assertEquals(true,arr1 === arr1)


        val arr2 = arr1

        assertEquals(true,arr1 == arr2)
        assertEquals(true, arr1.equals(arr2))
        assertEquals(true, arr1.contentEquals(arr2))
        assertEquals(true,arr1 === arr2)

    }
    @Test
    fun createArrayWithTokens() {
        val tokens = StringTokenizer("1\n2\n3")
        val arr = Array(tokens.countTokens()){tokens.nextToken()}
        arr.forEach { println(it) }
    }
}
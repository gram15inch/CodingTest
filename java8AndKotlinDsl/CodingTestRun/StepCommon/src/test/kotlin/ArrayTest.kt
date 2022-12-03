import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

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

}
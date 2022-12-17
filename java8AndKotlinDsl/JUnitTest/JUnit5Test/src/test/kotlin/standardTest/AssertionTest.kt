package standardTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import org.opentest4j.AssertionFailedError
import java.util.*
import java.util.stream.Stream

fun expectErrorMessage(message :String, assert: ()->Unit ){
    assertThrows<AssertionFailedError> { assert() }
        .message
        .run {
            assertEquals(message,this)
        }
}
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AssertionTest {
    @DisplayName("assertThrows: 실패가 감지되지 않을시 오류")
    @Test fun test0(){
        assertThrows<AssertionFailedError> { assertTrue(false) }
    }

    @DisplayName("assertThrows.message: 실패시 사용자 메세지 출력")
    @Test fun test1() {
        assertThrows<AssertionFailedError> { assertTrue(false, "isFalse") }
            .message
            .run {
                assertEquals("isFalse ==> expected: <true> but was: <false>",this )
            }
    }

    @DisplayName("assertTrue, assertFalse : 순서대로 ture,false 가 아니면 오류")
    @Test fun test2(){
        assertTrue(true)
        expectErrorMessage("expected: <true> but was: <false>"){
            assertTrue(false)
        }

        assertFalse(false)
        expectErrorMessage("expected: <false> but was: <true>"){
            assertFalse(true)
        }

    }

    @DisplayName("assertNull, assertNotNull: 순서대로 not null, null 이면 오류")
    @Test fun test3(){
        assertNull(null)
        expectErrorMessage("expected: <null> but was: <not Null>"){
            assertNull("not Null")
        }

        assertNotNull("not null")
        expectErrorMessage("expected: not <null>"){
            assertNotNull(null)
        }
    }



    @DisplayName("assertEquals: 두 오브젝트가 같지않으면 오류 (컬렉션: 원소, 배열: 인스턴스)")
    @MethodSource("data4")
    @ParameterizedTest
    fun test4(a :Any , b :Any , bool : Boolean, message :String){
        if(bool)
            assertEquals(a,b)
        else{
            expectErrorMessage(message) {
                assertEquals(a, b)
            }
        }
    }
    private fun data4(): Stream<Arguments> {

        val list= listOf(1,2)
        val copy = list
        val sameElement = listOf(1,2)
        val differentElement = listOf(2,3)
        val differentIndex = listOf(2,1)

        val array= arrayOf(1,2)
        val copy2 = array
        val sameElement2 = arrayOf(1,2)
        val differentElement2 = arrayOf(2,3)
        val differentIndex2 = arrayOf(2,1)

       return Stream.of(
            arguments(1, 1, true, ""),
            arguments(1, 0, false, "expected: <1> but was: <0>"),

            arguments(list, copy, true, ""),
            arguments(list, sameElement, true, ""), // ✨
            arguments(list, differentIndex, false, "expected: <[1, 2]> but was: <[2, 1]>"),
            arguments(list, differentElement, false, "expected: <[1, 2]> but was: <[2, 3]>"),

            arguments(array, copy2, true, ""),
            arguments(array, sameElement2, false, "expected: $array<[1, 2]> but was: $sameElement2<[1, 2]>"),
            arguments(array, differentIndex2, false, "expected: <[1, 2]> but was: <[2, 1]>"),
            arguments(array, differentElement2, false, "expected: <[1, 2]> but was: <[2, 3]>"),
        )
    }
    @DisplayName("assertSame: 두 오브젝트(인스턴스)가 동일하지 않으면 오류")
    @MethodSource("data5")
    @ParameterizedTest
    fun test5(a:Any, b:Any, bool:Boolean, message:String){
        if(bool)
            assertSame(a,b)
        else
            expectErrorMessage(message) {
                assertSame(a, b)
            }
    }
    private fun data5(): Stream<Arguments> {
        val list= listOf(1,2)
        val copy = list
        val sameElement = listOf(1,2)
        val differentElement = listOf(2,3)
        val differentIndex = listOf(2,1)

        val array= arrayOf(1,2)
        val copy2 = array
        val sameElement2 = arrayOf(1,2)
        val differentElement2 = arrayOf(2,3)
        val differentIndex2 = arrayOf(2,1)

        return Stream.of(
            arguments(1, 1, true, ""),
            arguments(1, 0, false, "expected: <1> but was: <0>"),

            arguments(list, copy, true, ""),
          //  arguments(list, sameElement, false, "expected: ${list}<[1, 2]> but was: $sameElement<[1, 2]>"),
            arguments(list, differentIndex, false, "expected: <[1, 2]> but was: <[2, 1]>"),
            arguments(list, differentElement, false, "expected: <[1, 2]> but was: <[2, 3]>"),

            arguments(array, copy2, true, ""),
            arguments(array, sameElement2, false, "expected: $array<[1, 2]> but was: $sameElement2<[1, 2]>"),
            arguments(array, differentIndex2, false, "expected: <[1, 2]> but was: <[2, 1]>"),
            arguments(array, differentElement2, false, "expected: <[1, 2]> but was: <[2, 3]>"),
        )
    }

    @DisplayName("assertArrayEquals: 두 배열(원소)이 동일하지 않으면 오류")
    @MethodSource("data6")
    @ParameterizedTest
    fun test6(a:Array<Int>, b:Array<Int>, bool:Boolean, message:String){
        if(bool)
            assertArrayEquals(a,b)
        else
            expectErrorMessage(message) {
                assertArrayEquals(a, b)
            }
    }
    private fun data6(): Stream<Arguments> {
        val array= arrayOf(1,2)
        val copy2 = array
        val sameElement2 = arrayOf(1,2)
        val differentElement2 = arrayOf(3,4)
        val differentIndex2 = arrayOf(2,1)

        return Stream.of(
            arguments(array, copy2, true, ""),
            arguments(array, sameElement2, true, ""),
            arguments(array, differentIndex2, false, "array contents differ at index [0], expected: <1> but was: <2>"),
            arguments(array, differentElement2, false, "array contents differ at index [0], expected: <1> but was: <3>"),
        )
    }


}


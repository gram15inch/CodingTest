package standardTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.opentest4j.AssertionFailedError


class AssertionTest {
    @Test
    fun test0(){ // assertThrows: 실패가 감지되지 않을시 오류
        assertThrows<AssertionFailedError> { assertTrue(false) }
    }

    @Test // 실패시 사용자 메세지 출력
    fun test1() {
        assertThrows<AssertionFailedError> { assertTrue(false, "isFalse") }
            .message
            .run {
                assertEquals("isFalse ==> expected: <true> but was: <false>",this )
            }
    }

    @Test
    fun test2(){ //assertTrue, assertFalse : 순서대로 ture,false 가 아니면 오류
        assertTrue(true)
        exceptFailMessage("expected: <true> but was: <false>"){
            assertTrue(false)
        }

        assertFalse(false)
        exceptFailMessage("expected: <false> but was: <true>"){
            assertFalse(true)
        }

    }
    @Test
    fun test3(){// assertNull: null 이 아니면 오류 , assertNotNull: null 이면 오류
        assertNull(null)
        exceptFailMessage("expected: <null> but was: <not Null>"){
            assertNull("not Null")
        }

        assertNotNull("not null")
        exceptFailMessage("expected: not <null>"){
            assertNotNull(null)
        }
    }
}

fun exceptFailMessage(message :String, assert: ()->Unit ){
    assertThrows<AssertionFailedError> { assert() }
        .message
        .run {
            assertEquals(message,this)
        }
}
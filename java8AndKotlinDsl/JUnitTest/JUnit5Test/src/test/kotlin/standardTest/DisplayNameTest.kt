package standardTest

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


@DisplayName("🎃Changed class name ")
class DisplayNameTest {

    @Test
    @DisplayName("🎉Changed fun name")
    fun test1(){
        println("test1 call!!")
    }
}
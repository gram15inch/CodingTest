package standardTest

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class DisabledTest {

    @Disabled
    @Test
    fun test1(){
        throw Exception("test1 exception!!")
    }
    @Test
    fun test2(){
        println("test2 call!!")
    }
}
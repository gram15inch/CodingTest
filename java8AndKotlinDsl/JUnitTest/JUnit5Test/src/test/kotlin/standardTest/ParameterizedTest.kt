package standardTest

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ParameterizedTest {


    @ParameterizedTest
    @MethodSource( "data1" )
    fun test1(a:Int,b:Int,sum:Int){
        assertEquals(sum,a+b)
    }

       private fun data1():Stream<Arguments> = Stream.of(
           arguments(1,2,3),
           arguments(2,2,4),
           arguments(3,4,7)
       )

}

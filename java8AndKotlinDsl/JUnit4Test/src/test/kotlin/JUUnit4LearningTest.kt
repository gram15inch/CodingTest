import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameter
import org.junit.runners.Suite
import kotlin.test.assertEquals


@RunWith(Suite::class)
@Suite.SuiteClasses(InitParameterTestWithConstructor::class,InitParameterTestWithAnnotation::class)
class SuiteTest{

}


@RunWith(Parameterized::class)
class InitParameterTestWithConstructor(val input1: Int, val input2: String,val input3:String) {
    companion object {
        @JvmStatic
        //@Parameterized.Parameters
        @Parameterized.Parameters(name = "{index}: input1={0} input2={1} input3={2}?")
        fun data() : Collection<Array<Any>> {
            return listOf(
                arrayOf(1234, "num","1234num"),
                arrayOf(4321, "num","4321num")
            )
        }
    }

    @Test
    fun catIntString(){
        assertEquals(input3,intStr(input1,input2))
    }
    private fun intStr(int :Int,str:String) = "$int$str"
}


@RunWith(Parameterized::class)
class InitParameterTestWithAnnotation {

    @JvmField
    @Parameter(0)
    var input1: Int=0

    @JvmField
    @Parameter(1)
    var input2: String=""

    @JvmField
    @Parameter(2)
    var input3:String=""

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() : Collection<Array<Any>> {
            return listOf(
                arrayOf(1234, "num","1234num"),
                arrayOf(4321, "num","4321num"),
                arrayOf(1111, "num","1111num")
            )
        }
    }

    @Test
    fun catIntString(){
        assertEquals(input3,intStr(input1,input2))
    }
    fun intStr(int :Int,str:String) = "$int$str"
}




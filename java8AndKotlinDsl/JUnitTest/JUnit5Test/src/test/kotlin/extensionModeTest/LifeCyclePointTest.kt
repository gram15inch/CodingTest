
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler
import java.io.IOException


class LifeCyclePointTest {

    @ExtendWith(IgnoreIOEEPoint::class,BeforeAllPoint::class)
    @Test
    fun test1(){
        throw IOException("IOException")
    }
}

class IgnoreIOEEPoint : TestExecutionExceptionHandler{
    override fun handleTestExecutionException(context: ExtensionContext?, throwable: Throwable?) {
        println("${throwable?.message} 발생!!")
        if (throwable !is IOException) {
            throw throwable!!
        }
    }
}

class BeforeAllPoint : BeforeAllCallback{
    override fun beforeAll(context: ExtensionContext?) {
        println("BeforeAllTest")
    }
}
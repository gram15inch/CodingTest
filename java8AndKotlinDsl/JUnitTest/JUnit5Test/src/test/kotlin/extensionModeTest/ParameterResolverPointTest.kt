
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.api.extension.ParameterResolver


class ParameterResolverPointTest{
    @ExtendWith(ParameterResolverPoint::class)
    @Test
    fun test1(parameter: Any){
        println("$parameter DI!!")
    }
}

class ParameterResolverPoint : ParameterResolver{
    override fun supportsParameter(parameterContext: ParameterContext?, extensionContext: ExtensionContext?): Boolean {
        return true
    }

    override fun resolveParameter(parameterContext: ParameterContext?, extensionContext: ExtensionContext?): Any {
        return "my parameter"
    }
}

import junit.framework.AssertionFailedError
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Rule
import org.junit.rules.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.lang.AssertionError
import kotlin.test.assertEquals


class JUnit4LearningRule {
    @get:Rule
    val collector = ErrorCollector()

    @Test
    fun example() {
        repeat(3){
            try{
                throw IllegalAccessError("$it")
            }
            catch (e:IllegalAccessError){
                collector.addError(e)
            }
        }


       /* collector.addError(Throwable("first thing went wrong"))
        collector.checkThat("a", equalTo("b"))


        collector.checkThat(1, equalTo(2))
        collector.checkThat(2, equalTo(2))*/
        println("Test continues even if an error occurs")
    }

    @Test
    fun example2() {
        repeat(3){
            try{
                assertEquals(it,1)
            }
            catch (e:AssertionError){
                collector.addError(e)
            }
        }


       /* collector.addError(Throwable("first thing went wrong"))
        collector.checkThat("a", equalTo("b"))


        collector.checkThat(1, equalTo(2))
        collector.checkThat(2, equalTo(2))*/
        println("Test continues even if an error occurs")
    }
}



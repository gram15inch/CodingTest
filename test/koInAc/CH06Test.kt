package koInAc
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

// 2/2
//널아님 단언을 사용해 null 이 될 수 있는 프로퍼티 접근하기
internal class NullableTest {
    private var myService: MyService? = null // null 가능
    @BeforeAll fun setUp(){
        myService = MyService() // null 불가 프로퍼티는 생성후 다른 메소드에서 초기화 불가
    }
    @Test
    fun testAction(){
        Assertions.assertEquals("foo",myService!!.performAction()) // null 검사를 넣거나 !! 연산자 사용 필수
    }

}
// 나중에 초기화하는 프로퍼티 사용하기
internal class LateIntTest {
    private lateinit var myService: MyService // null 불가 :: lateinit
    @BeforeAll fun setUp(){
        myService = MyService() // null 불가 프로퍼티임에도 다른 메소드 초기화
    }
    @Test
    fun testAction(){
        Assertions.assertEquals("foo",myService.performAction()) // null 검사 없이 바로사용
    }
    // 만약 예외가 발생하면 lateinit 예외가 나오고 그 프로퍼티 이름까지 알 수 있음으로 단순히 Null 예외보다 훨씬 좋음

    // lateinit 프로퍼티는 의존관계 주입(DI) 프레임워크와 함께 사용하는 경우가 많음
}
class MyService{
    fun performAction(): String = "foo"
}

package koInAc.ch07

import koInAc.ch06.StringProcessor

// ch06으로 옮겨야함

// String 파라미터가 있는 자바 인터페이스
class StringPrinter: StringProcessor{
    override fun process(value: String) { // 컴파일러가 null 이 아님을 검사하는 단언문을 만들어줌
        // 사용하지 않아도 마찬가지
    }
}
// 자바 인터페이스를 여러 다른 널 가능성으로 구현하기
class NullableStringPrinter : StringProcessor{
    override fun process(value: String?) {
        if(value !=null)
            println(value)
    }
}

// 코틀린의 원시 타입
/* 자바에서의 타입
    1. 원싵타입 : 변수에 값이 직접 들어감
    2. 참조타입 : 변수의 메모리장 객체위치가 들어감
*/


// null 이 될 수있는 원시 타입
data class Person(val name: String, val age:Int? =null){ // Int? 는 자바의 래퍼 타입으로 컴파일 됨
    fun isOlderThan(other:Person):Boolean?{
        if(age==null || other.age == null)
            return null
        return age > other.age
    }
}
fun nullPersonName(){
    println(Person("Sum",35).isOlderThan(Person("Amy",42)))
    println(Person("Sum",35).isOlderThan(Person("Amy")))
}

// 원시타입으로 이루어진 대규모 컬렉션을 효율적으로 저장해야 한다면 원시타입 서드파티 라이브러리(트로브) 나 배열을 사용해야함
// 277p - 2/3

// 숫자 변환
fun transNum(){
    val i = 1
  // val l:Long = i // int => long 으로 자동변환 불가
    val l : Long = i.toLong() // 직접 변환 메소드 호출

    val x = 1
    val list = listOf(1L,2L,3L)
    x in list // false

    x.toLong() in list // true
}
/* 원시 타입 리터럴
   1. L 접미사가 붙은 Long 타입 리터럴: 123L
   2. 표준 부동소수점 표기법을 사용한 Double 타입 리터럴: 0.12, 2.0, 1.2e10
   3. f나 F 접미사가 붙은 Float 타입 리터럴: 123.4f, .456F, 1e3f
   4. 0x 나 0X 접두사가 붙은 16진 리터럴: 0xCAFEBABE, 0xbcdL
   4. 0b 나 0B 접두사가 붙은 2진 리터럴: 0b000000101

   코틀린 1.1 부터 숫자리터럴 중간에 밑줄(_)을 넣을 수 있다(1_234, 1_0000_0000_0000L, 1_000.123_456, 0b0100_0001 등)
*/

// 알려진 타입 자동변환
fun foo(l:Long) = println(l)
fun autoTrans(){
    val b:Byte = 1 // 상수 같은 적적한 타입으로 해석
    val l = b+1L // + 는 Byte 와 Long 을 인자로 받을 수 있다.
    foo(42) // 인자 타입 으로 추촌이 가능
}
// 코틀린은 값 넘침을 계산하느라 추가바용이 들지 않음

// Any, Any? 최상위 타입
// 자바에서의 Object 와 비슷하나 자바는 참조타입만 정점으로 함 :: Int 같은경우 래퍼로 감싸야함

fun useAny(){ // Any :: Object
    val answer: Any = 43 // 원시타입값이 객체로 감싸짐
    // toString, equals, hashCode 메소드 외에 Object 에 다른 메소드를 사용 하고 싶다면
    // Object 타입으로 값을 캐스트 해야함
}

// Unit 타입 : 코틀린의 void


fun main() {

}
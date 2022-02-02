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
data class Person(val name: String, val age:Int? =null){
    fun isOlderThan(other:Person):Boolean?{
        if(age==null || other.age == null)
            return null
        return age > other.age
    }
}

fun main() {
    println(Person("Sum",35).isOlderThan(Person("Amy",42)))
    println(Person("Sum",35).isOlderThan(Person("Amy")))
}
package koInAc.ch07

import koInAc.ch06.StringProcessor
import java.io.BufferedReader
import java.io.File
import java.io.StringReader
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.lang.NumberFormatException

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
// 인스턴스의 차이가 void 와 Unit 을 구분지음 :: 함수형 프로그래밍에서 Unit 은 전통적으로 하나의 인스턴스만을 갖는 타입을 의미
interface Processor<T>{ // Unit 은 일반적인 기능을 갖는 일반적인 타입 :: 제네릭 파라미터의 인자로 사용가능
    fun process():T // 반환값이 제네렉 파라미터일 경우 오버라이드한 함수가 반환을 하지않아도 자동으로 Unit 이 반환 됨
}
class NoResultProcessor: Processor<Unit>{
    override fun process() {
        // T 를 반환해야 하지만 Unit 이므로 자동으로 묵시적 반횐됨
    }
}
// Nothing
// 이 타입을 반환 하는 함수는 결코 정상적으로 끝나지 않음을 나타냄
fun fail(message:String): Nothing{
    throw IllegalStateException(message) // 무조건 예외 발생
}
fun callNull():String?{
    return null
}

fun callNoting(){
    //fail("Error occurred")
    val not :Nothing // 아무것도 저장할 수 없음
       val a = callNull() ?: fail("No address") // 엘비스 연산자를 통해 전제조건을 검사 할 수 있음
    println(a)
}


// 컬렉션과 배열
// 널 가능성과 컬렉션
// 널이 될 수 있는 값으로 이뤄진 컬렉션 만들기
fun readNumbers(reader: BufferedReader):List<Int?>{
    val result = ArrayList<Int?>() // 널이 될 수 있는 Int 값으로  이뤄진 리스트
    for (line in reader.lineSequence()){
        try{
            val number = line.toInt()
            result.add(number) // 널이아닌 값을 리스트에 추가
        }
        catch (e:NumberFormatException){
            result.add(null) // 현재 줄을 파싱할 수 없으므로 리스트에 널 추가
        }
    }
    return  result
}
// List<Int?> : 원소가 null 가능
// List<Int>? : 리스트가 null 가능

// null 이 될 수 있는 값으로 이뤄진 컬렉션 다루기
fun addValidNumbers(numbers: List<Int?>){
    var sumOfValidNumbers = 0
    var invalidNumbers = 0
    for (number in numbers)
        if(number != null)
            sumOfValidNumbers +=number
        else
            invalidNumbers++
    println("Sum of Valid numbers: $sumOfValidNumbers")
    println("Invalid numbers: $invalidNumbers")

}
// filterNotNull을 null 이 될 수 있는 값으로 이뤄진 컬렉션에 대해 사용하기
// 컬렉션으로 널 값을 걸러내는 경우가 자주 있어 코틀린 라이브러리에서 지원
fun addValidNumbersFilter(numbers: List<Int?>){
    val validNumbers = numbers.filterNotNull() // 컬렉션안에 null 이 들어있지 않음을 보장 :: type? => type
    println("Sum of valid numbers: ${validNumbers.sum()}")
    println("Invalid numbers: ${numbers.size - validNumbers.size}")
}
fun useNullableCOl(){
    val reader = BufferedReader(StringReader("1\nabc\n42"))
    val numbers = readNumbers(reader)
    addValidNumbers(numbers)
    addValidNumbersFilter(numbers)
}

// 읽기 전용과 변경 가능한 컬렉션 인터페이스
fun <T>copyElements(source:Collection<T>,
                    target:MutableCollection<T>) {
    for (item in source)
        target.add(item)
}
fun useCopyElements(){
    val source: Collection<Int> = arrayListOf(3,5,7)
    val target: MutableCollection<Int> = arrayListOf(1)
    // val target: Collection<Int> = arrayListOf(1) // 읽기전용을 변경가능에 넣을경우 컴파일오류
    copyElements(source,target)
    println(target)


}

fun useSameSource(){
    val s = arrayListOf(3,5,7) // 하나의 인스턴스

    // 같은 인스턴스 참조
    val c: Collection<Int> = s // 읽기전용 컬렉션 인터페이스
    val m: MutableCollection<Int> = s // 변경가능 컬렉션 인터페이스

    c.map{print(it)}.run { println("") } // 357
    m.remove(3) // 변경가능 컬렉션만 수정
    c.map{print(it)}.run { println("") } // 57

}

/*
    1. 읽기전용 컬렉션이 꼭 변경 불가능한 컬렉션일 필요는 없다
    2. 같은 인스턴스를 가리키는 변경 가능한 인터페이스 타입의 참조도 있을 수 있다.
    3. 읽기 전용 컬렉션이 항상 "스레드 안전" 하지는 않다.
*/

// 코틀린 컬렉션과 자바
/* 자바 코드 CollectionUtils.java
    public class CollectionUtils {
        public static List<String> uppercaseAll(List<String> items){
            for(int i = 0; i< items.size();i++)
                items.set(i,items.get(i).toUpperCase());
            return items;
        }
    }
 */
// 코틀린 컬렉션을 자바 함수 인자로 넘기기
fun printInUppercase(list:List<String>){ // 읽기 전용 파라미터를 선언
    println(CollectionUtils.uppercaseAll(list)) // 자바 함수라 읽기전용 컬렉션을 수정 가능하게함
    println(list.first()) // 컬렉션이 변경됐는지 확인
    // 자바 함수에서 변경 뿐만 아니라 null 도 넣을 수 있어 위의경우 주의가 필요함
}
fun usePrintInUppercase(){
    val list = listOf("a","b","c")
    printInUppercase(list)
    // list.add  // 변경 불가능한 컬렉션
    // list.remove
}

// 컬렉션을 플랫폼 타입으로 다루기
// 컬렉션 파라미터가 있는 자바 인터페이스 - FileContentsProcessor.java
// 위 인터페이스를 코틀린으로 구현
class FileIndexer : FileContentProcessor{
    override fun processContents(path: File?,
                                 binaryContents: ByteArray?, // 1
                                 textContents: List<String>?) { // 1,2,3
    }
    /* 설계조건
        1. 일부파일은 이진파일 이므로 텍스트로 표시 할 수 없어 리스트는 널 가능
        2. 파일의 각줄은 널일 수 없으므로 리스트의 원소는 널이 될 수 없다
        3. 이 리스트는 파일의 내용표현만 하면 됨으로 읽기전용 이다.
    */

}
// 컬렉션 파라미터가 있는 자바인터페이스2 - dataParser.java
/*
    public interface DataParser<T> {
        void parseData(String input,
                       List<T> output, // 1
                       List<String> errors); // 22
    }

*/
// 위 인터페이스를 코을린으로 구현
class PersonParser : DataParser<Person>{
    override fun parseData(input: String,
                           output: MutableList<Person>,
                           errors: MutableList<String?>) {
    }
    /* 설계조건
        1. 호출하는 쪽에서 항상 오류메세지를 받아야 하므로 List<String>은 널이 되면 안된다.
        2. errors 의 원소는 널이 될 수도 있다.
        3. output 에 들어가는 정보를 파싱하는 과정에서 오류가 발생하지 않으면
         그 정보와 연관된 오류 메세지는 널이다.
        4. 구현 코드에서 원소를 추가할 수 있어야 하므로 List<String> 은 변경 가능해야 한다.
    */
}

// 객체의 배열과 원시 타입의 배열
// 배열 사용하기
fun useArray(args: Array<String>){
    for(i in args.indices) // 배열의 인덱스 값의 범위에 대해 이터레이션 하기
        println("Argument $i is: ${args[i]}") // i 로 배열원소에 접근
// 알파벳으로 이뤄진 배열 만들기
    val letters = Array<String>(26){i -> ('a'+i).toString() }
    println(letters.joinToString(""))
    val strings = listOf("a","b","c")
    println("%s/%s/%s".format(*strings.toTypedArray()))

// 컬렉션을 vararg 메소드에게 넘기기
    println("%s/%s/%s".format(*strings.toTypedArray())) // vararg 인자를 넘기기위해 스프레드(*) 연사나 사용

}
// Array<Int> 같으 경우 Int 가 Integer 로 감싸진 배열을 저장한다
// 원시타입을 배열로 저장 하고싶다면 원시타입 배열 메소드를 사용 해야한다.
// ByteArray, CharArray, BooleanArray  :: 박싱하지 않음
// => byte[], char[], Boolean[]

// 원시타입 배열 생성 방법
fun makeArray(){
    // 인자로 사이즈만 받고 값은 디폴트(0) 값으로 초기화
    val fiveZeros = IntArray(5)

    // 인자로 값들을 가변인자로 받아서 초기화
    val fiveZeroToo = intArrayOf(0,0,0,0,0)

    // 인자로 크기와 람다를 인자로 받아 초기화
    val squares = IntArray(5){i ->(i+1)*(i+1)}
    println(squares.joinToString())

    // 기존 컬렉션에 toIntArray 등의 변환 함수 사용
    Array<Int>(1){0}.toIntArray()
}

// 배열에 forEachIndexed 사용하기
fun useForEachIdx(args: Array<String>){
    args.forEachIndexed{index, element ->
        println("Argument $index is: $element")
    }
}
fun main() {
    useArray(Array(0){""})
}
package koInAc
import koInAc.Color.*
import sun.util.resources.hr.CalendarData_hr
import java.io.BufferedReader
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import java.util.*

// 78p - 1/8
enum class Color(
    private val r:Int, private val g : Int, private val b :Int
){
    RED(255,0,0),ORANGE(255,165,0),
    YELLOW(255,255,0),GREEN(0,255,0)
    ,BLUE(0,0,255);
    fun rgb()=(r*256+g)+b
}

// 객체를 스트링으로
fun getMnemonic(c:Color)= when(c){
        RED ->"R"
        ORANGE ->"O"
        YELLOW ->"Y"
        GREEN ->"G"
        BLUE ->"B"
    }
// 여러객체를 스트링으로
fun getWarmth(c: Color)= when(c){
    RED, ORANGE,YELLOW->"warm"
    GREEN ->"neutral"
    BLUE->"cold"
}
// 객체조합을 객체로
fun mix(c1:Color,c2:Color)= when(setOf(c1,c2)){
    setOf(RED,YELLOW) -> ORANGE
    setOf(BLUE,YELLOW) -> GREEN
    else-> throw Exception("Dirty color")
}
// 객체리스트를 부울로
fun mt(c1: Color,c2:Color):Boolean{
    val m1= mutableListOf(RED,YELLOW)
    val m2= mutableListOf(RED,BLUE)
    return when(mutableListOf(c1,c2)){
        mutableListOf(BLUE,GREEN),m1,m2-> true
        else -> false
    }
}
// enum, when 실습
enum class ErrorCode(val code:Int){
    DBERROR(-2),SUCCESS(1),STRINGERROR(-1);
}
fun errorCodeDescription(ec:ErrorCode) = when(ec){
    ErrorCode.SUCCESS->"ss"
    else-> throw Exception("notCode")
}
// 인자없이 조합을 객체로 - 성능향상
fun mixOptimized(c1:Color,c2: Color)= when
{   // 조건이 계산식 이어야함
    (c1 == RED && c2 == YELLOW) || (c1 == RED && c2 == BLUE)-> ORANGE
    (c1 == RED && c2 == GREEN) ->  BLUE
    else -> throw java.lang.Exception("Dirty Color")
}

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

// 스마트 캐스팅
// if로 조건분기
fun eval1(e:Expr): Int {
    if(e is Num){
        val n = e as Num // 불필요한 캐스팅
        return n.value
    }
    if(e is Sum)
        return eval1(e.left) + eval1(e.right) // 스마트 캐스팅
    throw IllegalArgumentException("Unknown expression")
}
// @호출 : eval1(Sum(Num(2),Num(3))) == 5

// when 으로 조건분기
fun eval2(e:Expr): Int = when(e){
    is Num -> e.value
    is Sum -> eval2(e.left) + eval2(e.right)
    else -> throw IllegalArgumentException("Unknown expression")
}


// when 으로 조건분기(블럭)
fun evalWithLogging(e: Expr): Int = when(e){
    is Num ->{
        println("num: ${e.value}")
        e.value
    }
    is Sum -> {
        val left = evalWithLogging(e.left)
        val right = evalWithLogging(e.right)
        println("left $left + right $right")
        left + right // 마지막 값이 반환
    }
    else -> throw IllegalArgumentException("Unknown expression")
}
/* @호출
    evalWithLogging(
             Sum(Sum(Num(3)
                    ,Num(3))
                ,Sum(Sum(Num(2)
                        ,Num(2))
                    ,Sum(Num(1)
                        ,Num(1)
                    )
                )
            )
    )
*/
// map 초기화 - for
fun treeMapForInit(){
    val binaryReps = TreeMap<Char, String>()

    for(c in 'A'..'f'){ // 연산자를 문자타입에 적용
        val binary = Integer.toBinaryString(c.toInt())
        // [key] = value
        binaryReps[c] = binary // java :: binaryReps.put(c,binary)
    }
    // 92P - 1/9

    for((letter,binary) in binaryReps){
        println("$letter = $binary")
    }
}
// 배열 초기화 - for
fun listForInit(){
    val list = arrayListOf("10","11","1001")
    for ((index,element) in list.withIndex()) // 인덱스와 함께 이터레이션
        println("$index: $element")
}
// in 으로 범위에 속하는지 검사하기
fun isLetter(c:Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c:Char) = c !in '0'..'9'

// when 에서 in 사용하기
fun recognize(c:Char) = when(c){
    in '0'..'9' -> "digit"
    in 'a'..'z', in 'A'..'Z'-> "letter"
    else -> "else"
}

fun inRange(){
    // 문자 뿐만 아니라 Comparable 을 이용한 모든 클래스로 범위를 만들수있다.
    // 하지만 항상 객체를 반환 할 수는 없고 범위안에 속하는지는 결정할 수 있다.
    println("Kotlin" in "Java".."Scala") // "Java" <= "Kotlin" && "Kotlin" <= "Scala"
    println("Kotlin" in setOf("Java","Scala"))  // 컬렉션도 가능

}

// try 사용
fun readNumber(r: BufferedReader):Int?{
    return try{
        val line = r.readLine()
        Integer.parseInt(line)
    }catch (e: NumberFormatException){
        null
    }
    finally {
        r.close()
    }
}

// try 를 식으로 사용
fun readNumber2(r: BufferedReader){
    val number = try{ // 식 : 값을 생성
        Integer.parseInt(r.readLine())
    }catch (e: NumberFormatException){
        return // null 을 사용하면 계속 진행된다
    }
    println(number)
}

fun main() {



}
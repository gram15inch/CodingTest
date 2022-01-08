package koInAc
import koInAc.Color.*

// 78p - 1/8
enum class Color(
    private val r:Int, private val g : Int, private val b :Int
){
    RED(255,0,0),ORANGE(255,165,0),
    YELLOW(255,255,0),GREEN(0,255,0)
    ,BLUE(0,0,255);
    fun rgb()=(r*256+g)+b
}
fun getMnemonic(c:Color)= when(c){
        RED ->"R"
        ORANGE ->"O"
        YELLOW ->"Y"
        GREEN ->"G"
        BLUE ->"B"
    }
// 객체를 스트링으로
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
    val m1= mutableListOf(RED,GREEN)
    val m2= mutableListOf(RED,YELLOW)
    val m3= mutableListOf(RED,BLUE)
    return when(mutableListOf(c1,c2)){
        mutableListOf(BLUE,GREEN),m2,m3-> true
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

fun mixOptimized(c1:Color,c2: Color)= when
{
    (c1 == RED && c2 == YELLOW) || (c1 == RED && c2 == BLUE)-> ORANGE
    (c1 == RED && c2 == GREEN) ->  BLUE
    else -> throw java.lang.Exception("Dirty Color")
}


fun main() {
    println(mixOptimized(RED,YELLOW))

}
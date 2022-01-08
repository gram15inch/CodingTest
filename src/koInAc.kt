import com.sun.org.apache.xpath.internal.operations.Bool
import java.lang.Exception



// 78p - 1/8
enum class Color(
    val r:Int, val g : Int, val b :Int
){
    RED(255,0,0),ORANGE(255,165,0),
    YELLOW(255,255,0),GREEN(0,255,0)
    ,BLUE(0,0,255);
    fun rgb()=(r*256+g)+b
}
fun getMnemonic(c:Color)= when(c){
        Color.RED ->"R"
        Color.ORANGE ->"O"
        Color.YELLOW ->"Y"
        Color.GREEN ->"G"
        Color.BLUE ->"B"
    }
// 객체를 스트링으로
fun getWarmth(c: Color)= when(c){
    Color.RED,Color.ORANGE,Color.YELLOW->"warm"
    Color.GREEN->"neutral"
    Color.BLUE->"cold"
}
// 객체조합을 객체로
fun mix(c1:Color,c2:Color)= when(setOf(c1,c2)){
    setOf(Color.RED,Color.YELLOW) -> Color.ORANGE
    setOf(Color.BLUE,Color.YELLOW) -> Color.GREEN
    else-> throw Exception("Dirty color")
}
// 객체리스트를 부울로
fun mt(c1: Color,c2:Color):Boolean{
    val M1= mutableListOf(Color.RED,Color.GREEN)
    val M2= mutableListOf(Color.RED,Color.YELLOW)
    val M3= mutableListOf(Color.RED,Color.BLUE)
    return when(mutableListOf(c1,c2)){
        mutableListOf(Color.BLUE,Color.GREEN),M2,M3-> true
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


fun main() {

}
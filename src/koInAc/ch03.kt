package koInAc
// ch02로 옮겨야됨
// when 에서 in 사용하기
fun recognize(c:Char) = when(c){
    in '0'..'9' -> "digit"
    in 'a'..'z', in 'A'..'Z'-> "letter"
    else -> "else"
}

fun main() {

}

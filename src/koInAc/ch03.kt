package koInAc
import external.ExTalk
import koInAc.hi

// 컬렉션은 자바에 있는걸 그대로 사용
// 확장함수를 이용해 코틀린 추가기능 구현
fun createCollection(){
    val set = hashSetOf(1,7,53)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    println(set.javaClass) // javaClass == getClass()
    println(list.javaClass)
    println(map.javaClass)
}

open class Talk(){
    var space ="home"
}
// 확장함수
fun Talk.hi() ="Talk hi" // Talk : 수신객체 타입
fun Talk.bye() { println("${this}:Talk bye") } // this : 수신객체[생략가능]

// 다른 패키지 확장함수
// import external.ExTalk - 확장할 클래스 임포트
// import koInAc.hi as hiAs - 다른 패키지에서 사용시 개별함수 임포트 [as로 함수명 변경 가능] : 이름충돌 회피
fun ExTalk.hi() ="hi"
fun ExTalk.getC() = content // public 멤버만 접근가능

// 117p - 1/9

class Sing : Talk()
// 확장함수는 오버라이드 불가능 - Talk.hi() (x)
fun Sing.hi() = "sing hi"
fun say(){
    val t :Talk = Sing()  // 수신객체 타입 : Talk , 수신객체 : Sing
    println(t.hi()) // 수신객체 타입에 따라 호출
    // Talk.hi() 호출
}

// 확장 프로퍼티
var Talk.moveSpace : String
    get() = "move $space"
    set(v :String){
        this.space = v
    }
fun main() {
    val t = Talk()

    println(t.moveSpace)
    t.moveSpace = "school"
    println(t.moveSpace)



}

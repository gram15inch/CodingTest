package koInAc

import external.ExTalk
import koInAc.hi as hias
fun createCollection(){
    val set = hashSetOf(1,7,53)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    println(set.javaClass) // javaClass == getClass()
    println(list.javaClass)
    println(map.javaClass)
}

class Talk()
// 확장함수
fun Talk.hi() ="hi" // Talk : 수신객체 타입
fun Talk.bye() { println("${this}: bye") } // this : 수신객체[생략가능]

// 다른 패키지 확장함수
// import external.ExTalk
// import koInAc.hi as hiAs - 다른 클래스에서 사용시[as로 함수명 변경 가능]
fun ExTalk.hi() ="hi"
fun ExTalk.getC() = content // public 멤버만 접근가능

// 117p - 1/9
fun main() {

}

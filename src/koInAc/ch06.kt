package koInAc

import javafx.scene.control.Button
import java.io.File
import java.util.concurrent.Delayed

// 243p

// ch05로 가야함

// 1/31
fun postponeComputation(delay :Int, computation:Runnable) {
    println("$delay")
    computation.run()
}
fun javaApiInKotlin(){
// 객체를 명시적으로 선언해 전달
    postponeComputation(1000, object :Runnable{ // 메소드 호출시마다 객체 생성
        override fun run() =println(42)
    })
// 매개변수를 람다로 전달
    postponeComputation(1000){ println(42) } // 람다를 한번만 무명객체에 생성하고 호출시마다 사용
    val runnable = Runnable { println(42) } // 이 코드와 같음
    postponeComputation(1000, runnable)

// 람다가 주변 영역의 변수를 포획
    fun handleComputation(id:String){
        postponeComputation(1000){println(id)} // 매번 포획한 변수를 포핳한 새 객체를 생성
    }
}
// 233p


fun main() {

}
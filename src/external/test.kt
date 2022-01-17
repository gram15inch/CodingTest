package external

import java.awt.MouseInfo
import java.awt.PointerInfo
import java.awt.Robot
import java.awt.event.InputEvent


fun main() {
    val rob = Robot()
    var pt :PointerInfo
  /*  while(true) {
        rob.setAutoDelay(1000 * 1)
        pt = MouseInfo.getPointerInfo()
        println(pt.location)
    }*/
        for(n in 0..5){
        rob.setAutoDelay(1000 * 1) // 1min
        rob.mouseMove(150 + n * 300, 1 * 20)
        rob.mousePress(InputEvent.BUTTON1_DOWN_MASK)
        rob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK)
        }
    println("end")
}

fun timeCheck(){
    val beforeTime = System.currentTimeMillis() //코드 실행 전에 시간 받아오기


    //실험할 코드 추가

    //실험할 코드 추가
    val afterTime = System.currentTimeMillis() // 코드 실행 후에 시간 받아오기

    val secDiffTime = (afterTime - beforeTime)  //두 시간에 차 계산

    println("시간차이(m) : $secDiffTime")

}
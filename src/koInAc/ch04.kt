package koInAc


// 141p - 1/11

// 인터페이스 선언
interface Clickable{
    fun click()
    fun showOff() = println("I'm clickable!") // 구현이 있는 메소드 선언가능 - 디폴트 메소드
}
interface Focusable{
    fun setFocus(b: Boolean) = println("I ${if(b) "got" else "lost"} focus.")
    fun showOff() = println("I'm focusable!") // - 디폴드 메소드
}

// 인터페이스 구현
class Button : Clickable{
    override fun click() = println("I was clicked ")
    // showOff() - 디폴트 메소드 호출
}

class ButtonInCF : Clickable, Focusable{
    override fun click() = println("I waw clicked")
    override fun showOff() { // 둘 이상의 디폴드 구현이 있는경우 필수적으로 새로운 구현을 해야함
        super<Clickable>.showOff() // super<상위타입이름>.메소드 - 호출
        super<Focusable>.showOff() // 구현중 하나만 호출 해도 됨
    }
}

fun main() {
    val button =ButtonInCF()
    button.showOff()
    button.setFocus(true)
    button.click()

}
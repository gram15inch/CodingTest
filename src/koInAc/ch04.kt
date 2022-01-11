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

// 146p - 1/11

// 열린 메소드를  포함하는 열린 클래스 정의
open class RichButton : Clickable{ // open 으로 상속 가능하게 정의
    fun disable(){} // 기본 final
    open fun animate(){} // 함수도 따로 open 으로 정의 해야함
    override fun click(){} // 오버라이드한 메소드는 기본으로 열려있음
}

// 152p
fun main() {

}
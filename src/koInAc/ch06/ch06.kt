package koInAc.ch06

import java.lang.StringBuilder

// 243p

// ch05로 가야함

// 1/31

// 자바 api 호출하기
fun callJavaApi(){
    val btn = Button06()
    /* Java
// 자바에서는 익명클래스의 인스턴스를 만들어 넘김
    setOnclickListener(new OnclickListener() {
        @Override
        public void onClick(String v) {
            System.out.println(v);
        }
    });
    */
// 코틀린에서 함수형 인터페이스를 인자로 취하는 자바 메소드 호출
    btn.setOnclickListener{view:String-> println(view)} // 코틀린에서는 람다를 바로 넘김 :: 컴파일러가 자동변환


    /* Java
        // 함수형인터페이스 : 하나의 추상 메서드만 가지는 인터페이스
        interface OnclickListener{
            void onClick(String v);
        }
    */

}

// 코틀린에서 api 생성시
class Button06Ko{
    fun setOnclickListenerInterface(l:OnclickListener){} // 함수형 인터페이스 - Java
    fun setOnclickListenerInterfaceKO(l:OnclickListenerKo){} // 함수형 인터페이스 - Kotlin
    fun setOnclickListenerType(l:(String)->Unit){}  // 함수 타입 - Kotlin
}
interface OnclickListenerKo{
    fun onClick(v:String)
}
fun callKotlinApi(){
    val btn = Button06Ko()

// 람다를 Java SAM 에 넘기면 컴파일러가 무명 클래스의 인스턴스로 변환
    btn.setOnclickListenerInterface{ v: String? -> println("click: $v") }
// 람다를 Kotlin SAM 에 넘기면 변환하지않음 :: 타입오류
    // btn.setOnclickListenerInterfaceKO{ v: String? -> println("click: $v") }
// 람다를 Kotlin type 에 넘겨야함
    btn.setOnclickListenerType{ v: String? -> println("click: $v") }
}

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
    // 인라인 함수에 람다를 넘길때는 익명객체를 만들지 않음
    // 컬렉션 확장함수는 대부분 인라인 함수이므로 마찬가지
}

// SAM 생성자

fun samConstructor(){

// 컴파일러가 자동으로 람다를 SAM 으로 변환시키지 못하는 경우 사용
    fun createAllDoneRunnable():Runnable{ // 반환값에 반드시 SAM 이 와야함
        return Runnable { println("All done!") } // 람다를 SAM 으로 감쌈
    }
// SAM 생성자를 사용해 listener 인스턴스 재사용 하기
    val listener = OnclickListener { v ->
        val text = when(v){
            "1"->"First Button"
            "2"->"Second Button"
            else->"Unknown Button"
        }
        println(text)
    }
   val btn1= Button06().setOnclickListener(listener)
   val btn2= Button06().setOnclickListener(listener)
}

// 수신 객체 지정 람다: with, apply
// 알파벳 만들기
fun alphabet():String{
    val result = StringBuilder()
    for(letter in 'A'..'Z')
        result.append(letter)
    result.append("\nNOew I know the alphabet!")
    return result.toString()
}
// with 을 사용해 알파벳 만들기
fun alphabetWith(): String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder){ // 수신객체 지정
        for(letter in 'A'..'Z')
            this.append(letter) // this 로 접근
        append("\nNOew I know the alphabet!") // this 생략
        toString() // 마지막 줄 반환
    }
}

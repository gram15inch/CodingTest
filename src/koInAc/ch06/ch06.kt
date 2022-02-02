package koInAc

import koInAc.ch06.PersonJA
import java.awt.event.ActionEvent
import java.lang.IllegalArgumentException
import javax.swing.AbstractAction
import javax.swing.JList

// 243p
// 2/1

// null 불가 타입 :: Type
fun strLenSafe(s:String):Int = s.length // s 는 항상 null 이 아님
// null 허용 타입 :: Type?
fun strLenSafeQ(s:String?) :Int = if(s!=null) s.length else 0 // null 체크를 항상 해야함

// nullable 의 연산제한
fun nullRestrict(){
    val x :String? = null // type? 은 type 에 대입할수 없음
    // val y :String = x  // 변수
    // strLenSafe(x) // 파라미터
}
// ?. 안전한 호출 연산자
fun printAllCaps(s:String?){
    val allCaps: String? = s?.toUpperCase() // null 체크후 맞으면 호출하지 않고 null 을 반환
    println(allCaps)
}
// null 이 될 수 있는 프로퍼티를 다루기 위해 안전한 호출 사용하기
class Employee(val name: String, val manager: Employee?)
fun managerName(employee: Employee):String? = employee.manager?.name

fun callManagerName(){
    val ceo = Employee("Da Boss",null)
    val developer = Employee("Bob Smith",ceo)

    println(managerName(ceo)) // null
    println(managerName(developer)) // Da Boss
}

class Address(val streetAddress: String, val zipCode :Int,
            val city: String, val country:String)
class Company(val name: String, val address: Address?)
class Person(val name: String, val company: Company?)

// 안전한 호출 연쇄시키기
fun Person.countryName():String{
    val country = this.company?.address?.country
    return if(country != null) country else "UnKnown"
}

// ?: 엘비스 연산자 :: 널 복합 연산자
fun strLenSafeElvis(s:String?):Int = s?.length ?:0 // Type? 으로 받았으니 Type 으로 반환

// throw 와 엘비스 연사나 함께 사용하기
fun printShippingLabel(person: Person){
    val address = person.company?.address
        ?: throw IllegalArgumentException("No address")
    with(address){
        println(streetAddress)
        println("$zipCode $city $country")
    }
}
// as? 안전한 캐스트
class PersonAs(val firstName: String, val lastName: String){
    override fun equals(o: Any?): Boolean {
    val otherPerson = o as? PersonAs ?: return false // 타입이 서로 일치하지 않으면 반환
        return otherPerson.firstName == firstName &&
                otherPerson.lastName == lastName
    }

    override fun hashCode(): Int =
        firstName.hashCode() * 37 + lastName.hashCode()
}

fun equalsPersons() {
    val p1 = PersonAs("Dmitry","Jemerov")
    val p2 = PersonAs("Dmitry","Jemerov")
    println(p1==p2) // == 연산자는 equals 를 호출
    println(p1.equals(42))
}

// !! 널 아님 단언
fun ignoreNulls(s:String?){
    val sNotNull: String = s!!
    println(sNotNull.length)
    // Person().company!!.address!!.country // !! 를 한줄에 쓰는것은 피함 :: 예외 스택트레이스에는 줄단위로만 표시
}

// 스윙 액션에서 널 아님 단언 사용하기
class CopyRowAction(val list: JList<String>): AbstractAction(){
    override fun isEnabled(): Boolean =
        list.selectedValue != null

    override fun actionPerformed(e: ActionEvent?) { // isEnabled 가 true 일때만 호출
        val value = list.selectedValue!!
    }
}
// 258p - 2/2
fun sendEmailTo(email: String){println("Sending email to $email")}
fun letCheck(){
    val email: String? = ""
    // sendEmailTo(email) // 불가능
    if(email!=null) sendEmailTo(email)

    email?.let{email-> // email null 이면 람다를 실행 하지 않음
        sendEmailTo(email)
    }  // 아무것도 반환하지 않음


    var emailVar:String? = "yole@example.com"
    emailVar?.let { sendEmailTo(it) }
    emailVar = null
    emailVar?.let{ sendEmailTo(it) }

}
class PersonEmail(){ var email ="email contents" }
fun getPerson(): PersonEmail? = PersonEmail()
fun letNullCheck(){
    val person = getPerson()
    if(person != null) sendEmailTo(person.email)
// 변수를 만들지 않고 let 으로 바로 실행하기
    getPerson()?.let { sendEmailTo(it.email) } // person 을 만들지 않음
}

 /* 나중에 초기화할 프로퍼티 - CH06Test.kt 에 있음
 1. 널아님 단언을 사용해 null 이 될 수 있는 프로퍼티 접근하기
 2. 나중에 초기화하는 프로퍼티 사용하기
*/

// 널이 될 수 있는 타입 확장

// null 이 될 수 있는 수신객체에 대해 확장 함수 호출하기
fun verifyUserInput(input:String?){
    if(input.isNullOrBlank()){ // 안전한 호출을 하지 않앗음
        println("Please fill in the required fields")
    }
    // let 은 수신객체에 null 체크를 하지않음
 val person :PersonEmail? =  getPerson()
    person?.let { sendEmailTo(it.email) }
}
// 확장함수는 본문 안에서 null 가능 수신객체의 널체크를 할 수 있음
// 위 객체의 this 는 제일먼저 null 체크를 해야함

fun String?.isNullOrBlank():Boolean = this == null || this.isBlank() // 같은줄이라도 || 앞에서 null 검사를 했으면 뒷부분은 뒤부분은 필요없음

//  타입 파라미터의 null 가능성
// null 이 될 수 있는 타입 파라미터 다루기
fun <T> printHashCode(t:T){
    println(t?.hashCode()) // t 가 null 이 될 수 있음으로 안전한 호출을 써야함
    // T 의 타입은 Any? 로 추론

}
// 타입 파라미터에 대해 널이 될 수 없는 상한을 사용하기
fun <T:Any>printHAshCodeAny(t:T){ // 타입 파라미터를 Any 타입으로 설정
    println(t.hashCode())
}

/* 플랫폼 타입
    1. 코틀린이 널 관련 정보를 알 수 없는 타입
    2. 자바도 에너테이션을 통해 널 관련 정보를 알 수있음

* 자바 *
// null 가능성 에너태이션이 없는 자바 클래스
public class PersonJA {
    private final String name;
    public PersonJA(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
*/

// null 검사 업이 자바 클래스 접근하기
fun yellAt(person: PersonJA){
    println(person.name.toUpperCase() + "!!!")
}
// null 검사 통해 자바 클래스 접근하기
fun yellAtSafe(person: PersonJA){ // 호출 시점에 null 여부 검사
    println((person.name ?:"Anyone").toUpperCase() + "!!!")
}
fun callJava(){
    // yellAt(PersonJA(null)) // person.name 이 null 이지만 경고가 없음
    // NullPointerException 발생
    yellAtSafe(PersonJA(null)) // 예외 업음
}
// 코틀린 컴파일러는 함수 호출시 null 가능 파라미터에 널 검사를 자동으로 해준다
// 이 때문에 파라미터의 실행시가 아니라 함수의 호출시점에 바로 null 여부를 알 수있다

// 플랫폼 타입의 이유 :: 코틀린에서 자바의 프로퍼티에 접근시 모두 null 가능 타입으로 간주하지 않는 이유
// ArrayList<String?> 처럼 접근시마다 null 체크를 한다면 검사에 드는 비용이 너무 커지기 때문

// 플랫폼 타입은 선언 할순 없지만 출력시 보여지는 타입은 존재함 :: type!
// 자바에서 가져온 프로퍼티를 잘못대입하면 실행시점에 오류가 생겨 곤란해 질 수 있음


fun main() {

}

package koInAc
import external.ExTalk
import koInAc.hi
import java.lang.IllegalArgumentException

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

// 117p - 1/10

class Sing : Talk()
// 확장함수는 오버라이드 불가능 - Talk.hi() (x)
fun Sing.hi() = "sing hi"
fun say(){
    val t :Talk = Sing()  // 수신객체 타입 : Talk , 수신객체 : Sing
    println(t.hi()) // 수신객체 타입에 따라 호출 : Talk.hi()

}

// 확장 프로퍼티
var Talk.moveSpace : String
    get() = "move $space" // 게터세터 구현 필수
    set(v :String){
        this.space = v
    }

// 가변 인자 함수 : 인자의 개수가 달라질 수 있는 함수
fun varArg(vararg args: String){ // vararg : 가변 길이 인자
    val list = listOf("args: ",*args) // 항상 *연산자로 풀어줘야 한다,  * : 스프레드 연산자
    for(l in list)
        print("$l ")
}

// 중위 호출
// infix 수정자를 붙여야 호출 할 수 있음
infix fun Talk.to(string: String) = Pair(this,string) // Pair(1,2) : 두 인자를 쌍으로 만든다
fun inFixCall(){
    Talk().to("hi") // 일반 호출
    Talk() to "hi" // 중위 호출
}
// 구조 분해 선언
fun destructDeclaration(){
    val (number, name) = 1 to "one" // 쌍이 해체되어 각각의 인자로 들어감
    // for 문에서 list 구조 분해
    for ((index, element) in listOf("list1","list2").withIndex()) // withIndex : list 의 인덱스와 같이 반환
        println("{$index, $element}")
}

// 문자열 분리
// 결정자를 문자와 정규식으로 분리해서 받음
fun regexSplit(){
    println("12.345-6.A".split(".","-")) // "." 을 문자로 인식
    println("12.345-6.A".split("\\.|-".toRegex())) // "." 을 정규식으로 인식 - 모든글자
}

// 경로 파싱에 정규식 사용하기
fun parsePath(path:String){
    val regex = """(.+)/(.+)\.(.+)""".toRegex() // 3중 따옴표 에서는 이스케이프 문자 필요없음 "." : \\. -> \.
    // (.+)/  : 마지막 슬래시 전까지 모든문자
    // (.+)\. : 마지막 따옴표 전까지 모든문자
    // (.+)   : 나머지 모든문자
    val matchResult = regex.matchEntire(path)
    if(matchResult !=null){
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext: $extension")
    }
    // 호출 : parsePath("/dir/dir2/text.txt")
}

// 여러줄 3중 따옴표 문자열
fun tripleQuotation(){
    val kLogo = """|  // 
                  .| // 
                  .|/ \""".trimMargin(".") //  '.' 이전에 들여쓰기를 제거
    println(kLogo)

    val setDollar = """${'$'}100""" // '$' 를 사용할땐 문자열 템플릿 사용
    println(setDollar)

}

// 136p - 1/11
// 로컬함수
class User(val id: Int, val name: String, val address: String)
fun saveUser(user: User) {

    // 필드 검증코드 중복
    if (user.name.isEmpty())
        throw IllegalArgumentException("Can't save user ${user.id}: empty Name")
    if (user.address.isEmpty())
        throw IllegalArgumentException("Can't save user ${user.id}: empty Address")

    // 로컬 함수로 대체 - 중복 제거
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty())                                // 바깥함수 파라미터(user)에 직접 접근 가능
            throw IllegalArgumentException("Can't save user ${user.id}:empty $fieldName}")
    }

    validate(user.name, "Name")
    validate(user.address, "Address")

}

// 검증코드를 확장함수로 추출
fun User.validateBeforeSave(){
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty())
            throw IllegalArgumentException("Can't save user $id:empty $fieldName}")
    }

    validate(name, "Name")
    validate(address, "Address")

}
// 확잠함수로 검증
fun saveUserEx(user: User){
    user.validateBeforeSave()
    println("user ${user.id} save")
}

fun main() {


}

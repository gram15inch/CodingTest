package koInAc


// 197p - 1/26

data class Person(val name:String, val age:Int)

fun searchCollection(){
    val people = listOf(Person("Alice",29), Person("Bob",31))
// 람다를 사용해 컬렉션 검색하기
    people.maxByOrNull { it.age } // { it.age } 비교에 사용할 값을 돌려주는 함수

// 멤버 참조를 사용해 컬렉션 검색하기
    people.maxByOrNull(Person::age)
}

// 람다 : 값처럼 여기저기 전달할 수 있는 동작의 모음
fun lambda(){
              // 파라미터     // 본문
    val sum = { x:Int, y:Int -> x+y }
    sum(1,2) // 람다가 저장된 변수는 일반 함수처럼 사용 가능

    run{ println("hi") } // run : 인자로 받은 람다를 실행해 주는 라이브러리 함수
}

// 람다를 줄여쓰기
fun reduceLambda(){
    val people = listOf(Person("Alice",29), Person("Bob",31))
    people.maxByOrNull({p:Person -> p.age}) // 람다 정식
    // 문제1 : 구분자가 많아서 가독성이 떨어짐
    // 문제2 : 컴파일러가 유추할수있는 인자타입 작성
    // 문제3 : 람다 안에 인자가 하나일떄 이름 작성

    people.maxByOrNull() {p:Person -> p.age} // 함수의 유일하거나 맨 마지막 인자일 경우 : 람다를 괄호 밖으로 꺼냄
    people.maxByOrNull {p:Person -> p.age} // 함수의 유일한 인자일 경우 : 괄호 생략가능

// 이름 붙인 인자를 사용해 람다 넘기기 :: 문제1
    people.joinToString(separator = " ", transform = {p :Person -> p.name })
    people.joinToString(" ") {p :Person -> p.name } // 람다를 뒤로 뺏으나 용도가 불분명해짐

// 람다 파라미터 타입 제거 :: 문제2
    people.maxByOrNull { p:Person -> p.age }
    people.maxByOrNull { p -> p.age }

// 디폴트 파라미터 이름 it 사용
    people.maxByOrNull { it.age } // 파라미터 이름을 지정하지 않을떄 it이 자동으로 만들어짐 :: 람다 인자가 하나일때만 가능

    val getAge = {p :Person -> p.age } // 람다를 변수에 저장할 떄는 추론 불가능

    val sum = {x:Int, y:Int ->
        println("$x + $y")
        x+y // 여러줄로 이루어 진 경우 본문 제일 마지막 값이 반환
    }
}
// 함수 파라미터를 람다 안에서 사용하기
fun printMessagesWithPrefix(messages : Collection<String>, prefix: String){
    messages.forEach{ // 컬렉션 각각의 원소를 인수로 람다를 실행
        print("$prefix $it")
    }
}
// 람다 안에서 바깥 함수의 로컬 변수 변경하기
fun printProblemCounts(response: Collection<String>){
    // 호출 : printProblemCounts(listOf("404","505"))
    var clientErrors = 0
    var serverErrors = 0

    response.forEach{
        if(it.startsWith("4"))
            clientErrors++ // 로컬변수 접근 :: 파이널 제외
        else if(it.startsWith("5"))
            serverErrors++ // 람다가 포획한 변수라고 부름
    }
    print("$clientErrors $serverErrors")
}
// 변경 가능한 변수 포획하기
class  Ref<T>(var value:T)
fun refCapture(){
    val counter = Ref(0) // 자바식 포획 :: 래퍼감싸기
    val inf = {counter.value++}

    val valueVal = 0 // 포획시 변수값복사
    var valueVar = 0 // 포획시 인스턴스 참조값 복사
    val inc = {valueVar++; valueVal}

    inc() // 지역변수 변경
    println("$valueVar")

    inc()
    println("$valueVar")
}

// 포획한 변수의 생명주기별 반환값 차이 :: 210p
fun localValue() {

    var clicks = 0 // 전역변수
    fun tryToCountButtonClicks(btn: Button): Int {
        //var clicks = 0 // 지역변수
        // 이벤트 핸들러는 호출시마다 clicks 값을 증가시키지만 그값을 변경 할수없다 :: "clicks"가 지역변수 일때
        btn.onClick { clicks++; println("clicks = $clicks") } // "clicks"를 반환 한다음 호출 :: 문제1
        return clicks
    }

    val btn1 = Button()
    btn1.click()
    println("fun : ${tryToCountButtonClicks(btn1)}") // 항상 0을 리턴함
    btn1.click() // 핸들러 호출1
    btn1.click() // 핸들러 호출2

    /* 궁금한사항
        Q1. 문제1은 람다를 넘겨줄뿐 호출 하지않는데 왜 반환한다음 호출이라고 한건지
        Q2. Q1로 볼때 지역변수를 전역변수로 바꾼다고 해도 호출 하지 않음으로 같은데 언제 호출해야 달라지는지
        Q3. 만약 이후 함수 실행직후에 호출한다고 해도 함수안에서 지역변수 포획시 함수가 종료되어도 "clicks"가 살아있는데 이건 무었인지
    */
}

fun staticFun()=println("ref")
const val staticVal = "staticVal"
// 멤버 참조
fun memberReference(){
    val people = listOf(Person("Alice",29), Person("Bob",31))
    people.maxByOrNull(Person::age) // {p:Person -> p.age} 로 변환가능 :: 에타변환
    run(::staticFun) // 최상위에 선언된 함수나 프로퍼티 참조가능
    run(::staticVal) // 함수인지 프로퍼티인지와 관계없이 괄호 x
}
fun sendEmail(p:Person,m:String){}

fun runLambda(){
// 람다가 인자가 여럿인 함수에게 작업을 위임
    val action = {person:Person, message:String -> sendEmail(person,message) }
// 람다 대신 멤버참조 이용
    val nextAction = ::sendEmail
// 확장 함수도 멤버참조 가능
    fun Person.isAdult() = age >=21
    val predicate = Person::isAdult
// 일반 멤버참조
    val p = Person("Dmitri",34)
    val personAgeFun = Person::age
    personAgeFun(p) // 반드시 인스턴스 제공
// 바운드 멤버참조
    val dmitriAgeFun = p::age // 코틀린 1.1 부터 사용가능
    dmitriAgeFun() // 인스턴스가 함수안에 이미 들어가있음

}






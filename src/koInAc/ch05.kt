package koInAc

import java.io.File


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
// 1/28
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

// 컬렉션 함수형 api
// filter
fun filterCollection(){
    val people = listOf(Person("Alice",29), Person("Bob",31));
    // 람다가 true 를 반환하는 원소만 모아 새로운 컬렉션을 만듬
    // 원치않는 원소의 삭제만 가능
    val newPeople = people.filter { it.age >=30} // {} : 술어(predicate)
    println(newPeople)
}
// map
fun mapCollection(){
    val list = listOf(1,2,3,4)
    // 원소의 변환 가능
    val newList = list.map { it * it }

    val people = listOf(Person("Alice",29), Person("Bob",31))
    // 사람 리스트에서 이름 리스트로 변경
    val nameList = people.map{it.name}
    val nameList2 = people.map(Person::name) // 멤버참조로 술어대체
}

// filter, map 활용
fun filterMap(){
    val people = listOf(Person("Alice",29), Person("Bob",31))
    // 30살이상, 이름
    val ageName = people.filter { it.age>=30 }.map(Person::name)
    // 나이 최댓값, 이름                       // age 와 비교하기위해 맵번 max 값을 계산
    val maxAgeName = people.filter{it.age == people.maxByOrNull(Person::age)!!.age}
    val maxAge = people.maxByOrNull(Person::age)!!.age // max 를 한번만 계산
    val name = people.filter { it.age == maxAge }  // age 와 비교

    // map 컬렉션은 key:value 별로 따로 filter, map 을 가짐
    val numbers = mapOf(0 to "zero", 1 to "one")
    numbers.mapKeys { it.key +1 }
    numbers.mapValues { it.value.toUpperCase() }
    numbers.filterKeys { it >= 1 }
    numbers.filterValues { it.length >=4 }
}

// 217p - 1/29
fun findAge(){

    val canBeInClub27 = {p:Person -> p.age <= 27}
    val people = listOf(Person("Alice",29), Person("Bob",31))
// all
    people.all(canBeInClub27) // 모든 원소가 조건을 만족하는지 :: = !any
// any
    people.any(canBeInClub27) // 원소중 하나라도 조건을 만족하는지 :: = !all
// count
    people.count(canBeInClub27) // 조건을 만족하는 원소의 개수
    people.filter(canBeInClub27).size // 조건을 만족하는 원소들의 컬렉션을 생성 :: 비효율
// find
    people.find(canBeInClub27) //  조건을 만족하는 첫번재 원소 하나(없으면 null)
    people.firstOrNull(canBeInClub27) // null 이 나온다는 사실을 좀더 명확히 할때 쓰임

}
fun groupByAge(){
    val people = listOf(Person("Alice",29), Person("Bob",31), Person("Carol",31))
// groupBy
    val m : Map<Int, List<Person>> = people.groupBy { it.age } // 조건에 맞는 원소들모아 특성과 함께 map 형태로 집어넣음
}

fun groupByFirst(){
    val list=  listOf("a","ab","b")
    list.groupBy(String::first) // 문자열을 첫글자로 분류
}
data class Book(val name:String,val maker: List<String>)
fun flatMapFlatten(){
    val people = listOf(Person("Alice",29), Person("Bob",31), Person("Carol",31))
    val m : Map<Int, List<Person>> = people.groupBy { it.age }

    // list(1), list(2) => list(3)
    val new =m.flatMap { it.value }.toSet() // map 에서 value 만 모은다음 set 으로 만듬

    val string = listOf("abc","def")
    string.flatMap { it.toList() } // [a, b, c, d, e, f] :: 연산한 결과값을 바로 전체 리스트에 넣음
    string.map { it.toList() } // [[a, b, c], [d, e, f]] :: 연산한 결과값을 하나의 원소로 만들어서 전체 리스트에 넣음

    val books = listOf(
        Book("book1", listOf("Jasper")),
        Book("book2", listOf("Terry")),
        Book("book3", listOf("Terry","Neil"))
    )
    books.flatMap { it.maker }.toSet() // [Jasper, Terry, Neil]
    books.flatMap { it.maker } // [Jasper, Terry, Terry, Neil]
}


// 223p - 1/30
// 지연 계산(lazy) 컬렉션 연산
fun sequenceLazy(){
    val people = listOf(Person("Alice",29), Person("Bob",31), Person("Carol",31))
    people.map(Person::name).filter{it.startsWith("A")} // map, filter 단계마다 임시 컬렉션 생성 :: 비효율
// asSequence
    val m =people.asSequence() // 중간컬렉션이 생기지 않음
        .map(Person::name)
        .filter{ it.startsWith("A") }
        .toList() // sequence 는 연산과정의 나열일뿐 list 변환해야 결과값을 얻을수 있음
// lazy
    val n = listOf(1,2,3,4).asSequence() // 모든 원소에 대해 각각 map, find 연산을 한다
        .map{ it*it } // 2*2
        .find{ it>3 } // 2에서 결과가 나왔음으로 이후 연산을 하지않음
}
// map 과 filter 의 순서에 따른 비용 차이
fun mapFilterOrder(){
    val people = listOf(Person("Alice",29), Person("Bob",31), Person("Carol",31), Person("Dan",21))

    people.asSequence()
        .map(Person::name) // 조건에 상관없이 map 연산이 실행 : 비효율
        .filter { it.length>4 }
    people.asSequence()
        .filter { it.name.length>4 } // 먼저 필터를 한후 map 실행
        .map(Person::name)
}
// 자연수의 시퀀스를 생성하고 사용하기 - 228p
fun createSeq(){
    val naturalNumber = generateSequence(0){it +1}
    val numbersTo100 = naturalNumber.takeWhile { it<=100 }
    val sum = numbersTo100.sum()

    // 상위 디렉터리의 시퀀스를 생성하고 사용하기
    fun File.isInsideHiddenDirectory()= generateSequence(this){it.parentFile}.any{it.isHidden}
    val file = File("/Users/svtk/.HiddenDir/a.txt")
    file.isInsideHiddenDirectory()

    fun isInsideHiddenLocal(file: File)= generateSequence(file){it.parentFile}.any{it.isHidden}
    isInsideHiddenLocal(file)

    /* 궁금한 사항
        1. generateSequence() 는 왜 괄호뒤에 람다가 나오는지 - 해결
        2. 괄호 안에는 list 는 들어갈수 없는지
        3. list 가 들어간다면 중괄호에서 원소는 어떻게 꺼내는지
        4. 2에서 왜 첫번째 중괄호뒤에 filter 나 map 을 쓸수 없는지
     */
}

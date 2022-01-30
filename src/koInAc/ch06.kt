package koInAc

import java.io.File

// 243p

// ch05로 가야함

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
    val people = listOf(Person("Alice",29), Person("Bob",31), Person("Carol",31),Person("Dan",21))

    people.asSequence()
        .map(Person::name) // 조건에 상관없이 map 연산이 실행 : 비효율
        .filter { it.length>4 }
    people.asSequence()
        .filter { it.name.length>4 } // 먼저 필터를 한후 참일때만 map 실행
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

    fun isInsideHiddenLocal(file:File)= generateSequence(file){it.parentFile}.any{it.isHidden}
    isInsideHiddenLocal(file)

    /* 궁금한 사항
        1. generateSequence() 는 왜 괄호뒤에 람다가 나오는지
        2. 괄호 안에는 list 는 들어갈수 없는지
        3. list 가 들어간다면     
     */
}

fun main() {
    mapFilterOrder()
}
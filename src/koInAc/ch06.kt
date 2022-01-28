package koInAc

// 243p

// ch05로 가야함
// 컬렉션 함수형 api
// filter
fun filterCollection(){
    val people = listOf(Person("Alice",29), Person("Bob",31))
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
    numbers.mapValues { it.value.toUpperCase() }
    numbers.filterValues { it.length >=4 }
    numbers.mapKeys { it.key +1 }
    numbers.filterKeys { it >= 1 }
}

fun main() {

}
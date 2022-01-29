package koInAc

// 243p

// ch05로 가야함
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
    people.find(canBeInClub27) //  조건을 만족하는 원소 하나(없으면 null)
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

fun flatMapFlatten(){
    val people = listOf(Person("Alice",29), Person("Bob",31), Person("Carol",31))
    val m : Map<Int, List<Person>> = people.groupBy { it.age }

    // list(1), list(2) => list(3)
    val new =m.flatMap { it.value }.toSet() // map 에서 value 만 모은다음 set 으로 만듬

    val string = listOf("abc","def")
    string.flatMap { it.toList() } // [a, b, c, d, e, f] :: 연산한 결과값이 다시 새원소
    string.map { it.toList() } // [[a, b, c], [d, e, f]] :: 하나의 원소 안에서 어떠한 연산을 해도 하나의 원소

}
fun main() {
    flatMapFlatten()
}
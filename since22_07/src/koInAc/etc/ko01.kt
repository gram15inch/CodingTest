package koInAc.etc

import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

/*
Kotlin 컬렉션에는 컬랙션 내의 데이터를 모두 모으는(accumulate) 함수인 reduce()와 fold()가 있다.
둘의 차이는 accumulation 작업을 할 때 reduce()는 초기값이 없이 첫번째 요소(element)로 시작하고,
 fold()는 지정해 준 초기값으로 시작한다.
 Java 의 stream 에서는 둘 다 reduce()이다.
*/
// reduce 와 Fold
fun reduceFold(){
    val numbers = listOf(7, 4, 8, 1, 9)

    val sum = numbers.reduce { total, num -> total + num }
    println("reduced: $sum") // reduced: 29
    val sumFromTen = numbers.fold(10) { total, num -> total + num }
    println("folded: $sumFromTen") // folded: 39
}

fun useBigDecimal(){

    val a: BigDecimal = BigDecimal(10)
    val b: BigDecimal = BigDecimal(3)
    val c: BigDecimal = 3.0.toBigDecimal()

// equalsTo()와 동일하게 소수점 마지막의 0까지 비교
// false
    println(b == c)

// compareTo()는 소수점 마지막의 0을 무시
// true
    println(b.compareTo(c) == 0)

// 이 경우 == 기호는 equalsTo()가 아닌 compareTo()로 작동
// true
    println(b <= c)

// 이 경우 == 기호는 equalsTo()가 아닌 compareTo()로 작동
// true
    println(b >= c)

// add()와 동일
// 13.0
    println(a + b)

// subtract()와 동일
// 7.0
    println(a - b)

// multiply()와 동일
// 30.00
    println(a * b)

// divide(other, RoundingMode.HALF_EVEN)와 동일
// 3.3
    println(a / b)

// 34자리 정밀도로 나누기 처리
// 3.333333333333333333333333333333333
    println(a.divide(b, MathContext.DECIMAL128))

    // 연산자 오버로드 선언
// 프로젝트 내에서 동일 연산자 메써드에 대해 1번만 선언 가능
    operator fun BigDecimal.div(other: BigDecimal): BigDecimal = this.divide(other, 6, RoundingMode.HALF_EVEN)

// 연산자 오버로드 선언 후 결과 확인
// 3.333333
    println(a / b)
}
package baekjoon

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.lang.StringBuilder

internal class Step08KtTest {

    @Test
    fun test1() {

        val a = "9999999999999999999999999999999999"
        val b = StringBuilder()


        for(n in 1..10000){
            b.append(9)
            assertEquals(ex0807(a,b.toString()),step0807(a,b.toString()),"num :${n}")
        }

    }


}

fun ex0807(a:String, b:String) = "$a $b"
    .split(" ")
    .map { it.toBigDecimal() }
    .reduce { acc, i -> acc + i }


fun ex0806(input : Int):Int{
    var bag = input / 5
    while ((input - bag * 5) % 3 > 0 && bag >= 0) {
        --bag
    }
    return if (bag < 0) -1 else (input - bag * 5) / 3 + bag
}

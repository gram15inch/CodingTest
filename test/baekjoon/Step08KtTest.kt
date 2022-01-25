package baekjoon

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Step08KtTest {

    @Test
    fun test1() {

    }


}

fun ex0806(input : Int):Int{
    var bag = input / 5
    while ((input - bag * 5) % 3 > 0 && bag >= 0) {
        --bag
    }
    return if (bag < 0) -1 else (input - bag * 5) / 3 + bag
}

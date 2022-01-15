package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {

}
// 한수
fun step063(){

}

// 셀프 넘버 - 4673
fun step0602(){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val constructors = mutableListOf<Int>()
    for(num in 1 until 10000)
        constructors.add(num)

    fun self(n:Int){
        var sum =n
        if(n>10000)
            return
        var digits = n
        while(digits>0){
            sum += digits%10
            digits /=10
        }
        if(!constructors.remove(sum))
            return

        self(sum)

    }
    for ( c in 1 until 10000)
        self(c)

    val strBuilder = StringBuilder()


    for(c in constructors)
        strBuilder.append("$c\n")

    bw.write("$strBuilder")


    bw.flush()
    bw.close()
}
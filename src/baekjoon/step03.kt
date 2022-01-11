package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val a =token.nextToken().toInt()

    val strBuilder = StringBuilder()
    for(num in  1..9)
        strBuilder.append("$a * $num = ${a*num}\n")


    bw.write("$strBuilder")

    bw.flush()
    bw.close()
}

// 구구단 - 2739
fun step0301(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val a =token.nextToken().toInt()

    val strBuilder = StringBuilder()
    for(num in  1..9)
        strBuilder.append("$a * $num = ${a*num}\n")


    bw.write("$strBuilder")

    bw.flush()
    bw.close()

}
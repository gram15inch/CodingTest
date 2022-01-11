package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.IllegalArgumentException
import java.util.*

fun main() {


}

// 알람 시계 - 2884
fun step0205(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val a =token.nextToken().toInt()
    val b =token.nextToken().toInt()
    val sum = ((a*60)+b) - 45
    val eq = when {
        (sum>=0) -> sum
        (sum<0) -> 1440 + sum
        else -> 0
    }
    bw.write("${eq/60} ${eq%60}\n")

    bw.flush()
    bw.close()
}

// 사분면 고르기 - 14681
fun step0204(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val a =token.nextToken().toInt()
    val token2 = StringTokenizer(br.readLine())
    val b =token2.nextToken().toInt()
    val eq = when {
        (a>0) && (b>0) -> 1
        (a<0) && (b>0) -> 2
        (a>0) && (b<0) -> 3
        (a<0) && (b<0) -> 4
        else -> 0

    }
    bw.write("$eq\n")

    bw.flush()
    bw.close()
}

// 윤년 2753
fun step0203(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val a =token.nextToken().toInt()
    val eq = when {
        (a%4 == 0 && a%100 != 0) || (a%400 == 0) -> 1
        else -> 0

    }
    bw.write("$eq\n")

    bw.flush()
    bw.close()

}

// 시험성적 - 9498
fun step0202(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val a =token.nextToken().toInt()
    val eq = when {
        (a >= 90) -> 'A'
        (a >= 80) -> 'B'
        (a >= 70) -> 'C'
        (a >= 60) -> 'D'
        else -> 'F'

    }
    bw.write("$eq\n")

    bw.flush()
    bw.close()
}

// 두수 비교하기 - 1330
fun step0201(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val a =token.nextToken().toInt()
    val b =token.nextToken().toInt()
    val eq = when {
        (a > b) -> '>'
        (a < b) -> '<'
        else -> "=="

    }
    bw.write("$eq\n")

    bw.flush()
    bw.close()
}
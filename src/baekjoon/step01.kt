package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*



fun main() {

}

// 곱셈
fun step0111(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val A =token.nextToken().toInt()
    val token2 = StringTokenizer(br.readLine())
    val B =token2.nextToken().toInt()
    val digit1 = B%10 * A
    val digit10 = (B/10)%10 * A
    val digit100 = (B/100) * A
    val sum = A*B
    bw.write("$digit1\n$digit10\n$digit100\n$sum\n")

    bw.flush()
    bw.close()
}

// 나머지
fun step0110(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val A =token.nextToken().toInt()
    val B =token.nextToken().toInt()
    val C =token.nextToken().toInt()
//  (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C
    val sum1 = (A+B)%C
    val sum2 = ((A%C) + (B%C))%C
    val sum3 = (A*B)%C
    val sum4 = ((A%C) * (B%C))%C

    bw.write("$sum1\n$sum2\n$sum3\n$sum4\n")

    bw.flush()
    bw.close()
}
// 사칙연산
fun step0109(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val a =token.nextToken().toInt()
    val b =token.nextToken().toInt()
    val c =token.nextToken().toInt()

    val sum1 = a + b
    val sum2 = a - b
    val sum3 = a * b
    val sum4 = a / b
    val sum5 = a % b
    bw.write("$sum1\n$sum2\n$sum3\n$sum4\n$sum5\n")

    bw.flush()
    bw.close()
}

// A/B
fun step0108(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val sum = token.nextToken().toDouble() / token.nextToken().toDouble()
    bw.write("$sum\n")

    bw.flush()
    bw.close()

}


// A*B
fun step01007(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val sum = (token.nextToken().toInt() * token.nextToken().toInt()).toString()
    bw.write(sum + "\n")

    bw.flush()
    bw.close()

}






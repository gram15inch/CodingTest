package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {

}



// X보다 작은 수 - 10871
fun step0311(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val size =token.nextToken().toInt()
    val num =token.nextToken().toInt()

    val strBuilder = StringBuilder()
    val token2 = StringTokenizer(br.readLine())
    var a :Int
    for(c in  1..size)
    {
        a = token2.nextToken().toInt()
        when{
            (a<num) -> strBuilder.append("$a ")
        }
    }


    bw.write("$strBuilder")

    bw.flush()
    bw.close()

}



// 별 찍기 - 2 - 2439
fun step0310(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val size =token.nextToken().toInt()


    val strBuilder = StringBuilder()

    for(num in  1..size)
    {
        for(space in 1 .. size-num)
            strBuilder.append(" ")
        for(star in 1..num)
            strBuilder.append("*")
        strBuilder.append("\n")
    }

    bw.write("$strBuilder")

    bw.flush()
    bw.close()

}



// 별 찍기 - 1 - 2438
fun step0309(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val size =token.nextToken().toInt()


    val strBuilder = StringBuilder()
    var a :Int
    var b :Int

    for(num in  1..size)
    {
        for(star in 1..num)
            strBuilder.append("*")
        strBuilder.append("\n")
    }

    bw.write("$strBuilder")

    bw.flush()
    bw.close()

}



// A+B - 8 - 11022
fun step0308(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val size =token.nextToken().toInt()


    val strBuilder = StringBuilder()
    var a = 0
    var b = 0
    for(num in  1..size)
    {

        val token2 = StringTokenizer(br.readLine())
        a = token2.nextToken().toInt()
        b = token2.nextToken().toInt()
        strBuilder.append("Case #$num:" +
                " $a + $b =" +
                " ${a+b}\n")


    }


    bw.write("$strBuilder")

    bw.flush()
    bw.close()

}



// A+B - 7 - 11021
fun step0307(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val size =token.nextToken().toInt()


    val strBuilder = StringBuilder()
    for(num in  1..size)
    {
        val token2 = StringTokenizer(br.readLine())
        strBuilder.append("Case #$num: ${token2.nextToken().toInt()+token2.nextToken().toInt()}\n")
    }


    bw.write("$strBuilder")

    bw.flush()
    bw.close()

}



// 기찍 N - 2742
fun step0306(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val size =token.nextToken().toInt()


    val strBuilder = StringBuilder()
    for(num in  size downTo 1 )
    {
        strBuilder.append("$num\n")
    }


    bw.write("$strBuilder")

    bw.flush()
    bw.close()

}




// N 찍기 - 2741
fun step0305(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val size =token.nextToken().toInt()


    val strBuilder = StringBuilder()
    for(num in  1..size)
    {
        strBuilder.append("$num\n")
    }


    bw.write("$strBuilder")

    bw.flush()
    bw.close()

}

// 빠른 A+B - 15552
fun step0304(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val size =token.nextToken().toInt()


    val strBuilder = StringBuilder()
    for(num in  1..size)
    {
        val token2 = StringTokenizer(br.readLine())
        strBuilder.append("${token2.nextToken().toInt()+token2.nextToken().toInt()}\n")
    }


    bw.write("$strBuilder")

    bw.flush()
    bw.close()

}

// 합 - 8393
fun step0303(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val size =token.nextToken().toInt()


    val strBuilder = StringBuilder()
    var sum =0
    for(num in  1..size)
    {
        sum += num
    }


    bw.write("$sum")

    bw.flush()
    bw.close()

}

// A+B - 3 - 10950
fun step0302(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val size =token.nextToken().toInt()


    val strBuilder = StringBuilder()
    for(num in  1..size)
    {
        val token2 = StringTokenizer(br.readLine())
        strBuilder.append("${token2.nextToken().toInt()+token2.nextToken().toInt()}\n")
    }


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
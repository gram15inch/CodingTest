package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val a :Int
    val b :Int
    val c :Int

    var token = StringTokenizer(br.readLine())
    //var token = StringTokenizer("3 2 1")

    a = token.nextToken().toInt()
    b = token.nextToken().toInt()
    c = token.nextToken().toInt()


    if(b>=c){
        bw.write("-1")
    }
    else
        bw.write("${a /(c  -  b) +1}")

    bw.flush()
    bw.close()
    br.close()
}

// 벌집 - 2292
fun step0802(){

}
// 손익 분기점 - 1712
fun step0801(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val a :Int
    val b :Int
    val c :Int

    var token = StringTokenizer(br.readLine())
    //var token = StringTokenizer("3 2 1")

    a = token.nextToken().toInt()
    b = token.nextToken().toInt()
    c = token.nextToken().toInt()

    if(b>=c){
        bw.write("-1")
    }
    else
        bw.write("${a /(c  -  b) +1}")

    bw.flush()
    bw.close()
    br.close()
}
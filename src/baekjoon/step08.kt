package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Math.pow
import java.util.*
import kotlin.math.log10
import kotlin.math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))


    val size = br.readLine().toInt()


    var token : StringTokenizer
    var h :Int
    var w :Int
    var num :Int
    var n :Double
    var isInt :Boolean

    for(time in 1.. size) {
        token = StringTokenizer(br.readLine())
        h = token.nextToken().toInt()
        w = token.nextToken().toInt()
        num = token.nextToken().toInt()
        n=log10(num.toDouble())/log10(h.toDouble())
        isInt = log10(num.toDouble())%log10(h.toDouble()) == (0).toDouble()
        if(isInt)
            bw.write("${num%h}%02d\n".format(n.toInt()))
        else
            bw.write("${num%h}%02d\n".format(n.toInt())+1)


    }
    bw.flush()



    bw.close()
    br.close()
}

// 달팽이는 올라가고 싶다 - 2869
fun step0804() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    //val token = StringTokenizer("2 1 5") // 3 / 1 = 3
    //val token = StringTokenizer("5 1 11") // 6 / 4  = 0.25
    //val token = StringTokenizer("100 99 1000000000")


    val a = token.nextToken().toInt()
    val b = token.nextToken().toInt()
    val v = token.nextToken().toInt()

    if(a>=v){
        bw.write("1")
    }
    else if((v-a)%(a-b)==0)
        bw.write("${(v-a)/(a-b)+1}")
    else
        bw.write("${(v-a)/(a-b)+2}")


    bw.flush()
    bw.close()
    br.close()


}

// 분수찾기 - 1193
fun step0803(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var n =0
    val num = br.readLine().toInt()
    var an = 0
    while(an < num) {
        n++
        an = ((n-1)*(n+2)+2)/2
    }

    val anRP:Int = an - num  //anRelativePosition

    when{
        (n%2 == 0)->bw.write("${(n-anRP)}/${1+anRP}")
        (n%2 == 1)->bw.write("${1+anRP}/${(n-anRP)}")
    }


    bw.flush()
    bw.close()
    br.close()
}

// 벌집 - 2292
fun step0802(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var n =0
    val num = br.readLine().toInt()
    var an = 0

    while(an < num) {
        n++
        an = 3*n*(n-1)+1
    }

    bw.write("$n")

    bw.flush()
    bw.close()
    br.close()
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
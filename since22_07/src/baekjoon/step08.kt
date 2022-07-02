package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.*


fun main() {

}



// 큰수 A+B 10757
fun step0807(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))


    val token = StringTokenizer(br.readLine())

    bw.write("${token.nextToken().toBigDecimal().add(token.nextToken().toString().toBigDecimal())}")

    bw.flush()
    bw.close()
    br.close()
}


// 부녀회장이 될테야 - 2775
fun step0806() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val kg = br.readLine().toInt()
    //val kg = 6


    var ea =   if(kg < 15) kg/5 else ((kg / 15) * 15) / 5
    var remain =  if(kg < 15) kg%5 else kg % 15
    var isValue = true

    when {
        (remain % 3 == 0) -> ea += remain / 3
        (remain % 5 == 0) -> ea += remain / 5
        else -> {
            var x = remain / 3 + 1 // 3
            var y = 0 // 5
            var maxX = x

            while (true) {
                when {
                    (maxX == 0) -> {
                        if(ea==0){
                            isValue = false
                            break
                        }

                        ea--
                        remain +=5
                        x = remain / 3 +1
                        y=0
                        maxX = x
                    }

                    (x * 3 + y * 5 > remain) || (x == 0) -> {
                        maxX--
                        x = maxX
                        y = 0
                    }
                    (x * 3 + y * 5 == remain) -> {
                        ea += x + y
                        break
                    }
                    else -> {
                        x--
                        y++
                    }
                }
            }

        }
    }

    if (isValue)
        bw.write("$ea\n")
    else
        bw.write("-1\n")

    bw.flush()
    bw.close()
    br.close()


}
// ACM 호텔 - 10250
fun step0805() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))


    val size = br.readLine().toInt()


    var token : StringTokenizer
    var h :Int
    var w :Int
    var num :Int
    var n =0
    for(time in 1.. size) {
        token = StringTokenizer(br.readLine())
        h = token.nextToken().toInt()
        w = token.nextToken().toInt()
        num = token.nextToken().toInt()

        n = (num+h-1)/h
        bw.write("${if(num%h==0) h else num%h }%02d\n".format(n))
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
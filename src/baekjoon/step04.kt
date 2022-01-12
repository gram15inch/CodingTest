package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))


    while (true) {
        val token = StringTokenizer(br.readLine())
        var num = token.nextToken().toInt()
        var sum = 100
        var sum2 = num
        var count = 0
        while(true){
            when{
                (num<10 && sum2 != 0) -> num *= 10
                (sum==num)-> {
                    break }
                else -> {
                    val left = sum2 /10
                    val right = sum2 %10
                    sum = left + right
                    sum = right*10 + sum%10
                    sum2 =sum
                    count++
                }
            }
        }
        println("$count")

    }

}



// A+B - 4 - 1110
fun step0403() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val strBuilder = StringBuilder()

    while (true) {
        val line = br.readLine()
        if(line == null) {
            break
        }else {
            val token = StringTokenizer(line)
            var num = token.nextToken().toInt()
            var sum = 100
            while(true){
                when{
                    (num>10) -> num *= 10
                    (sum==num)-> break
                    else -> {
                        val left = num /10
                        val right = num %10
                        sum = left + right
                        sum = right*10 + sum%10
                        print(sum)
                    }
                }

            }

        }
    }
    br.close()


}
// A+B - 4 - 10951
fun step0402(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val strBuilder = StringBuilder()

    while (true) {
        val line = br.readLine()
        if(line == null) {
            break
        }else {
            val token = StringTokenizer(line)
            val a = token.nextToken().toInt()
            val b = token.nextToken().toInt()
            println("${a + b}")
        }
    }
    br.close()
}

// A+B - 5 - 10952
fun step0401(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var token = StringTokenizer(br.readLine())
    var a =token.nextToken().toInt()
    var b =token.nextToken().toInt()

    val strBuilder = StringBuilder()


    while(!(a==0 && b==0)){
        strBuilder.append("${a + b}\n")
        token = StringTokenizer(br.readLine())
        a =token.nextToken().toInt()
        b =token.nextToken().toInt()
    }

    bw.write("$strBuilder")

    bw.flush()
    bw.close()
}
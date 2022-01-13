package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {

}

// 평균 - 1546
fun step0504() {

}
// 나머지 - 3052
fun step0504() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val digits = arrayOf(0,0,0,0,0,0,0,0,0,0)
    val diffRest = arrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)

    var diffRestCount = 0

    for(idx in 0..9)
        digits[idx] = br.readLine().toInt()%42

    var isRestCount = false
    for ((digitA) in digits.withIndex())
        for ((digitB) in digits.withIndex())
            when{
                (digitA==digitB)->{
                    if(diffRestCount==0) {
                        diffRest[0] = digitB
                        diffRestCount++
                    }else {
                        isRestCount = false
                        for (drIdx in 0 until diffRestCount) {
                            if (diffRest[drIdx] == digitB){
                                isRestCount = true
                                break
                            }
                        }
                        if(!isRestCount){
                            diffRest[diffRestCount] = digitB
                            diffRestCount++
                        }

                    }

                }
            }

    var sum =0
    for(c in diffRest)
        if(c>=0)
            sum++
    bw.write("$sum\n")

    bw.flush()
    bw.close()
    br.close()
}

// 숫자의 개수 - 2577
fun step0503(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))


    var sum = 1
    for(idx in 1 ..3)
        sum *= br.readLine().toInt()
    var sumStr = sum.toString()
    var count = arrayOf(0,0,0,0,0,0,0,0,0,0)

    for (size in sumStr)
        for(idx in '0'..'9')
            if (size ==idx)
                count[(idx-48).toInt()] +=1

    for(c in count)
        bw.write("$c\n")



    bw.flush()
    bw.close()
    br.close()
}

// 최댓값 - 2562
fun step0502(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))


    var line = br.readLine().toInt()
    var big =line
    var order =1

    for(idx in 2 until  10) {
        line = br.readLine().toInt()
        when {
            (line > big) -> {
                big = line
                order = idx
            }
        }
    }

    bw.write("$big\n$order\n")

    bw.flush()
    bw.close()
    br.close()
}

// 최소, 최대 - 10818
fun step0501(){


    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val size = br.readLine().toInt()

    var token = StringTokenizer(br.readLine())

    var big = token.nextToken().toInt()
    var small = big
    for(c in 1 until size){
        val num = token.nextToken().toInt()
        when {
            (num>big)-> big = num
            (num<small)-> small = num
        }
    }

    bw.write("$small $big")

    bw.flush()
    bw.close()
    br.close()
}
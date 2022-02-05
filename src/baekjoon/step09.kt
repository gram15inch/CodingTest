package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun step0901(){

    fun getPrimeNumber(i:Int):Boolean{
        if(i==1)
            return false
        var divCount = 0
        for(n in 1 ..i){
            if(i%n==0)
                if(++divCount>2)
                    return false
        }
        return true
    }

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var sum = 0
    br.readLine().toInt().run{
        val token = StringTokenizer(br.readLine())

        repeat(this){
            token.nextToken().toInt().run {
                if(getPrimeNumber(this)) sum++
            }
        }

    }


    bw.write("$sum")
    bw.flush()
    bw.close()
    br.close()


}


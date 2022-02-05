package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var sum = 0
    val primes :MutableCollection<Int> = arrayListOf(0)
    br.readLine().toInt().run{
        for(n in this.. br.readLine().toInt()){
            if(getPrimeNumber(n))
                primes.add(n)
        }
    }

    primes.filter { it>0 }.run {
        if(this.isEmpty())
            bw.write("-1")
        else
        bw.write("${this.sum()}\n${this.minByOrNull { it }}") }


    bw.flush()
    bw.close()
    br.close()

}


inline fun getPrimeNumber(i:Int):Boolean{
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

// 소수 - 2581
fun step0902(a :Int,b:Int):Pair<Int,Int>{

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

    val primes :MutableCollection<Int> = arrayListOf(0)
    a.run{
        for(n in this.. b){
            if(getPrimeNumber(n))
                primes.add(n)
        }
    }


    primes.filter { it>0 }.run {  return Pair(this.sum(),this.minByOrNull { it }!!)  }

}

// 소수찾기 - 1978
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


package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val token = StringTokenizer(br.readLine())
    token.nextToken().toInt().run{
        for(n in this.. token.nextToken().toInt()){
            if(getPrimeNumber(n))
                bw.write("$n\n")
        }
    }

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



// 소인2 - 2581 - s2
fun step0904(){}

// 소인수분해 - 11653
fun step0903(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var sum = 0
    br.readLine().toInt().run{
        sum = this
        while(true) {
            if (1 == sum) {
                bw.flush()
                bw.close()
                br.close()
                break
            }
            for (n in 2..this) {
                if (sum % n == 0) {
                    bw.write("${n}\n")
                    sum /= n
                    break
                }
            }
        }
    }
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


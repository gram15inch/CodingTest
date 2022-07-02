
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


fun main() {


}

fun run1978(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine()
    val nums = br.readLine()

    val result = ex1978(size,nums)

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    bw.write("$result")
    bw.flush()
    bw.close()
}

fun ex1978(s:String,n:String):Int{
    val token = StringTokenizer(n)
    var sum = 0
    repeat(s.toInt()){
        token.nextToken().toInt().run {
            if(getPrimeNumber(this)) sum++
        }
    }
    return sum
}

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

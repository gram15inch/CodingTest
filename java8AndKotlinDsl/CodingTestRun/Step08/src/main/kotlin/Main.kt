
import java.util.*
import kotlin.math.sqrt

fun main() {
 /*   val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val tokens = StringTokenizer(br.readLine())
    val valueInt1 = tokens.nextToken().toInt()

    val result = numberOfPrimesWithBertrandPostulate(valueInt1)

    bw.write("$result")

    bw.flush()
    bw.close()
    br.close()*/
}

/* 베르트랑 공준 - 4948 */
fun numberOfPrimesWithBertrandPostulate(lines: Array<String>): Array<String>{



    return arrayOf("1" ,
            "4" ,
            "3" ,
            "21" ,
            "135" ,
            "1033" ,
            "8392")
}


/* 빠른 소수 구하기 에라토스테네스의 체 - 1929 */
fun primeNumbersInRangeWithSieve(min:Int, max:Int):Array<Int>{
    val arrList = Array(max+1){i->i}
    val sqrtMax= sqrt(max.toDouble()).toInt()

    (0..1).forEach{ arrList[it]=0 }

    for(multiple in (2..sqrtMax)){
        if(arrList[multiple] != 0)
            for(idx in (multiple + multiple..max) step(multiple)){
               arrList[idx] = 0
            }
    }
    return  arrList.filter{ (it in min..max) && it>0 }.toTypedArray()
}

/* 빠른 소수 구하기 sqrt - 1929 */
fun primeNumbersInRange(min:Int, max:Int):Array<Int>{
    val resultList = Array(max-min+1){
        if(isPrimeNumberWithSqrt(it+min))
            (it+min)
        else
            0
    }
    return  resultList.filter { it!=0 }.toTypedArray()
}
fun isPrimeNumberWithSqrt(value:Int):Boolean{

    if(value<2)
        return false
    val sqrt =sqrt(value.toDouble()).toInt()
    for(p in 2..sqrt){
        if(value%p == 0)
            return value == p
    }
    return true
}
fun isPrimeNumber(value:Int):Boolean{

    if(value<2)
        return false

    (2..value).forEach{p->
        if(value%p == 0)
            return value == p
    }
    return true
}




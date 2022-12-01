
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.sqrt

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val tokens = StringTokenizer(br.readLine())
    val valueInt1 = tokens.nextToken().toInt()
    val valueInt2 = tokens.nextToken().toInt()


    val result = primeNumbersInRange(valueInt1,valueInt2)

    for (it in result){
        bw.write("${it}\n")
    }
   /* result.forEach{
        bw.write("${it}\n")
    }*/

    bw.flush()
    bw.close()
    br.close()


}

/* 빠른 소수 구하기 에라토스테네스의 체 - 1929 */
fun primeNumbersInRangeWithFilteredList(min:Int, max:Int):List<String>{
   // val intList = mutableListOf<Int>()
    var areList = mutableListOf<Int>()
   // var areList :List<Int> = (2..max).toList()

    for(n in 2..max)
        areList.add(n)

    //var multiple = 2
    var multiple = 2
    val sqrtMax= sqrt(max.toDouble()).toInt()
    do{
        areList.filterNot { ( (it!=multiple) && (it%multiple)==0) }
            .also {filteredList->
                areList = filteredList as ArrayList<Int>
                //multiple++
                multiple = filteredList.first { multiple < it }
            }
    }
    while(multiple < sqrtMax)
    return  areList.filter{ (it in min..max) }
        .map{it.toString()}
}
fun primeNumbersInRangeWithFilteredList2(min:Int, max:Int):List<String>{

    val arrList = IntArray(1000003)

    for(n in 0..max)
        arrList[n] = n

    var multiple = 2
    val sqrtMax= sqrt(max.toDouble()).toInt()


    var i =2
    var j = i + i
    while(i<=max){
        if(arrList[i]==0) continue
        while(j<=max){
            j+=i
            arrList[j]=0
        }
    }
    return  arrList.filter{ (it in min..max) }
        .map{it.toString()}
}


/* 빠른 소수 구하기 sqrt - 1929 */
fun primeNumbersInRange(min:Int, max:Int):ArrayList<String>{
    val resultList = arrayListOf<String>()
    (min..max).forEach{n->
        if(isPrimeNumberWithSqrt(n))
            resultList.add(n.toString())
    }
    return resultList
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


// --
fun isPrimeNumber(value:Int):Boolean{

    if(value<2)
        return false

    (2..value).forEach{p->
        if(value%p == 0)
            return value == p
    }
    return true
}




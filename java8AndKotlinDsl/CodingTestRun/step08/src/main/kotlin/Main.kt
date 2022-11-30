
import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val tokens = StringTokenizer(br.readLine())
    val valueInt1 = tokens.nextToken().toInt()
    val valueInt2 = tokens.nextToken().toInt()


    val result = primeNumberInRange(valueInt1,valueInt2)

    result.forEach{
        bw.write("${it}\n")
    }

    bw.flush()
    bw.close()
    br.close()
}


fun primeNumberInRange(min:Int,max:Int):List<String>{
    val resultList = mutableListOf<String>()
    (min..max).forEach { n->
        if(primeNumber(n))
            resultList.add(n.toString())
    }
    return resultList
    val a =1
}

fun primeNumber(value:Int):Boolean{

    if(value<2)
        return false

    (2..value).forEach{p->
        if(value%p == 0)
            return value == p
    }
    return true
}



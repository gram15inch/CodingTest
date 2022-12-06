import kotlin.math.sqrt

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val arrInPut = mutableListOf<Int>()

    var valueInt: Int
    do {
        valueInt = br.readLine().toInt()
        arrInPut.add(valueInt)
    } while (valueInt != 0)
    arrInPut.removeAt(arrInPut.size-1)
    val result = numberOfPrimesWithBertrandPostulate(arrInPut.toTypedArray())

    for (r in result)
        bw.write("$r\n")

    bw.flush()
    bw.close()
    br.close()
}


//todo 
/* n-2n 소수갯수 구하기 베르트랑 공준 - 4948 */
fun numberOfPrimesWithBertrandPostulate(lines: Array<Int>): Array<Int> {
    val resultAll = primeNumbersInRangeWithSieve(lines.min(), lines.max()*2)
    return Array(lines.size) { line ->
        resultAll
            .filter { lines[line] < it && it <= lines[line] * 2 }
            .size
    }
}

fun Array<Int>.min():Int{
    var min = this[0]
    for(n in this)
        if(min>n)
            min = n
        return min
}
fun Array<Int>.max():Int{
    var max = this[0]
    for(n in this)
        if(max<n)
            max = n
        return max
}

/* 빠른 소수 구하기 에라토스테네스의 체 - 1929 */
fun primeNumbersInRangeWithSieve(min: Int, max: Int): Array<Int> {
    val arrList = Array(max + 1) { i -> i }
    val sqrtMax = sqrt(max.toDouble()).toInt()

    (0..1).forEach { arrList[it] = 0 }

    for (multiple in (2..sqrtMax)) {
        if (arrList[multiple] != 0)
            for (idx in (multiple + multiple..max) step (multiple)) {
                arrList[idx] = 0
            }
    }
    return arrList.filter { (it in min..max) && it > 0 }.toTypedArray()
}

/* 빠른 소수 구하기 sqrt - 1929 */
@Suppress("unused")
fun primeNumbersInRange(min: Int, max: Int): Array<Int> {
    val resultList = Array(max - min + 1) {
        if (isPrimeNumberWithSqrt(it + min))
            (it + min)
        else
            0
    }
    return resultList.filter { it != 0 }.toTypedArray()
}

fun isPrimeNumberWithSqrt(value: Int): Boolean {

    if (value < 2)
        return false
    val sqrt = sqrt(value.toDouble()).toInt()
    for (p in 2..sqrt) {
        if (value % p == 0)
            return value == p
    }
    return true
}

fun isPrimeNumber(value: Int): Boolean {

    if (value < 2)
        return false

    (2..value).forEach { p ->
        if (value % p == 0)
            return value == p
    }
    return true
}




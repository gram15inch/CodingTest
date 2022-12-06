import java.util.*





@Suppress("unused")
fun runNumberOfPrimesWithBertrandPostulate(){
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

@Suppress("unused")
fun runPrimeNumbersInRangeWithSieve(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val tokens = StringTokenizer(br.readLine())
    val valueInt1 = tokens.nextToken().toInt()
    val valueInt2 = tokens.nextToken().toInt()

    val result = primeNumbersInRangeWithSieve(valueInt1,valueInt2)

    for (it in result)
        bw.write("${it}\n")

    bw.flush()
    bw.close()
    br.close()
}
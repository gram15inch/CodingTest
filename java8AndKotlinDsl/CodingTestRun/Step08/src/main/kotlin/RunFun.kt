import java.util.*


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
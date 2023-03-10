fun main() {

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()


    val times = br.readLine().toInt()
    var min = 10001
    var max = -1
    val arr = IntArray(times) {
        br.readLine().toInt().run {
            if (this > max)
                max = this
            if (this < min)
                min = this
            this
        }
    }

    for (i in countingSort(arr, max))
        bw.write("$i\n")

    bw.flush()
    br.close()
    bw.close()
}

/* 10989 */

fun countingSort(arr: IntArray, max: Int): IntArray {
    val countArr = IntArray(max+1)

    for (i in arr)
        countArr[i]++

    for(i in 1..max)
        countArr[i] += countArr[i - 1]

    val rsArr = IntArray(arr.size)

    for (a in arr) {
        (countArr[a] - 1).let{
            if(it>=0) {
                rsArr[it] = a
                countArr[a]--
            }
        }
    }

    return rsArr
}

fun main() {

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()


    val times = br.readLine().toInt()
    var min = 10001
    var max = -1
    val arr = Array(times) {
        br.readLine().toInt().run {
            if (this > max)
                max = it
            if (this < min)
                min = it
            this.toShort()
        }
    }

    for (i in countingSort(arr, max))
        bw.write("$i\n")

    bw.flush()
    br.close()
    bw.close()
}

/* 10989 */

fun countingSort(arr: Array<Short>, max: Int): Array<Short> {
    val countArr = Array<Short>(max+1) { 0 }

    for (i in arr) {
        countArr[i.toInt()]++
    }
    repeat(countArr.size) {
        if (it != 0)
            countArr[it] = (countArr[it - 1] + countArr[it]).toShort()
    }
    val rsArr = Array<Short>(arr.size) { 0 }

    for (a in arr) {
        (countArr[a.toInt()]--).let{
            if(it>0)
                rsArr[it-1]=a
        }
    }

    return rsArr
}

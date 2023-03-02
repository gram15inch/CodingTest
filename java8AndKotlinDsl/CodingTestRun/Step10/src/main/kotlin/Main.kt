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
            this
        }
    }



    for (i in kotlinSort(arr))
        bw.write("$i\n")

    bw.flush()
    br.close()
    bw.close()
}

/* 10989 */

fun countingSort(arr: Array<Int>,min:Int,max:Int): Array<Int> {

    val countArr = Array(max-min+1){0}
    return arr
}

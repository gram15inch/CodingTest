fun main() {

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val times = br.readLine().toInt()
    val arr = Array(times) { 0 }

    repeat(times) {
        arr[it] = br.readLine().toInt()
    }

    val rsArr = insertSortArr(arr)
    rsArr.forEach {
        bw.write("$it\n")
    }

    bw.flush()
    br.close()
    bw.close()
}

/* 2587 */


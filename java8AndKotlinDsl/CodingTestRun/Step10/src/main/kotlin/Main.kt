import java.util.StringTokenizer

fun main() {

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()


    val times = br.readLine().toInt()
    val arr = Array(times) { br.readLine().toInt() }

    for (i in arr)
        bw.write("$i\n")

    bw.flush()
    br.close()
    bw.close()
}

/* 2751 */

import java.util.StringTokenizer

fun main() {

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val times = br.readLine().toInt()
    val arr = Array(times){0}
    repeat(times){
       arr[it] = br.readLine().toInt()
    }

    repeat(times){
        bw.write("${arr[it]}\n")
    }



    bw.flush()
    br.close()
    bw.close()
}

/* 2750 */
fun sortArr(arr:Array<Int>): Array<Int> {

    return arr
}


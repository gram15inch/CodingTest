
fun main() {

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    bw.write("${decomposition(n)}\n")

    bw.flush()
    br.close()
    bw.close()
}

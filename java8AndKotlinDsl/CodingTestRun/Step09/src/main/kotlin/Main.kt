import java.util.StringTokenizer

fun main() {

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()


    val times = br.readLine().toInt()
    val dp = Matrix(100,100)
    repeat(times){
       val token= StringTokenizer(br.readLine())
        val col= token.nextToken().toInt()
        val row= token.nextToken().toInt()
        drawPaper(dp,col,row)
    }

    bw.write(calPaper(dp).toString())

    bw.flush()
    bw.close()
    br.close()

}
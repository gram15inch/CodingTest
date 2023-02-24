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
fun drawPaper(dp: Matrix,x:Int,y:Int){
    dp.matArr.apply {
        repeat(10){row->
            repeat(10){col->
                this[y+row][x+col]=1
            }
        }
    }
}

fun calPaper(dp:Matrix):Int{
    var sum =0
    dp.matArr.also {arr->
        repeat(100){row->
            repeat(100){col->
                sum += arr[row][col]
            }
        }
    }
    return sum
}

class Matrix constructor(val col: Int, val row: Int) {

    var maxCol = 0
    var maxRow = 0
    val matArr = Array(row) {
        Array(col) { 0 }
    }

    fun addRowInts(row: Int, rowStr: String) {
        rowStr.split(" ".toRegex()).also {
            it.forEachIndexed { col, v ->
                matArr[row][col] = v.toInt()
            }
        }
    }

    fun addRowChars(row: Int, rowStr: String) {
        rowStr.also {
            it.forEachIndexed { col, v ->
                matArr[row][col] = v.code
            }
        }
        if(maxCol<rowStr.length)
            maxCol = rowStr.length
        maxRow++
    }


    fun toIntStr(): String {
        val sb = StringBuffer()
        matArr.forEach { row ->
            row.forEachIndexed() { i, col ->
                if (row.size - 1 == i)
                    sb.append("$col")
                else
                    sb.append("$col ")
            }
            sb.append("\n")
        }
        return sb.toString()
    }
    fun toCharStr(): String {
        val sb = StringBuffer()
        matArr.forEach { row ->
            row.forEachIndexed { i, col ->
                if(col==0)
                    return@forEachIndexed
                if (row.size - 1 == i)
                    sb.append("${col.toChar()}")
                else
                    sb.append("${col.toChar()} ")
            }
            sb.append("\n")
        }
        return sb.toString()
    }


}



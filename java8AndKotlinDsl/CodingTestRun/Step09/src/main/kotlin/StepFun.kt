/* 2738 *//*

fun matrixAdd(a: Matrix, b: Matrix): Matrix {

    return a.apply {
        repeat(a.row) { row ->
            repeat(a.col) { col ->
                a.matArr[row][col] += b.matArr[row][col]
            }
        }
    }
}

*/
/* 2566 *//*

fun maxValue(a: Matrix): String {
    var max = -1
    var index = ""
    return a.run {
        repeat(a.row) { row ->
            repeat(a.col) { col ->
                a.matArr[row][col].also {
                    if (it > max) {
                        index = "${row + 1} ${col + 1}"
                        max = it
                    }
                }
            }
        }
        "$max\n$index"
    }
}


*/
/* 10798 *//*


fun verticalRead(a:Matrix):String{
    val sb = StringBuffer()
    return a.run {
        repeat(maxCol){col->
            repeat(maxRow) repeatRow@{row->
                matArr[row][col].also {intChar->
                    if(intChar==0) {
                        if (row == 1)
                            return@repeatRow
                    }
                    else
                        if(intChar.toChar()!=' ')
                            sb.append(intChar.toChar())
                }
            }
        }
        sb.toString()
    }
}

*/
/* 2563 *//*

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
*/

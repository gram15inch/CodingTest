fun main() {

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val col = 15
    val row = 15

    val am = Matrix(col, row)
    with(am){
        repeat (5) {
            this.addRowChars(it,br.readLine())
        }
    }

    bw.write(verticalRead(am))

    bw.flush()
    bw.close()
    br.close()

}



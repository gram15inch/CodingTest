import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test



class Step09Test {
    @Test
    fun initIntMatrixTest(){
        val aM=Matrix(3,3)
        aM.addRowInts(0,"1 2 3")
        aM.addRowInts(1,"4 5 6")
        aM.addRowInts(2,"7 8 9")
        assertEquals("1 2 3\n4 5 6\n7 8 9",aM.toIntStr().trim())
    }

    @Test
    fun addMatrixTest(){
        val col=4
        val row=3
        val am=Matrix(col,row)
        val bm=Matrix(col,row)
        repeat(row){
            am.addRowInts(it,"1 1 1 1")
            bm.addRowInts(it,"2 2 2 2")
        }
        assertEquals("3 3 3 3\n3 3 3 3\n3 3 3 3",matrixAdd(am,bm).toIntStr().trim())

    }
     @Test
    fun addMatrixOneTest(){
        val col=1
        val row=1
        val am=Matrix(col,row)
        val bm=Matrix(col,row)
        repeat(row){
            am.addRowInts(it,"-1")
            bm.addRowInts(it,"2")
        }
        assertEquals("1",matrixAdd(am,bm).toIntStr().trim())
    }
    @Test
    fun maxMatrixTest(){
        val col = 3
        val row = 3
        val am =Matrix(col,row)
        repeat(row){row->
            am.addRowInts(row,"${row+1} ${row+2} ${row+3}")
        }
        assertEquals("5\n3 3",maxValue(am))
    }


    @Test
    fun initCharMatrixTest(){
        val aM=Matrix(15,15)
        aM.addRowChars(0,"abcd")
        aM.addRowChars(1,"abcd")
        aM.addRowChars(2,"bcd")
        assertEquals("a b c d \na b c d \nb c d",aM.toCharStr().trim())
    }
   @Test
    fun verticalReadTest(){
        val aM=Matrix(15,15)
        aM.addRowChars(0,"AABCDD")
        aM.addRowChars(1,"afzz")
        aM.addRowChars(2,"09121")
        aM.addRowChars(3,"a8EWg6")
        aM.addRowChars(4,"P5h3kx")
        assertEquals("Aa0aPAf985Bz1EhCz2W3D1gkD6x",verticalRead(aM))
    }

}
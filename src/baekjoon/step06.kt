package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {

}


// 한수
fun step0603(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    fun isHan(x:Int):Boolean{
        var digits = x
        var digit :Int
        val commonDifference :Int
        var digitBefore :Int
        var digitAfter :Int

        digit = digits%10
        digits /= 10
        digitBefore = digit
        if(digits>0) {
            digit = digits % 10
            digits /= 10
            digitAfter = digit
            commonDifference = (digitBefore+1) - (digitAfter+1)
            digitBefore = digitAfter
            while (digits > 0) {
                digit = digits % 10
                digits /= 10
                if (commonDifference !=  (digitBefore+1) - (digit+1))
                    return false
                digitBefore = digit
            }
        }
        return true
    }

    var sum =0
    val number = br.readLine().toInt()
    for(n in 1 .. number)
        if(isHan(n)) sum++


    bw.write("$sum")


    bw.flush()
    bw.close()
    br.close()
}

// 셀프 넘버 - 4673
fun step0602(){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val constructors = mutableListOf<Int>()
    for(num in 1 until 10000)
        constructors.add(num)

    fun self(n:Int){
        var sum =n
        if(n>10000)
            return
        var digits = n
        while(digits>0){
            sum += digits%10
            digits /=10
        }
        if(!constructors.remove(sum))
            return

        self(sum)

    }
    for ( c in 1 until 10000)
        self(c)

    val strBuilder = StringBuilder()


    for(c in constructors)
        strBuilder.append("$c\n")

    bw.write("$strBuilder")


    bw.flush()
    bw.close()
}
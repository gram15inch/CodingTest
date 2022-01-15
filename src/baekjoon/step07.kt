package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.*


fun main() {


    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var token = StringTokenizer(br.readLine())

    var sum =0
    val a :Int
    val b :Int
    val strBuilder = StringBuilder()
    val charStack = Stack<Char>()

    for(char in token.nextToken().toCharArray())
        charStack.add(char)

    for(char in 1..charStack.size)
        strBuilder.append(charStack.pop())
    a = strBuilder.toString().toInt()

    strBuilder.clear()

    for(char in token.nextToken().toCharArray())
        charStack.add(char)

    for(char in 1..charStack.size)
        strBuilder.append(charStack.pop())

    b = strBuilder.toString().toInt()
    if(a>b)
        bw.write("$a")
    else
        bw.write("$b")


    bw.flush()
    bw.close()
    br.close()
}

// 다이얼 - 5622
fun step0708() {

    
}
// 상수 - 2908
fun step0707() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var token = StringTokenizer(br.readLine())

    var sum =0
    val a :Int
    val b :Int
    val strBuilder = StringBuilder()
    val charStack = Stack<Char>()

    for(char in token.nextToken().toCharArray())
        charStack.add(char)

    for(char in 1..charStack.size)
        strBuilder.append(charStack.pop())
    a = strBuilder.toString().toInt()

    strBuilder.clear()

    for(char in token.nextToken().toCharArray())
        charStack.add(char)

    for(char in 1..charStack.size)
        strBuilder.append(charStack.pop())

    b = strBuilder.toString().toInt()
    if(a>b)
        bw.write("$a")
    else
        bw.write("$b")


    bw.flush()
    bw.close()
    br.close()

}


// 단어의 개수- 1152
fun step0706() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var token = StringTokenizer(br.readLine())

    var sum =0
    while(token.hasMoreElements()){
        token.nextToken()
        sum++
    }

    bw.write("$sum")
    bw.flush()
    bw.close()
    br.close()
}
// 문자열 반복- 2675
fun step0705() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val charCount = mutableMapOf<Char,Int>()
    val chars = br.readLine().toCharArray()
    for (char in 'A'..'Z')
        charCount[char] = 0

    for (char in chars)
        if(char >= 'a')
            charCount[char-32]= charCount[char-32]!! + 1
        else
            charCount[char]= charCount[char]!! + 1

    val maxKeys = mutableListOf<Char>()
    val maxValue = charCount.maxByOrNull { it.value }!!.value
    for(cC in charCount)
        if(cC.value == maxValue)
            maxKeys.add(cC.key)

    if(maxKeys.size > 1)
        bw.write("?")
    else
        bw.write("${maxKeys[0]}")


    bw.flush()
    bw.close()
    br.close()
}

// 문자열 반복- 2675
fun step0704() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val size = br.readLine().toInt()
    val strBuilder =  StringBuilder()


    for (char in 1..size){
        var token = StringTokenizer(br.readLine())

        val times =  token.nextToken().toInt()
        val chars =  token.nextToken().toCharArray()

        for(char in chars)
            for(t in 1..times)
                strBuilder.append("$char")
        strBuilder.append("\n")

    }


    bw.write("$strBuilder")



    bw.flush()
    bw.close()
    br.close()
}

// 알파벳 찾기- 10809
fun step0703() {


    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val charIdxMap = mutableMapOf<Char,Int>()
    val chars = br.readLine().toCharArray()
    for (char in 'a'..'z')
        charIdxMap[char] = -1



    var sum =0
    for ((idx,char) in chars.withIndex())
        if(charIdxMap[char]==-1)
            charIdxMap[char] = idx




    val strBuilder =  StringBuilder()
    for(map in charIdxMap)
        strBuilder.append("${map.value} ")

    bw.write("${strBuilder}")


    bw.flush()
    bw.close()
    br.close()
}


// 숫자의 합- 117220
fun step0702() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val size = br.readLine()
    val digits = br.readLine().toCharArray()
    var sum =0
    for (digit in digits)
        sum += digit.toInt() - 48
    bw.write("${sum}")


    bw.flush()
    bw.close()
    br.close()

}

// 아스키 코드 - 11654
fun step0701(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    bw.write("${br.read().toInt()}")


    bw.flush()
    bw.close()
    br.close()
}
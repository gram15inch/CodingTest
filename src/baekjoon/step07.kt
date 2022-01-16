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

    //var chars = br.readLine().toCharArray()
    var chars = "lol"
    var charList = chars.toList()
    var croChars = listOf("c=","c-","dz=","d-","lj","nj","s=","z=")

    val listIterator = charList.listIterator()
    var c1 :Char
    var c2 :Char
    var c3 :Char
    var strBuilder = StringBuilder()
    var sum =0
    var isTwoSize = false
    while (true){


        if(strBuilder.isBlank())
            if(listIterator.hasNext()) {
                c1= listIterator.next()
                strBuilder.append(c1)
                continue
            }else
                break


        if(strBuilder.length == 1){
            if(listIterator.hasNext()){
                c1= listIterator.next()
                strBuilder.append(c1)
            }else{
                sum++
                break
            }

            if(strBuilder.toString() == "dz"){
                if(listIterator.hasNext()){
                    c1= listIterator.next()

                    if(strBuilder.toString() + c1 == "dz=") {
                        sum += 3
                        strBuilder.clear()
                        continue
                    }
                    listIterator.previous()
                    continue
                }else{
                    sum += 2
                    break
                }
            }

            for(cro in croChars)
                if(cro == strBuilder.toString()){
                    sum++
                    strBuilder.clear()
                    continue
                }

            sum++
            strBuilder.clear()
            listIterator.previous()
        }

        if(strBuilder.length > 1)
            throw IllegalArgumentException("length : $strBuilder")





    }


}
// 크로아티아 알파벳 - 2941
fun step0709() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var chars = br.readLine().toCharArray()

    var croChars = listOf("c=","c-","dz=","d-","lj","nj","s=","z=")
    var sum =0
    var strBuilder = StringBuilder()
    var isCroChar = 0
    for((cIdx,char) in chars.withIndex())
        sum += when{
            (strBuilder.toString() != "")-> {
                isCroChar =0
                for(croChar in croChars)
                    if(croChar == (strBuilder.toString()+char)){
                        isCroChar= 1
                        strBuilder.clear()
                        break
                    }

                if(isCroChar==0){
                    when{
                        (strBuilder.toString()+char == "dz") && (cIdx == chars.size-1)-> isCroChar = 2
                        (strBuilder.toString()+char == "dz") -> strBuilder.append(char)
                        else->{
                            isCroChar = when {
                                (strBuilder.toString() == "dz")&&(cIdx == chars.size-1) -> 3
                                (strBuilder.toString() == "dz") -> 2
                                else -> 1
                            }
                            strBuilder.clear()
                            strBuilder.append(char)


                        }
                    }

                }
                isCroChar
            }
            (char =='c')||(char =='d')||(char =='s')
                    ||(char =='n')||(char =='l')||(char =='z')->{
                if(cIdx == chars.size-1)
                    1
                else{
                    strBuilder.append(char)
                    0
                }
            }
            ('A'<char)||(char<'Z')|| ('a'<char)||(char<'z')->1
            else -> 0
        }
    bw.write("$sum")

    bw.flush()
    bw.close()
    br.close()

}
// 다이얼 - 5622
fun step0708() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var chars = br.readLine().toCharArray()

    var sum =0
    for(char in chars)
        sum += when{
            (char =='A')||(char =='B')||(char =='C')->3
            (char =='D')||(char =='E')||(char =='F')->4
            (char =='G')||(char =='H')||(char =='I')->5
            (char =='J')||(char =='K')||(char =='L')->6
            (char =='M')||(char =='N')||(char =='O')->7
            (char =='P')||(char =='Q')||(char =='R')||(char =='S')->8
            (char =='T')||(char =='U')||(char =='V')->9
            (char =='W')||(char =='X')||(char =='Y')||(char =='Z')->10
            else -> 11
        }
    bw.write("$sum")

    bw.flush()
    bw.close()
    br.close()

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
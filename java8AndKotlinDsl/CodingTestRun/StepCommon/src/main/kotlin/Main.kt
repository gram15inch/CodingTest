import com.sun.xml.internal.fastinfoset.util.StringArray

import java.util.*

fun main() {


}




/* 소인수분해 */
fun primeFactorization(inputNum:Int): List<String> {

    val arrString = mutableListOf<String>()
    var restNum = inputNum


    while(true)
        if(1 == restNum){
            return arrString
        } else
            for(n in 2..inputNum){
                if(restNum % n == 0){
                    arrString.add("$n")
                    restNum /=n
                    break
                }
            }


}
@Suppress("unused")
fun primeFactorizationRun(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val tokens = StringTokenizer(br.readLine())
    val valueInt = tokens.nextToken().toInt()



    val result = primeFactorization(valueInt)


    result.forEach{
        bw.write("${it}\n")
    }

    bw.flush()
    bw.close()
    br.close()
}

/* 알파벳 갯수 */
fun numberOfChar(char1:Char, char2:Char, strArr: StringArray):String{
    val arr = IntArray(200)
    for(idx in 0 until strArr.size)
        strArr[idx]
            .toCharArray()
            .forEach {char-> arr[char.code]++ }

    return "${arr[char1.code]} ${arr[char2.code]}"
}
@Suppress("unused")
fun numberOfCharRun(){

    /*  [value]
      a b
      aaaaaabbb
      bcccccccc
  */

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val tokens = StringTokenizer(br.readLine())
    val valueChar1 = tokens.nextToken().first()
    val valueChar2 = tokens.nextToken().first()

    val valueArray = StringArray()
    valueArray.add(br.readLine())
    valueArray.add(br.readLine())

    val result = numberOfChar(valueChar1,valueChar2,valueArray)

    bw.write(result)
    bw.flush()
}





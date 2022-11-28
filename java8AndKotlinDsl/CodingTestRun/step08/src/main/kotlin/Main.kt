import com.sun.xml.internal.fastinfoset.util.StringArray

fun main(args: Array<String>) {




}

fun numberOfChar(char1:Char, char2:Char, strArr:StringArray):String{
    val arr = IntArray(200)
    for(idx in 0 until strArr.size)
        strArr[idx]
            .toCharArray()
            .forEach {char-> arr[char.code]++ }

    return "${arr[char1.code]} ${arr[char2.code]}"
}
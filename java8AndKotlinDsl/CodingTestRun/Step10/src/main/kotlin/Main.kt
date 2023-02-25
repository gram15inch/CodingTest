fun main() {

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val times = br.readLine().toInt()
    val arr = Array(times) { 0 }

    repeat(times) {
        arr[it] = br.readLine().toInt()
    }

    val rsArr = insertSortArr(arr)
    rsArr.forEach {
        bw.write("$it\n")
    }

    bw.flush()
    br.close()
    bw.close()
}

/* 2750 */
fun insertSortArr(arr: Array<Int>): Array<Int> {

    var tmp:Int
    repeat(arr.size){abs->
        var idx= 0
        repeat(abs){
            if(arr[idx] > arr[idx+abs+1]){
                tmp = arr[idx+abs+1]
                arr[idx+abs+1] = arr[idx]
                arr[idx] = tmp
            }
            idx++
        }

    }
    return arr
}



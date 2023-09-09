/* 2750 */
fun selectSortArr(arr: Array<Int>): Array<Int> {
    var minIdx = 0
    var tmp: Int
    do {
        repeat(arr.size - (minIdx + 1)) {
            if (arr[it + minIdx + 1] < arr[minIdx]) {
                tmp = arr[it + minIdx + 1]
                arr[it + minIdx + 1] = arr[minIdx]
                arr[minIdx] = tmp
            }
        }
    } while (++minIdx < arr.size)
    return arr
}

fun insertSortArr(arr: Array<Int>): Array<Int> {
    var idx: Int
    var tmp: Int
    repeat(arr.size) { abs ->
        idx = abs
        while (idx != 0 && arr[idx - 1] > arr[idx]) {
            tmp = arr[idx - 1]
            arr[idx - 1] = arr[idx]
            arr[idx] = tmp
            idx--
        }
    }
    return arr
}
fun bubbleSort(arr: IntArray): IntArray {
    val n = arr.size
    for (i in 0 until n) {
        for (j in 0 until n - i - 1) {
            // 인접한 두 원소를 비교하여 큰 값을 오른쪽으로 이동
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
    return arr
}

fun insertionSort(arr: IntArray): IntArray {
    val n = arr.size
    for (i in 1 until n) {
        val key = arr[i]
        var j = i - 1
        // key 값을 적절한 위치에 삽입
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]
            j--
        }
        arr[j + 1] = key
    }
    return arr
}

/* 2587 */
fun middleArr(arr: Array<Int>): String {
    var sum = 0
    arr.forEach {
        sum += it
    }
    val avg: Int = sum / 5
    val mid = selectSortArr(arr)[2]

    return "$avg\n${mid}"
}

/* 25305 */
fun cutArr(arr:Array<Int>,cut:Int): Int {
    return selectSortArr(arr)[arr.size-cut]
}


/* 2751 */

fun kotlinSort(arr:Array<Int>): List<Int> = arr.sorted()



/* 10989 */

fun countingSort(arr: IntArray, max: Int): IntArray {
    val countArr = IntArray(max+1)

    for (i in arr)
        countArr[i]++

    for(i in 1..max)
        countArr[i] += countArr[i - 1]

    val rsArr = IntArray(arr.size)

    for (a in arr) {
        (countArr[a] - 1).let{
            if(it>=0) {
                rsArr[it] = a
                countArr[a]--
            }
        }
    }

    return rsArr
}

/* 2798 */
fun blackJack(n:Int,m:Int,arr:IntArray): Int {
    var max = 0
    for(i in 0 until n-2)
        for(j in i+1 until n-1)
            for(k in j+1 until n){
                val sum = arr[i] +arr[j] +arr[k]
                if(sum==m){
                    return m
                }else if(sum<m)
                    if(max<sum)
                        max = sum
            }

    return max
}

/* 2231 */
fun decomposition(n :Int): Int {
    var min = 0

    do{
        var sum = min
        val arrs= min.toString().toCharArray()
        for(a in arrs){
            sum += a -'0'
        }
        if(sum==n)
            return min
    }
    while(++min<n)

    return 0
}
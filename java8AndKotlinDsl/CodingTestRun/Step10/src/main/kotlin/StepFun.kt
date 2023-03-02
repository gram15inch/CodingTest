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

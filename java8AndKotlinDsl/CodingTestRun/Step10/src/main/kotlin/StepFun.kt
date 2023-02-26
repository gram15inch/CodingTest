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



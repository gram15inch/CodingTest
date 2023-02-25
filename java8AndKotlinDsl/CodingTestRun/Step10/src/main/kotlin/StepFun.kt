fun selectSortArr(arr: Array<Int>): Array<Int> {
    var minIdx = 0
    var tmp :Int
    do {
        repeat(arr.size-(minIdx+1)){
            if(arr[it+minIdx+1]<arr[minIdx]){
                    tmp = arr[it+minIdx+1]
                    arr[it+minIdx+1] = arr[minIdx]
                    arr[minIdx] = tmp
            }
        }
    } while (++minIdx < arr.size)
    return arr
}



fun o1(n: Array<Int>): Int {
    var sum = 0
    if (n[0] == 0)
        sum++
    return sum
}

fun oN(n: Array<Int>): Int {
    var sum = 0
    for (i in 0 until n.size)
        sum++
    return sum
}

fun oN2(n: Array<Int>): Int {
    var sum = 0
    for (i in 0 until n.size)
        for (j in 0 until n.size)
            sum++
    return sum
}

fun oNM(n: Array<Int>, m: Array<Int>): Int {
    var sum = 0
    for (i in 0 until n.size)
        for (j in 0 until m.size)
            sum++
    return sum

}

fun oN3(n: Array<Int>): Int {
    var sum = 0
    for (i in 0 until n.size)
        for (j in 0 until n.size)
            for (k in 0 until n.size)
                sum++
    return sum
}

fun o2N(n:Int): Double {
    if (n==0) return n.toDouble()
    else if (n== 1) return n.toDouble()
    return o2N(n-1) + o2N(n-2)
}

fun oLogN(n: Array<Int>): Int {
    var sum = 0
    return sum
}

fun oSqrtN(n: Array<Int>): Int {
    var sum = 0
    return sum

}
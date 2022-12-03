package util.test

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@OptIn(ExperimentalTime::class)
suspend fun timeCheck(timeName: String="----start----", m: suspend () -> String) {
    var invokeStr :String
    val timeMillie = measureTimedValue {
        invokeStr= m.invoke()
    }
    if(timeName=="----start----")
        println(timeName)
    else
        println("$timeName : ${timeMillie.duration} / $invokeStr")
}

// default = 추천 6, size 9 이상부터 급격한 오류 발생
// io = 추천 12,  size 14 이상부터 급격한 오류 발생
@OptIn(ExperimentalTime::class)
fun timeCheckAsync(timeName: String="----start----", m: suspend () -> String) = CoroutineScope(Dispatchers.IO).async{
    var invokeStr :String
    val timeMillie = measureTimedValue {
        invokeStr= m.invoke()
    }
    if(timeName=="----start----")
        println(timeName)
    else
        println("$timeName : ${timeMillie.duration} / $invokeStr")
}

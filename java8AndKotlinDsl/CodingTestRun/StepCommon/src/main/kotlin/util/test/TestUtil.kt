package util.test

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
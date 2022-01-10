package koInAc



// 1/10 로 옮겨야함

// 경로 파싱에 정규식 사용하기
fun parsePath(path:String){
    val regex = """(.+)/(.+)\.(.+)""".toRegex() // 3중 따옴표 에서는 이스케이프 문자 필요없음 "." : \\. -> \.
    // (.+)/  : 마지막 슬래시 전까지 모든문자
    // (.+)\. : 마지막 따옴표 전까지 모든문자
    // (.+)   : 나머지 모든문자
    val matchResult = regex.matchEntire(path)
    if(matchResult !=null){
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext: $extension")
    }
    // 호출 : parsePath("/dir/dir2/text.txt")
}

// 여러줄 3중 따옴표 문자열
fun tripleQuotation(){
    val kLogo = """|  // 
                  .| // 
                  .|/ \""".trimMargin(".") //  '.' 이전에 들여쓰기를 제거
    println(kLogo)

    val setDollar = """${'$'}100""" // '$' 를 사용할땐 문자열 템플릿 사용
    println(setDollar)

}
fun main() {

}
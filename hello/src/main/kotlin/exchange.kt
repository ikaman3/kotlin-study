import kotlin.system.exitProcess

// 1. 원화를 달러로 변환하기 : 원화와 환율을 입력받고 달러 환산 및 거스름돈 출력

fun main() {
    print("원화: ");
    val won = readln().toInt()
    print("통화: ")
    val currencyName = readln()

    val itemQuantity = 8
    val currencySet = arrayOf(
        arrayOf<String>("USD", "JPY", "EUR", "CNY", "GBP", "AUD", "CAD", "NZD"),
        arrayOf<Double>(1273.00, 916.98, 1429.07, 177.85, 1666.36, 870.16, 962.57, 810.65),
        arrayOf<Double>(1270.00, 918.33, 1420.62, 177.48, 1662.81, 874.4, 967.18, 810.26)
    )

    var selectedIndex = -1
    for (i in 0..currencySet[0].size - 1) {
        if (currencyName == currencySet[0][i]) {
            selectedIndex = i
        }
    }
    if (selectedIndex == -1) {
        println("존재하지 않는 통화명입니다. 다시 실행하세요오오오오오오오~~~~~~")
        exitProcess(0)
    }

    println("통화명  매매기준율   전일대비")
    for (i in 0..currencySet.size - 1) {
        print("${currencySet[i][selectedIndex]}    ")
    }
    println()

    var exchange = won / currencySet[1][selectedIndex] as Double
    if (currencyName == "JPY") exchange *= 100
    println("환전 금액: $exchange $currencyName")
}
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.ceil

/*
// 1. 원화를 달러로 변환하기 : 원화와 환율을 입력받고 달러 환산 및 거스름돈 출력







5. 문자열에서 특정 글자의 개수 출력
 */

fun main() {
    print("원화: ");
    val won = readln().toInt()
    print("1달러 당 원화 환율: ");
    val exchangeRate = readln().toDouble()

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.CEILING
    val dollars = df.format(won / exchangeRate)
    val change: Int = ceil(won % exchangeRate).toInt()
    println("달러: $dollars, 거스름돈: $change")


}
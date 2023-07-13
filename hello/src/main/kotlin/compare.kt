// 2. 두 자리 정수를 입력받고 10의 자리와 1의 자리가 같은지 비교해서 출력

fun main() {
    print("두 자리의 정수: ")
    val integer = readln().toInt()
    // 입력 받은 정수가 2자리 정수이고 100을 넘는지 체크
    if (integer < 10 || integer >= 100) return

    val tensPlace = integer.toString()[0]
    val onesPlace = integer.toString()[1]

    val result = if (tensPlace == onesPlace) "같아요!" else "달라요!"
    println("두 자리의 숫자는 서로...$result")
}

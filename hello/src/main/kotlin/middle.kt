// 3. 정수 3개를 입력받고 중간 크기의 수를 출력
// n개의 정수 입력으로 확장

fun main() {
    print("정수 n개 입력: ")
    val threeIntegers = readln().split(' ').map { it.toInt() }.sorted()
    val listSize = threeIntegers.size
    val middle = if (listSize % 2 != 0) {
        threeIntegers[(listSize/2)]
    } else {
        (threeIntegers[((listSize - 1) / 2)] / 2.0).toInt()
    }

    println("중간값: $middle")
}
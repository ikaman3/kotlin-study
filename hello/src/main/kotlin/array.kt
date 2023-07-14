import java.util.*

// Global Variable
val lottoSet = arrayOf(Array<Int>(6){0}, Array<Int>(6){0},
    Array<Int>(6){0}, Array<Int>(6){0})

fun main() {
    // 고정길이 배열
    val a: Array<Int> = Array(5){0}
    val b = arrayOf(0, 0, 0, 0, 0)
    val c = intArrayOf(0, 0, 0, 0, 0)
    val d = arrayOfNulls<Int>(5) // Default = null

    a[0] = 888
    val x = a[0] + a[1]
    a.set(1, 8) // a[1] = 8
    val y = a.get(1) // y = a[1]

    val e = a.plus(13) // a 배열에 원소 하나 추가해서 새로운 배열 생성
    val f = e + 21
    println("size = ${e.size}")
    println("size = ${f.size}")

    // 배열 탐색
    for (i in 0..f.size - 1 ) print(f[i])
    println()
    for (i in f) print(i)

    // 배열 원소를 문자열로 변환
    println(Arrays.toString(f))
    println(f.contentToString())

    makeLotto()
    // 빈도수 계산. 가장 많이 나온 숫자

    val intArray = Array<Int>(45){it + 1}
//    println(intArray.contentToString())
}

fun makeLotto() {
    fun makeOneLotto() : Array<Int> { // Array<Int> = int[]
        val lotto = Array<Int>(6) { it + 1 } // it -> it + 1 의 축약
        val r = Random()
        for (i in 0..5) {
            while (true) {
                val num = r.nextInt(45) + 1
                if (lotto.indexOf(num) >= 0) continue // num 값이 배열의 어디에 있는지 인덱스 리턴, while로 돌아감
                lotto[i] = num
                break
            }
        }
        lotto.sort() // 코틀린 배열은 Array<T> 제네릭 클래스로 정의
        println(lotto.contentToString())
        /*
        // 30번대 숫자만 출력
        for (i in lotto)
            if (i in 30..39) print("$i ")
        println()
        // Lambda: Parameter -> Body
        lotto.forEach { value -> if (value in 30..39) print("$value ") }
        println()
         */
        return lotto
    }

    for (i in 0..3) {
        val r = Random()
//        val lotto = makeOneLotto()
        // 4개의 로또 생성
//        for (i in 0..lottoSet.size - 1) {
//            for (j in 0..lottoSet[0].size - 1) {
//                while (true) {
//                    val num = r.nextInt(45) + 1
//                    if (lottoSet[i].indexOf(num) >= 0) continue
//                    lottoSet[i][j] = num
//                    break
//                }
//            }
//            println("${lottoSet[i].contentToString()}")
//        }
    }
    // 4개의 로또 생성
    for (i in 0..3) {
        val lotto = makeOneLotto()
        for (j in 0..lotto.size - 1) lottoSet[i][j] = lotto[j]
    }
}
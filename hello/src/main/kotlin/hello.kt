import java.util.Random
import java.util.Scanner
import kotlin.math.PI

//fun main(args: Array<String>) {
//    println("Hell Kotlin!!!!!!!@@@@@@@@@")
//}
fun main() {
/*
    // Input and Output
    val a = 5;
    print("Integer Input: ")
    // !!: Null 값이 아님
//    val b = readLine()!!.toInt() // readLine()!!- 문자열 형식으로 입력. toInt() - 정수로 변환
    val b = readln().toInt()
    val scn = Scanner(System.`in`) // Java: Scanner scn = new Scanner(System.in);
    print("Integer Input: ")
    val c = scn.nextInt()
    println("Hell Kotlin!!!!!!!@@@@@@@@@ : $a")
    println("Hell Kotlin!!!!!!!@@@@@@@@@ : ${a + b + c}")

    // Type casting
    var x: Int = 7
    var d: Double = 0.0

    d = x.toDouble() // Java: d = (double) x / 객체참조변수이므로 메소드를 사용하여 형변환
*/
/*
    // 반지름 입력받고 원의 둘레와 면적 출력
    print("반지름: ")
    val r = readln().toDouble()
    println("원의 둘레: ${2 * PI * r}, 원의 면적: ${2 * PI * r * r}")
*/
/*
    var str1 = "Hello"
    var str2 = "World!"
    // Java: if(str1.equals(str2)) ...
    if (str1 == str2) println("Equal") else println("Not Equal")
    val idx = str1.indexOf('e') // 문자열에서 특정 글자의 인덱스 리턴
    val text = str1.substring(0, 2) // 문자열에서 0..<2 위치의 문자 리턴
    // 나눗셈 계산. input: 6/2 output: "답: 3"
    val expr = readln()
    val i = expr.indexOf('/')
 */
    /*
    if (i > 0) {
        val m1 = expr.substring(0, i).trim().toInt()
    //    val m2 = expr.substring(i+1, expr.length).toInt()
        val m2 = expr.substring(i+1).trim().toInt()
        val result = m1 / m2
        println("답: $result")
    } else {
        println("나눗셈이 아님")
    }
     */
    /*
    val result = if (i > 0) { // if expression
        val m1 = expr.substring(0, i).trim().toInt()
        val m2 = expr.substring(i+1).trim().toInt()
        "답: " + (m1 / m2).toString()
    } else "나눗셈이 아님" // if expression에서는 반드시 else 필요
    println(result)
     */
/*
    // Conditions: BMI 계산
    print("몸무게: ")
    val kg = readln().toDouble()
    print("키(m): ")
    val m = readln().toDouble()
    val BMI: Double = kg / (m * m)
    // if
    if (BMI < 18.5) println("저체중")
    else if (BMI in 18.5..24.0) println("정상체중")
    else println("과체중")
    // No argument When statement
    when {
        BMI < 18.5 -> println("저체중")
        BMI in 18.5..24.0 -> println("정상체중")
        else -> {
            println("과체중")
        }
    }
    // When expression: 마지막에 리턴 값
    val result = when {
        BMI < 18.5 -> {
            println("더 먹어라")
            "저체중"
        }
        BMI in 18.5..24.0 -> "정상체중"
        else -> {
            "과체중"
        }
    }
    println(result)
 */
/*
    // Loop: 주사위 짝수의 합
    val r = Random()
    var count = 0
    var result = 0
    // While
    while (count in 0..9) {
        var dice = r.nextInt(6) + 1
        /*
        if (dice % 2 == 0) {
            result += dice
        }*/
        result += if (dice % 2 == 0) dice else 0 // 더 짧은 코드
        count++
    }
    println("짝수의 합: $result")
    // For
    result = 0
    for (i in 0..9) {
        val dice = r.nextInt(6) + 1
        result += if(dice % 2 == 0) dice else 0
    }
    println("짝수의 합: $result")
     */
    // 문자열 입력받고 특정 글자 개수 출력
    print("Sentence: ")
    val str = readln()
    print("Character: ")
    val ch = readln()[0] // String의 첫 글자 = 문자 한 개 입력받는 방법
    var count = 0
    for (i in str) // For each 구문. in 뒤의 복합체에서 값을 하나씩 반복
        if (i == ch) count++
    println("Count = $count")
}

/*
 조건식(Expression) 조건문(Statement): 조건식은 리턴값 존재, 조건문은 없음
 코틀린의 = 는 조건문
 val a = if(...)
 */
fun main() {
    print("정수 3개 입력: ")
    /*
    var a: Int? = 0
    var b = 0
    var c = 0

    a = readln()?.toInt()
    b = readln()!!.toInt()
    c = readln()!!.toInt()

    val max = fun (a: Int?, b: Int, c: Int) : Int {
        var result = a!!
        fun comp(x: Int, y: Int) = (if (x>y) x else y)

        result = comp(result, b)
        result = comp(result, c)
//    if (result < b) result = b;
//    if (result < c) result = c;
        return result
    }

    val d = max(a, b, c)
    print("MAX: $d")
     */

    val threeIntegers = readln().split(' ').map { it.toInt() }.sorted()
    val max = fun () = threeIntegers[(threeIntegers.size - 1)]
    println(max())

}
/*
fun max(a: Int?, b: Int, c: Int) : Int {
    var result = a!!
    fun comp(x: Int, y: Int) = (if (x>y) x else y)

    result = comp(result, b)
    result = comp(result, c)
//    if (result < b) result = b;
//    if (result < c) result = c;
    return result
}
 */
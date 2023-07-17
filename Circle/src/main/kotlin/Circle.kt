class Cube (var x: Int, var y: Int, var z:Int) {
    fun getSize() = x * x * 6
}

class Circle (var r: Int, var x: Int = 1, var y: Int = 1) { // 주 constructor와 property가 결합된 정의
//    // Property
//    var r: Int = _r
//    var x = _x
//    var y = _y

    // function이 아님. 생성자 이후 추가로 해줘야 할 초기화를 수행
    init {
        x = if (x < 0) x * (-1) else x
    }

    // Contructor
//    constructor() { r = 3 } // 기본 생성자: parameter가 없는 생성자
//    constructor(r: Int, x: Int, y: Int) {
//        this.r = r // this: 객체 자신을 가리키는 참조 변수
//        this.x = x
//        this.y = y
//    }
//    constructor(r: Int) {
//        this.r = r
//        x = 1
//        y = 1
//    }
    // Method
    fun getSize() : Double {
        return r * r * 3.14
    }
    fun getLength() = r * 2 * 3.14
}

fun main() {
    val c = Circle(3, 2, 2) // Java: Circle c = new Circle()
    c.r = 5
    println("r = ${c.r}, size = ${c.getSize()}, length = ${c.getLength()}")
    val c2 = Circle(7)
    val c3 = Circle(8, -3, 5)
    println(c3.getSize())
    println(c3.x)

    val cube = Cube(8, 3, 2)
    println(cube.getSize())
}
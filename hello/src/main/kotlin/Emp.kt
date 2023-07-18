// Super Class
open class Emp(protected var name: String, protected var salary: Int) {
    open protected var time: Int = 0
    open fun computeSalary() {
        salary = 0
    }
}

// Sub Class
class Fulltime(name: String, salary: Int, var base: Int, var workDays: Int, var minus: Int) : Emp(name, salary) {
    override var time: Int = 1000 // Sub Class에서 초기값을 재정의
        // Custom getter/setter
        get() = field
        set(value) { // setTime()
//            time = value // time = value => time.setTime(value) => 무한 반복하여 StackOverFLow 발생
//            field = value
            if(value > 1000) field = value * 2 else field = value
        }
    var telno: String = ""
        private set // telno를 Read-Only Property로 선언
    // 재정의
    override fun computeSalary() {
        time = 2000 // time.setTime(2000)
        salary = base - (30 - workDays) * minus
    }
    override fun toString(): String {
        return "Fulltime(name=$name, salary=$salary, base=$base, workDays=$workDays, minus=$minus, time=$time)"
    }

}

class Parttime(name: String, salary: Int, var workHours: Int, var hourMoney: Int) : Emp(name, salary) {
    override fun computeSalary() {
        salary = workHours * hourMoney
    }
    override fun toString(): String {
        return "Parttime(name=$name, salary=$salary, workHours=$workHours, hourMoney=$hourMoney, time=$time)"
    }
}

fun main() {
    val fulltime = Fulltime("Daniel", 0, 2500000, 21, 75000)
    fulltime.computeSalary()
//    fulltime.salary = 540000
//    fulltime.telno = "010-1234-5678"
    println(fulltime)
    val parttime = Parttime("Jack", 0, 35, 10000)
    parttime.computeSalary()
    println(parttime)
    var emp : Emp = fulltime // Up casting: Fulltime -> Emp
    fulltime.workDays = 25
    emp.computeSalary() // Polymorphism(다형성): emp 객체에게 computeSalary 메시지를 전달한다.
    println(emp)
    emp = parttime
    parttime.workHours = 37
    emp.computeSalary()
    println(emp)

    // ListOf, MutableListOf
    val myList = mutableListOf<Emp>()
    myList.add(fulltime)
    myList.add(parttime)
    myList.add(Parttime("Musk", 0, 28, 11520))
    for (e in myList) {
        e.computeSalary()
        println(e)
    }
}
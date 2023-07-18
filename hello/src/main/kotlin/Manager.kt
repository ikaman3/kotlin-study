class Manager {
    val data = arrayOfNulls<Book>(5) // Book instance 배열 생성. 길이는 5개, null로 초기화
    var count = 0

    // Method Overloading
    fun add(book: Book) { // Manager --> Book 매니저가 책에 의존하는 연관관계 형성
        data[count++] = book
    }
    fun add(title: String, author: String, price: Int, rating: Float) {
        data[count++] = Book(title, author, price, rating)
    }
    fun find(title: String) : Book? {
        for (book in data)
            if (book != null && book.title == title) return book
        return null
    }
    fun find(book: Book) : Book? {
        for (book2 in data)
            if (book2 != null) {
                if (book2.equals(book)) return book2
            }
        return null
    }
    fun showAll() {
        for (i in 0..count - 1) println(data[i])
    }
}

fun main() {
    val manager = Manager()
    var book = Book("C++", "Daniel", 12000, 9.1.toFloat())
    manager.add(book)
    manager.add("Design", "Park", 22000, 9.4.toFloat())
    manager.add("Node.js", "Torbalz", 99000, 9.2.toFloat())
    var book2: Book? = manager.find("Design23")
    println(book2?.price ?: 0)

    var title = book2?.title // public 접근이 아님. book2?.getTitle() 실행
    book2?.rating = 9.5.toFloat() // book2?.setRating(9.5)

    manager.showAll()
    println(manager.find(book))
}
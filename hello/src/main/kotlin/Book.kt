data class Book (var title: String, var author: String, var price: Int, var rating: Float)
// Kotlin의 private은 getter, setter를 생성하지 않는다는 의미
// Data Class: 데이터를 담는 클래스. toString/equals을 자동으로 Overriding 해줌, Object 간의 비교가 가능
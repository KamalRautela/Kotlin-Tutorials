package beginner_kotlin.data_class

// data class — API response / DB structure ke liye
// auto-generates: equals(), hashCode(), toString(), copy(), componentN()
data class User(
    val id: Int,
    val name: String,
    val email: String,
    val age: Int
)

// regular class — equals() reference compare karta hai
class Person(val name: String)

fun main() {
    val user1 = User(1, "John", "john@mail.com", 18)

    // copy() — ek field change, baaki same
    val user2 = user1.copy(age = 19)
    println("user2 age: ${user2.age}")   // 19

    // equals() — data class values compare karta hai
    val user3 = user1.copy()
    println("user1 == user3: ${user1 == user3}")  // true

    // toString() — auto generated
    println(user1)  // User(id=1, name=John, email=john@mail.com, age=18)

    // destructuring
    val (id, name) = user1
    println("id: $id, name: $name")

    // regular class — reference compare
    val p1 = Person("Amit")
    val p2 = Person("Amit")  // alag object, same values
    println("p1 == p2: ${p1 == p2}")  // false — reference alag hai
}
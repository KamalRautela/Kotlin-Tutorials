package beginner_kotlin.variables

const val KEY_AUTH_TOKEN = "auth_token"  // compile-time constant — sirf top-level/companion object mein

fun main() {
    val name: String = "Kamal"
    var age = 25                         // type inference — explicitly likhna zaroori nahi
    age = 26
    // name = "Rautela"                  // ❌ Error: val cannot be reassigned

    // val reference immutable hai — andar data change ho sakta hai
    val list = mutableListOf("a", "b")
    list.add("c")                        // ✅ allowed — reference same hai
    // list = mutableListOf("x")         // ❌ Error — nayi object assign nahi

    println("Name: $name, Age: $age, Key: $KEY_AUTH_TOKEN")
    println("List: $list")
}
package beginner_kotlin.scope_functions

data class UserRegistration(var name: String? = null, var email: String? = null)

fun main() {
    val user1 = UserRegistration("John", "john@mail.com")
    val user2 = UserRegistration()  // name = null

    // let — nullable check, null hone pe skip
    user2.name?.let { println("Name: $it") }  // null — kuch print nahi hoga
    user1.name?.let { println("Name: $it") }  // "Name: John"

    // apply — object initialize karo, this se access, object return
    val user3 = UserRegistration().apply {
        name = "Kamal"
        email = "kamal@mail.com"
    }

    // also — side effect (log/debug), it se access, object return
    val user4 = user3.also {
        println("Logging: ${it.name}")  // object change nahi hota
    }

    // run — block mein operations, result return karo
    val greeting = user3.run {
        "Hello, $name!"  // last line return hoti hai
    }
    println(greeting)

    // with — multiple properties access, this implicit
    with(user3) {
        println("Name: $name, Email: $email")
    }
}

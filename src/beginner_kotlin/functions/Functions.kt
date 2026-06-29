package beginner_kotlin.functions

fun main() {
    // basic function
    val sum = add(2, 3)
    printResult(sum)

    // default parameter — duration likhna zaroori nahi
    greet(name = "Kamal")

    // named parameter — override karo jab zaroori ho
    greet(name = "Kamal", greeting = "Namaste")

    // single expression function
    val product = multiply(3, 4)
    println("Product: $product")
}

fun add(a: Int, b: Int): Int = a + b

fun multiply(a: Int, b: Int) = a * b

fun greet(name: String, greeting: String = "Hello") {
    println("$greeting, $name!")
}

// Unit function — kuch return nahi karta
fun printResult(result: Int) {
    println("Result: $result")
}
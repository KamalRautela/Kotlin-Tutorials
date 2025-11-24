package kotlinBasics

fun main() {
    println(add(5, 2))       // Function call with arguments, prints 7

    printMessage(3)          // Function call with argument, prints "Hello" 3 times

    println(add2(10, 2))     // Single-expression function call, prints 12
}

// Function with two Int parameters and Int return type
fun add(num1: Int, num2: Int): Int {
    val sum = num1 + num2
    return sum               // Explicit return of sum
}

// Single-expression function returning sum
fun add2(num1: Int, num2: Int) = num1 + num2

// Function with a default parameter value (count = 5)
fun printMessage(count: Int = 5) {
    for (i in 1..count) {
        println("Hello")     // Prints "Hello" count times
    }
}

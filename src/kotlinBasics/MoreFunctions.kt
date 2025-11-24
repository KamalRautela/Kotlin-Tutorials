package kotlinBasics

import kotlin.math.pow

fun main() {
    println(addition(2, 4))         // Normal function call: prints 6

    // Named arguments use karna (order change kar sakte hain)
    addition(b = 3, a = 5)          // Call but no print, return value ignored

    // Function reference: addition function ko variable me assign karna
    val fn = ::addition

    // Reference to power function
    val pw = ::power
    print(pw(1.2, 3.4))             // Prints result of 1.2^3.4

    // Function reference se function call karke print karna
    printMessage(fn(1, 4))           // Prints "Result is 5"
}

// Int type addition function
fun addition(a: Int, b: Int): Int {
    return a + b
}

/*
// Overloaded function (commented out) to support Double addition
fun addition(a: Double, b: Double): Double {
    return a + b
}
*/

// Double type power function using Kotlin math library
fun power(a: Double, b: Double): Double {
    return a.pow(b)
}

// Function to print message with a given count

package beginner_kotlin

/**
 * Quick demonstration of Immutability and String Templates.
 */
fun main() {
    val age = 25  // Fixed value (val)
    var city = "Delhi" // Can change (var)

    // Using String Templates
    println("I am $age years old and I live in $city.")

    // Using Expression Template
    println("In 5 years, I will be ${age + 5} years old.")

    // [1] TYPE INFERENCE: Compiler value dekh kar type automatically detect karta hai.
    val a = 10

    // [2] DEFERRED INITIALIZATION: Bina value ke declaration possible hai,
    // lekin "Explicit Type" (: Int) dena mandatory hai.
    val d : Int

    // [3] INITIALIZATION: Variable ko value assign karna.
    d = 5

    // [4] EXPLICIT TYPE: Type aur Value dono ko ek saath define karna.
    val e : String = "Hello"

    // [5] DEFINITE ASSIGNMENT: Variable use karne se pehle initialize hona chahiye.
    // Agar 'd' initialized nahi hota, toh "Compile-time Error" aata.
    print(d)
}
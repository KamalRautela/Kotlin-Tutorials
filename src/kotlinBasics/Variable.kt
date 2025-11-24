package kotlinBasics

/*
* Variable Kotlin me ek container hota hai jo value store karta hai.
* 'val' ka matlab hai ek baar value assign karne ke baad usse change nahi kar sakte (immutable).
* 'var' ka matlab hai variable ki value change ho sakti hai (mutable).
*/

fun main() {
    var score = 5       // Mutable variable, value change ho sakti hai
    score = 6           // valid, kyunki 'score' var hai

    val str = "Kamal"   // Immutable variable, ek baar value assign hone ke baad change nahi kar sakte
    // str = "Anil"     // Error: Val cannot be reassigned

    /*
    * Data types in Kotlin:
    * Integer types: Byte, Short, Int, Long
    * Floating point: Float, Double
    * Boolean: true or false
    * Character: Char, String
    */

    // Kotlin ka feature: Type Inference
    // Compiler khud variable ka data type infer karta hai
    val temperature = 98.7         // Double
    val isRaining = true           // Boolean
    val character = 'a'            // Char
    val message = "hello"          // String

    // Once type assigned, usse badalna allowed nahi
    // temperature = 36               // Error: Val cannot be reassigned
}

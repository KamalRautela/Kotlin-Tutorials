package kotlinBasics

import kotlin.math.pow

fun main() {

    // Function reference: powerr function ko variable ke through call kar sakte ho
    var fn = ::powerr        // fn ab powerr ka reference hai

    // Simple lambda (function as variable): do number add karne ke liye
    val lambda1 = {x: Int, y: Int -> x + y}

    // Multi-line lambda: function ke andar multiple lines likh sakte ho
    val multiLineLambda = {
        println("Hi")        // Ek print statement
        val a = 4 + 5        // Variable declare and value assign
        "Hello"              // Last value return hoti hai (agar block me multiple returns hain, toh last wala)
        3                    // Outputs 3
    }
    println(multiLineLambda())      // Output: Hi \n 3 (first prints "Hi", then returns 3)

    // Lambda with two params, just returns x*x (output: square of first number)
    val singleParam = {x: Int, y: Int -> x * x}  // y ignore ho raha hai

    // Strict type lambda: ek integer lega aur square return karega
    val lambds2 = {x : Int-> x * x}

    // Lambda message print karne ke liye (input: string, output: print "Hi")
    val sayHi = {msg: String -> println("Hi")}

    // Lambda message ke response generate karne ke liye (input: string, output: "Hi")
    val sayHi2 = {msg: String -> "Hi"}

    // Lambda me 'it' ka use, jab single argument ho
    val singleParam2: (Int) -> Int = {it + it}

    // Higher-order function: calculator ko pass ho raha hai ek lambda (do number ko add karo)
    calculator(1.4, 1.6) { a, b -> a + b }

    // fn function reference ka use (powerr ka reference hai)
    println(fn(3.5, 6.3))      // Output: powerr(3.5, 6.3) ka print

    // Higher-order function: calculator ko function reference pass kiya (sum function)
    calculator(4.3, 9.2, ::sum)
}

// Double value add karne wala function, as reference or lambda use
fun sum(a: Double, b: Double): Double {
    return a + b
}

// Power function: do Double input le ke ek ko dusre ka power banata hai aur print karta hai
fun powerr(a: Double, b: Double) {
    println(a.pow(b))
}

// Higher-order function: do value aur ek lambda/function input leta hai, operation perform karta hai
fun calculator(a: Double, b: Double, gn:(Double, Double) -> Double) {
    val result = gn(a, b)  // gn ek lambda/function hai jo do Double se result banata hai
    println(result)        // Output result ko print karo
}

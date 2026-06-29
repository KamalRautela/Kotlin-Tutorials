package beginner_kotlin.higher_order_functions

// higher order function — function ko parameter mein leta hai
fun operate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)  // bahar se aayi function ko call karo
}

// click listener pattern — () -> Unit matlab koi param nahi, kuch return nahi
fun button(onClick: () -> Unit) {
    onClick()  // jab button click ho — lambda execute karo
}

fun main() {
    // lambda pass karo — trailing lambda syntax
    println("Add: ${operate(3, 4) { x, y -> x + y }}")         // 7
    println("Subtract: ${operate(3, 4) { x, y -> x - y }}")    // -1
    println("Multiply: ${operate(3, 4) { x, y -> x * y }}")    // 12

    val marks = listOf(10, 20, 30, 40, 50)

    // map — har element transform karo
    println("Doubled: ${marks.map { it * 2 }}")

    // filter — condition pe filter karo
    println("Passing (>=40): ${marks.filter { it >= 40 }}")

    // forEach — sab print karo
    marks.forEachIndexed { index, value -> println("[$index] = $value") }

    // button click listener pattern
    button { println("Button clicked!") }
}
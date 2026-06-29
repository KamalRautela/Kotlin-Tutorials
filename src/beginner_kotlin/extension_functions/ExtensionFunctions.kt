package beginner_kotlin.extension_functions

// Extension functions — existing class mein naya function add karo bina source code badle

fun String.isValidEmail() = contains("@") && contains(".")

fun String.capitalizeWords() = split(" ").joinToString(" ") { word ->
    word.replaceFirstChar { it.uppercase() }
}

fun Int.isEven() = this % 2 == 0

fun List<Int>.mySum(): Int {
    var sum = 0
    for (element in this) sum += element
    return sum
}

fun List<Int>.myAverage() = mySum().toDouble() / size

fun main() {
    // String extensions
    println("kamal@gmail.com".isValidEmail())   // true
    println("kamal@gmail".isValidEmail())        // false

    println("hello world kamal".capitalizeWords())  // Hello World Kamal

    // Int extension
    println(90.isEven())   // true
    println(91.isEven())   // false

    // List extensions
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("Sum: ${list.mySum()}")       // 55
    println("Average: ${list.myAverage()}")  // 5.5
}
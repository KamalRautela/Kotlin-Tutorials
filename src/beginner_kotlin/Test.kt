package beginner_kotlin

fun main() {

    val numbers = listOf(1,2,3,4,5,6,7,8,9,10)

    // map() → transforms each element
    val doubled = numbers.map { it * 2 }
    println(doubled)

    // filter() → selects elements based on condition
    val even = numbers.filter { it % 2 == 0 }
    println(even)

    val odd = numbers.filter { it % 2 == 1 }
    println(odd)

    // forEach() → performs action, returns Unit
    numbers.forEach { print("$it ") }
    println()

    // reduce() → combines elements (no initial value)
    val sum = numbers.reduce { acc, current ->
        acc + current
    }
    println(sum)

    // fold() → like reduce but with initial value
    val sum2 = numbers.fold(10) { acc, number ->
        acc + number
    }
    println(sum2)

    // any() → true if at least one matches
    println(numbers.any { it > 4 })

    // all() → true if all match
    println(numbers.all { it < 0 })

    // none() → true if none match
    println(numbers.none { it < 0 })

    // find() → returns first matching element or null
    val result = numbers.find { it % 2 == 1 }
    println(result)

    // sortedDescending() → returns new sorted list
    val sorted = numbers.sortedDescending()
    println(sorted)
}
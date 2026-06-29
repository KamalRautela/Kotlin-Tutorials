package beginner_kotlin.loops

fun main() {
    val items = listOf("Apple", "Banana", "Mango", "Orange", "Grapes")

    // for loop with index — fixed iterations
    println("--- for loop with index ---")
    for (i in items.indices) {
        println("item[$i] = ${items[i]}")
    }

    // forEachIndexed — idiomatic Kotlin way
    println("--- forEachIndexed ---")
    items.forEachIndexed { index, value ->
        println("item[$index] = $value")
    }

    // while — jab iterations pata nahi, condition pe depend kare
    println("--- while (pehle 3 items) ---")
    var count = 0
    while (count < 3) {
        println("item($count): ${items[count]}")
        count++
    }

    // break — condition pe loop band karo
    println("--- break on Mango ---")
    for (item in items) {
        if (item == "Mango") break
        println(item)
    }

    // continue — item skip karo
    println("--- continue skip Banana ---")
    for (item in items) {
        if (item == "Banana") continue
        println(item)
    }
}
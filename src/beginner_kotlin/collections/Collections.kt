package beginner_kotlin.collections

fun main() {
    // List — immutable
    val students = listOf("Kamal", "Suraj", "Atharv")
    println("Student at 2: ${students.getOrNull(2)}")
    println("Contains Kamal: ${students.contains("Kamal")}")

    // MutableList — add/remove possible
    val people = mutableListOf("Veenu", "Sneha", "Rashi")
    people.add("Rani")
    people.remove("Sneha")
    println("People: $people")

    // Map — immutable key-value
    val studentMap = mapOf(1 to "Kamal", 2 to "Suraj")
    studentMap.forEach { (id, name) -> println("$id: $name") }
    println("Student 2: ${studentMap[2]}")
    println("Has key 4: ${studentMap.containsKey(4)}")

    // MutableMap — put/remove possible
    val foodTaste = mutableMapOf(1 to "Tasty", 2 to "Bitter", 3 to "Sour")
    foodTaste[4] = "Sweet"
    foodTaste.remove(3)
    println("Food: $foodTaste")

    // Set — unique values only
    val cards = setOf(23, 56, 32, 56, 78, 21)  // 56 duplicate — remove hoga
    println("Cards: $cards")
    println("Contains 56: ${cards.contains(56)}")

    // map() — transform
    println("Uppercase: ${people.map { it.uppercase() }}")

    // filter() — condition pe filter
    println("Starts with R: ${people.filter { it.startsWith("R") }}")

    // groupBy() — pehle letter se group
    val allStudents = listOf("Kamal", "Suraj", "Atharv", "Sneha", "Karan")
    println("Grouped: ${allStudents.groupBy { it.first() }}")

    // flatMap() — list of lists → flat list
    val nested = listOf(listOf(1, 2), listOf(3, 4), listOf(5, 6))
    println("FlatMap: ${nested.flatMap { it }}")
}

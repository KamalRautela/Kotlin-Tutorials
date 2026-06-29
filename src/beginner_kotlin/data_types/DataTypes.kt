package beginner_kotlin.data_types

fun main() {
    val id: Int = 4349
    val name: String = "Kamal"
    val isAlive: Boolean = true
    val networth: Double = 50000.39
    val ratio: Float = 0.5f             // f suffix zaroori
    val currentTime: Long = System.currentTimeMillis()
    val characterCode: Char = 'K'

    // Any — koi bhi type ho sakta hai, smart cast se safely use karo
    val anything: Any = "I can be anything"
    if (anything is String) {
        println("Length: ${anything.length}")  // smart cast — compiler jaanta hai String hai
    }

    println(
        "Id : $id\n" +
        "Name : $name\n" +
        "IsAlive : $isAlive\n" +
        "Networth : $networth\n" +
        "Ratio : $ratio\n" +
        "Current Time : $currentTime\n" +
        "CharacterCode : $characterCode"
    )
}

// Nothing — function jo kabhi return nahi karta
fun throwError(): Nothing {
    throw IllegalStateException("Fatal error")
}
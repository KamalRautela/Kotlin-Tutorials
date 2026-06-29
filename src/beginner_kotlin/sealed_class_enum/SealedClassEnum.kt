package beginner_kotlin.sealed_class_enum

// sealed class — har subclass ki alag structure ho sakti hai
sealed class Result {
    object Loading : Result()                        // koi data nahi
    data class Success(val data: String) : Result()  // String data
    data class Error(val message: String) : Result() // String message
}

// enum — har constant same structure hoti hai
enum class Direction(val label: String) {
    NORTH("north"),
    SOUTH("south"),
    EAST("east"),
    WEST("west")
}

fun main() {
    // sealed class — when exhaustive (else ki zaroorat nahi)
    val status: Result = Result.Success("Kamal")
    when (status) {
        is Result.Loading -> println("Loading...")
        is Result.Success -> println("Success: ${status.data}")
        is Result.Error -> println("Error: ${status.message}")
    }

    // enum — label property use karo
    val direction = Direction.EAST
    when (direction) {
        Direction.NORTH -> println("Going: ${direction.label}")
        Direction.SOUTH -> println("Going: ${direction.label}")
        Direction.EAST -> println("Going: ${direction.label}")
        Direction.WEST -> println("Going: ${direction.label}")
    }
}
package kotlinBasics

fun main() {
    val isRaining = true          // Boolean variable to track if it's raining

    // Simple if-else statement for decision making
    if (isRaining) {
        println("Take your umbrella")  // Executed if condition true
    } else {
        println("Enjoy")                // Executed if condition false
    }

    // Kotlin if expression - use like ternary operator to assign values based on condition
    val result = if (isRaining) "Even" else "No"
    print(result)   // Prints "Even" if isRaining true, else "No"
}

/*
Android context me:
- Conditions use karte hain user interactions aur UI updates control karne ke liye.
- 'if' blocks se code simple aur samajhne me aasan hota hai.
- 'if' expression se concise value assignment hota hai, readability improve hoti hai.
*/

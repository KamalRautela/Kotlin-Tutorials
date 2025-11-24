package kotlinBasics

fun main() {
    val animal = "Dog"
    val number = 13

    // 'when' statement: different blocks run based on the value of animal
    when(animal) {
        "Horse" -> println("Horse found")
        "Cat" -> println("Cat found")
        "Rat" -> println("Rat found")
        else -> println("Animal not found")   // Default case if no match
    }

    // 'when' expression: result ko variable me assign karna
    val result = when(animal) {
        "Horse" -> "Horse found"
        "Cat" -> "Cat found"
        "Rat" -> "Rat found"
        else -> "Animal not found"
    }

    // 'when' expression with ranges and direct values
    val result2 = when(number) {
        10 -> "Ten"
        11 -> "Eleven"
        in 13..19 -> "Teen"         // Range check using 'in'
        else -> "Not in Range"
    }

    println(result)     // Output depends on animal value
    println(result2)    // Output based on number value
}

/*
Android context me 'when':
- Multiple condition check ko concise aur efficient tarikay se likhne ke liye best.
- UI state update, user input validation, aur event handling me extensively use hota hai.
- 'else' block necessary hai taaki unexpected values ke liye fallback handling ho.
- 'in' operator ke saath range check Android ke input validation me common hai.
*/

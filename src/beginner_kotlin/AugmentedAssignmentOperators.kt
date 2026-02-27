package beginner_kotlin

/**
 * Demonstrating Variable mutation and Shorthand Operators.
 * Also called Compound Assignment Operators
 */
fun main() {
    var customer = 10

    // Reassignment
    customer = 9

    // Traditional Assignment
    customer = customer + 3

    /**
     * Augmented Assignment Operators:
     * Shorthand for performing an operation and assigning the result back.
     */
    customer += 2 // customer = customer + 2
    customer -= 2 // customer = customer - 2
    customer *= 2 // customer = customer * 2
    customer /= 2 // customer = customer / 2

    print(customer) // Result: 12
}
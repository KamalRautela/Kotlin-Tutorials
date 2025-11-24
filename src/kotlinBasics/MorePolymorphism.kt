open class Food() {
    // Base implementation, can be overridden
    open fun printFood(): String {
        return "No item"
    }

    // Custom base string representation (useful in logs/debug)
    override fun toString(): String {
        return " - I am Food"
    }
}

class Burger(val item: String) : Food() {
    // Override for specific item name
    override fun printFood(): String {
        return item
    }
}

class Momo(val item: String) : Food() {
    // Override for specific item name
    override fun printFood(): String {
        return item
    }
}

// Polymorphic function: can accept any Food or its subclass
fun foodName(food: Food) {
    print(food.printFood())           // Runtime pe actual child version run hota hai
}

fun main() {
    val food = Food()
    val food1 = Burger("bun")
    val food2 = Momo("maida")

    foodName(food1)                  // Output: bun (child class method via parent reference)
    println(food1.toString())        // Output:  - I am Food
}

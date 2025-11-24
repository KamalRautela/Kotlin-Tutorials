// Abstract base class. Child ko name() implement karna compulsory hai.
abstract class Bird {
    abstract fun name(): String
}

// Child class Sparrow - must implement name()
class Sparrow : Bird() {
    override fun name(): String {
        return "Sparrow"
    }
}

fun main() {
    val bird1: Bird = Sparrow()     // Reference via abstract type
    print(bird1.name())             // Output: Sparrow
}

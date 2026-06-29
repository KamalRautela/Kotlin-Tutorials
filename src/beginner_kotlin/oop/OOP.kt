package beginner_kotlin.oop

// Inheritance — open class extend ho sakti hai
open class Animal(val name: String) {
    open fun sound() {
        println("$name makes a sound")
    }
}

// Interface — contract, multiple implement kar sakte ho
interface Trainable {
    fun train()                          // abstract — override zaroori
    fun rest() = println("resting") // default implementation — override optional
}

// Abstract class — abstract + concrete methods, sirf ek extend
abstract class Shape {
    abstract fun area(): Double          // override zaroori
    fun describe() = println("I am a shape")  // concrete — shared logic
}

// Dog — Animal extend + Trainable implement (multiple)
class Dog(name: String) : Animal(name), Trainable {
    override fun sound() = println("$name: Woof woof!")
    override fun train() = println("$name is training")
}

// Cat — sirf Animal extend
class Cat(name: String) : Animal(name) {
    override fun sound() = println("$name: Meow!")
}

// Circle — Shape extend, area() implement
class Circle(val radius: Double) : Shape() {
    override fun area() = Math.PI * radius * radius
}

fun main() {
    val dog = Dog("Tommy")
    dog.sound()   // Woof woof!
    dog.train()   // Tommy is training

    val cat = Cat("Claire")
    cat.sound()   // Meow!

    val circle = Circle(5.0)
    println("Circle area: ${circle.area()}")  // 78.53...
    circle.describe()  // concrete method from Shape
}
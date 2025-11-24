open class Shape() {
    // Default area calculation: subclasses should override
    open fun area(): Double {
        return 0.0
    }
}

class Circle(val radius: Double) : Shape() {
    // Override parent area() with Circle logic
    override fun area(): Double {
        return Math.PI * radius * radius
    }
}

class Square(val side: Double) : Shape() {
    // Override parent area() with Square logic
    override fun area(): Double {
        return side * side
    }
}

class Oval(val side: Double) : Shape() {
    // No override: area() returns 0.0 by default
}

fun calcualate(shapes: Array<Shape>) {
    for (shape in shapes) {
        // Polymorphism: actual shape's area() called here!
        println(shape.area())
    }
}

fun main() {
    val circle: Shape = Circle(4.0)        // Polymorphic reference
    val square = Square(4.0)
    val oval = Oval(4.0)

    val shapes = arrayOf(Circle(4.4), Square(3.0))

    println(circle.area())                  // Output: Circle area
    println(square.area())                  // Output: Square area
    println(oval.area())                    // Output: 0.0 (no override in Oval)
    calcualate(shapes)                      // Output: Each shape's area
}

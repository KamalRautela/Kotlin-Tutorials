// Interface for a contract: whoever implements must provide getFlowerName()
interface Draggable {
    fun getFlowerName() : String
}

// Abstract class providing common base for flowers
abstract class Flower : Draggable

// Various flowers implementing getFlowerName()
class Rose(val name: String) : Flower() {
    override fun getFlowerName() = name
}
class Jasmine(val name: String) : Flower() {
    override fun getFlowerName() = name
}
class Lily(val name: String) : Flower() {
    override fun getFlowerName() = name
}

// Plant is not a Flower but is Draggable (type flexibility)
class Plant(val name: String) : Draggable {
    override fun getFlowerName() = name
}

// Function that accepts anything Draggable (works for both flowers and plants here)
fun getName(objects: Array<Draggable>) {
    for (obj in objects ) {
        println(obj.getFlowerName())
    }
}

fun main() {
    getName(arrayOf(Rose("rose"), Jasmine("jasmine"), Lily("lily"), Plant("Tomato")))
}

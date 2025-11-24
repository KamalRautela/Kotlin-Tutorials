// Interface defines contract for cloning
interface Cloneable {
    fun clone()
}

// Abstract class, cloneable implement karte hue
abstract class A : Cloneable

// Child classes
class B(val name: String) : A() {
    override fun clone() { println("Class B") }
}

class C(val name: String) : A() {
    override fun clone() { println("Class C") }
    fun getName() = println(name)
}

class D(val name: String) : Cloneable {
    override fun clone() { println("Class D") }
}

fun main() {
    val b = B("K")
    val c = C("A")
    val d = D("M")

    // Type check: b is D? (No)
    if (b is D) {
        println("Yes")
    }

    // Array of mixed types
    val arr = arrayOf(c, d)
    for (obj in arr) {
        if (obj is C) {
            obj.getName()         // Checks if obj is C, then prints its name
        } else {
            (obj as D).clone()    // Otherwise cast to D and call clone()
        }
    }
}

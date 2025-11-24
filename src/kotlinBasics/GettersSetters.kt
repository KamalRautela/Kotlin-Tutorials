package kotlinBasics

import java.util.Locale
import java.util.Locale.getDefault

fun main() {
    val p1 = Persona("Kamal",27)
    println(p1.age)
    p1.age = 25
    p1.age = -15
    println(p1.name)
}

class Calculator() {
    lateinit var message: String
    fun add(a: Int, b: Int): Int {
        return a+b
    }
}

class Persona(nameParam: String, ageParam: Int) {
    // Custom getter: har access pe name uppercase ho diya jayega
    var name = nameParam
        get() = field.uppercase(getDefault())

    // Custom setter: age sirf tabhi set hogi jab >0 hoga, warna warning print hogi
    var age = ageParam
        set(value) = if (value > 0) field = value else println("Age can't be negative")
}

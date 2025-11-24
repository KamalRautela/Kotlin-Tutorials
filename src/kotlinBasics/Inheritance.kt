// Parent class (open se inheritance allow hota hai)
open class Phone() {
    init {
        println("Phone constructor")                    // Pehle run hoga
    }
    val name: String = ""
    val type: String = ""
    fun hasButton() = print("No")
}

// Child class, basic phone ko model karta hai
class BasicPhone() : Phone() {
    init {
        println("BasicPhone constructor")               // Doosre number pe run hoga
    }
    fun makeCall() {}
}

// Child class, smart phone ko model karta hai
class SmartPhone() : Phone() {
    fun clickPicture() {}
}

fun main() {
    val phone1 = BasicPhone()     // Output: Phone constructor   BasicPhone constructor
    phone1.hasButton()            // Output: No

    //val phone2 = SmartPhone()   // Uncomment karoge to: Phone constructor
    //phone2.clickPicture()       // Derived ki custom method
}

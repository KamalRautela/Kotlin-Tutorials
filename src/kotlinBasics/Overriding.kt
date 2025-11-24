open class Mobile(val type: String) {
    open val name: String = ""
    open val size: Int = 5
    open fun makeCall() = println("Calling")                   // Base calling message
    open fun display() = println("Simple mobile Display")      // Base display method
}

class Oneplus(typeParam: String) : Mobile(typeParam) {
    override val name: String = typeParam                      // Unique name for Oneplus
    override val size: Int = 27                                // Custom property value

    override fun makeCall() = println("One plus calling")      // Custom calling message

    override fun display() {
        super.display()                                        // Call parent display first
        println("Oneplus Display")                             // Then child display
    }

    override fun toString(): String {
        return "$name and $size"                               // Custom string output
    }
}

fun main() {
    val oneplus = Oneplus("Smartphone")
    oneplus.makeCall()         // Specific message
    oneplus.display()          // Parent + child output
    println(oneplus.toString())// Unique representation

    val generalMobile = Mobile("General")
    generalMobile.makeCall()   // Parent method
}

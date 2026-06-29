package beginner_kotlin.delegation

import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// 1. Interface
interface Printer {
    fun print(message: String)
}

// 2. ConsolePrinter — actual implementation
class ConsolePrinter : Printer {
    override fun print(message: String) = println("Console: $message")
}

// 3. SmartPrinter — by delegation, ConsolePrinter ko kaam delegate karo
class SmartPrinter(printer: Printer) : Printer by printer
// SmartPrinter khud kuch nahi karta — printer ko delegate karta hai

// 4. Property delegation — observable — value change hone pe log karo
class User {
    var name: String by Delegates.observable("Unknown") { _, old, new ->
        println("Name changed: $old → $new")
    }
}

// 5. Map delegation — map se properties read karo
class Config(map: Map<String, Any>) {
    val appName: String by map
    val version: String by map
}

fun main() {
    // Class delegation
    val consolePrinter = ConsolePrinter()
    val smartPrinter = SmartPrinter(consolePrinter)
    smartPrinter.print("Hello!")  // ConsolePrinter ka print() chalega

    // Observable delegation
    val user = User()
    user.name = "Kamal"   // "Name changed: Unknown → Kamal"
    user.name = "Rautela" // "Name changed: Kamal → Rautela"

    // Map delegation
    val config = Config(mapOf("appName" to "MyApp", "version" to "1.0.0"))
    println("App: ${config.appName}, Version: ${config.version}")
}

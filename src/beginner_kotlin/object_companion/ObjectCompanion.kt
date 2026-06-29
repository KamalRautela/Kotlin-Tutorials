package beginner_kotlin.object_companion

// object — independent Singleton, ek hi instance, directly access
object AppConfig {
    const val appName = "MyApp"
    const val version = "1.0.0"

    fun printInfo() {
        println("App: $appName | Version: $version")
    }
}

// companion object — class ka static part, class name se access
class Database {
    companion object {
        const val MAX_CONNECTIONS = 10

        // factory method — constructor ki jagah object banana
        fun create() = Database()
    }
}

fun main() {
    // object — directly access, koi instance nahi
    AppConfig.printInfo()

    // companion object — class name se access
    val db = Database.create()
    println("Max connections: ${Database.MAX_CONNECTIONS}")

    // object expression — anonymous object, ek jagah use ke liye
    val runnable = object : Runnable {
        override fun run() = println("Running anonymously!")
    }
    runnable.run()
}

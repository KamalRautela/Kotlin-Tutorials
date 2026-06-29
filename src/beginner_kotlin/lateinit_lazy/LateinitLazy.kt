package beginner_kotlin.lateinit_lazy

// lateinit — var, non-null, baad mein initialize karenge (jaise Activity mein onCreate)
// lazy — val, pehli baar access hone pe initialize hota hai

lateinit var name: String

// by lazy — sirf tab initialize hoga jab pehli baar use hoga
val heavyObject: String by lazy {
    println("heavyObject initialized!")
    "Heavy Data Loaded"
}

fun main() {
    // isInitialized — use karne se pehle check karo
    if (::name.isInitialized) {
        println("Name: $name")
    } else {
        println("name not initialized yet")
    }

    // initialize karo
    name = "Kamal"
    println("Name: $name")

    // by lazy — pehli baar access pe initialize hoga
    println("Before accessing heavyObject")
    println(heavyObject)  // "heavyObject initialized!" phir "Heavy Data Loaded"
    println(heavyObject)  // dobara initialize nahi hoga — cached hai
}

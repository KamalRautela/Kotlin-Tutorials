package kotlinBasics

fun main() {
    // Container class ka ek object jisme Int value store hai (3)
    val obj = Container(3)
    println(obj.getValue())   // Output: 3

    // Explicit type declaration: Container<Int> banaya
    val obj2 = Container<Int>(4)
    obj2.setValue(4)          // Value 4 set kar di

    // Variadic function call: multiple Int values pass kiye
    add(1, 4, 5, 32)         // Sum karega aur print nahi karta (function me print nahi hai)
}

// Int variable arguments wale function: kitne bhi Int pass kar sakte ho
fun add(vararg values: Int) {
    var sum = 0
    // Har value ko loop me add karte jao
    for (i in values) {
        sum += i
    }
    // Agar chaho to print/additional logic bhi kar sakte ho
}

// Generic class: data ka type kisi bhi type ka ho sakta hai (String, Int, Custom object)
class Container<T>(var data: T) {
    // Data ko set karne wala function
    fun setValue(value: T) {
        data = value
    }

    // Data ko get karne wala function
    fun getValue(): T {
        return data
    }
}

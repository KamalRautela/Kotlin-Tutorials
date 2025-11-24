package kotlinBasics

fun main() {
    // Static array, elements fix hain
    val num1 = arrayOf(1,5,8)

    // Immutable list (iska data change nahi kar sakte, new value assign nahi kar sakte)
    var num2 = listOf<Int>(1,5,6)
    println(num2.indexOf(6))       // 6 kis position par hai (output: 2)
    println(num2.contains(5))      // 5 present hai ya nahi (output: true)

    // Mutable list (iska data change kar sakte ho)
    var num3 = mutableListOf<Int>(1,5,2)
    num3.add(3,5)                  // index 3 par value 5 add karo (output: [1,5,2,5])
    num3.remove(5)                 // pehli 5 ko remove karo (output: [1,2,5])
    println(num3)

    num3.addAll(num2)              // Immutable list ke saare values mutable list me daal do
    println(num3)                  // All values show honge

    // Map ka use—key value pair store karne ke liye
    val num4 = mutableMapOf<Int, String>()
    num4[1] = "Kamal"              // key 1 ka value Kamal
    num4[2] = "Anil"               // key 2 ka value Anil
    num4[3] = "Sima"               // key 3 ka value Sima

    println(num4.get(3))           // key 3 ka value kya hai (output: Sima)

    // Map ki saari keys aur values print karne ke liye loop
    for ((key, value) in num4) {
        println("$key - $value")   // key aur value dono print karo
    }

    // Immutable map (change nahi kar sakte, bas read kar sakte ho)
    val num5 = mapOf<Int, String>(1 to "Hello", 2 to "World")
    println(num5)                  // Saara map print karo (output: {1=Hello, 2=World})
}

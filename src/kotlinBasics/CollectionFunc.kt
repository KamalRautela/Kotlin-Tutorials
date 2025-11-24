package kotlinBasics

fun main() {
    // Ek simple list of Integers
    val num1 = listOf<Int>(1, 3, 4, 5)

    println(isOdd(4))           // Function call, output: false (kyunki 4 odd nahi hai)

    // List ke andar se sirf odd numbers nikalne ke liye filter
    val num2 = num1.filter(::isOdd)              // Function reference se
    val num3 = num1.filter { it % 2 != 0 }       // Lambda se (it har item ko refer karta hai)

    println(num2)          // Output: [1, 3, 5]
    // num3 bhi same output dega

    // Ek model class list banaya
    val userList = listOf<User>(User(1,"Kamal"),User(2,"Kamak"))

    // List me se sirf id==1 wala user dhoonda
    println(userList.filter { it.id == 1 })      // Output: [User(id=1, name=Kamal)]

    // Map operator — list ke har element pe operation (yahan square karna)
    val num4 = num1.map { it * it }
    println(num4)           // Output: [1, 9, 16, 25]

    // List of User ko list of PaidUser me convert karna using map
    val paidUserList = userList.map { PaidUser(it.id, it.name, "Random") }
    println(paidUserList)
    // Output: [PaidUser(id=1, name=Kamal, type=Random), PaidUser(id=2, name=Kamak, type=Random)]

    // List ke sab elements ko print karne ke liye forEach
    paidUserList.forEach { println(it) }
}

// Odd number check karne ke liye function (1, 3, 5 ke liye true, baaki ke liye false)
fun isOdd(x: Int): Boolean {
    return (x % 2) != 0
}

// User aur PaidUser models, asaan debug ke liye data class (yeh auto toString, equals, copy provide karta hai)
data class User(val id: Int, val name: String)
data class PaidUser(val id: Int, val name: String, val type: String)

package kotlinBasics

fun main() {
    var count = 5

    // While loop: Jab tak condition true hai, loop chalta rahega
    while (count >= 1) {
        println("Hi")   // Print "Hi"
        count--         // count ko 1 se kam kar do har baar
    }

    var number = 2
    var index = 1

    // Dusra while loop: Multiplication table print kar raha hai 2 ki
    while (index <= 10) {
        println(number * index)  // 2 times index
        index++                  // index ko 1 se badhao
    }

    var i = 10

    // Do-while loop: Body pehle execute hoti hai, phir condition check hoti hai
    do {
        i--
        println("Kamal")      // Har iteration me "Kamal" print karo
    } while (i > 1)            // Jab tak i 1 se bada hai
}

/*
Android me:
- Loops bohot important hain repetitive tasks ke liye.
- While loop condition check karke chalta hai, jab tak true hota hai.
- Do-while ensure karta hai ki kam se kam ek baar code execute ho.
- RecyclerView me ya data processing me loops common hain.
*/

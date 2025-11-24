package kotlinBasics

fun main() {
    // Extension function ka use: "Kamal".formattedString() se custom message ban raha hai
    print("Kamal".formattedString())          // Output: ----------------Kamal--------------

    // Time calculation ke liye inline higher-order function use ho raha hai
    calculateTime { loop(100000) }            // Ye check karega ki loop(100000) kitna time leta hai
}

// Extension function: String me new function add kiya (formatted output)
fun String.formattedString(): String {
    return "----------------$this--------------"    // Original string ke ird-gird hyphens laga diye
}

// Normal loop function: 1 se n (yahan 100000) tak kuch nahi karta, bas loop chalta hai
fun loop(n: Long) {
    for (i in 1..n) {
        // Ye as a time-consuming dummy operation hai, kuch nahi karti really
    }
}

// Inline higher-order function: kisi bhi function block ka execution time calculate karta hai
inline fun calculateTime(fn: () -> Unit) {
    val start = System.currentTimeMillis()   // Start time save karo
    fn()                                    // Ye function jo pass hua hai run karo
    val end = System.currentTimeMillis()     // End time save karo
    print("Time Taken ${end - start} ms")    // Total time difference print karo
}

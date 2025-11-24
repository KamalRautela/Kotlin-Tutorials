package kotlinBasics

fun main() {
    // Simple for loop: 1 se 5 tak numbers ko print karna inclusive
    for (i in 1..5) {
        print(" $i")
    }
    println()

    // Step ke sath loop: 1 se 10 tak, step 2 par print (odd numbers)
    for (j in 1..10 step 2) {
        print(" $j")
    }
    println()

    // until: 1 se 10 tak exclusive (1 se 9 tak)
    for (k in 1 until 10) {
        print(" $k")
    }
    println()

    // Reverse loop using downTo:
    for (l in 10 downTo 1) {
        print(" $l")
    }
    println()

    // Multiplication table for number 2 from 1 to 10
    val number = 2
    for (i in 1..10) {
        println("$number * $i = ${number * i}")
    }
}

/*
Android me:
- For loops list processing me bohot common hain, jaise UI list rendering (RecyclerView).
- Range expressions concise code likhne me madad karte hain.
- Step aur downTo control flow me flexibility dete hain.
- Multiplication table jaise calculations UI me ya business logic me kaam aate hain.
*/

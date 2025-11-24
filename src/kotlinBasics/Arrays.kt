package kotlinBasics

fun main() {
    // Array creation: String, Int, Double types
    val arr = arrayOf("One", "Two")        // String array
    val arr1 = arrayOf(1, 3, 2, 8, 3, 6, 3)   // Int array
    val arr2 = arrayOf(1.3, 4.5)           // Double array

    // Traverse array with index and value
    for ((i, e) in arr.withIndex()) {
        println("$i $e")      // Prints index and value
    }

    // Access first element
    println(arr1[0])          // arr1 ka first element: 1

    // Access 4th element (index 3)
    println(arr1.get(3))      // Prints 8

    // Modify 4th element (index 3) to 10
    arr1.set(3, 10)
    println(arr1[3])          // Now prints 10

    // Print array size (total elements)
    print(arr1.size)          // Prints 7
}

/*
Android context me:
- Arrays UI data sources (like RecyclerView.Adapter), input handling, aur temporary data storage ke liye use hote hain.
- Index-based operations data ko manage karna easy banate hain.
- Size ya length calculation UI pagination, data sync aur loop controls me helpful hai.
*/

package beginner_kotlin

/**
 * Data Types in Kotlin:
 * Kotlin categorizes data types based on memory size and usage.
 * All data types in Kotlin are objects (no true primitives),
 * but they are optimized at compile time by the JVM.
 */
fun main() {

    // [1] INTEGER CATEGORY: Signed integers (Can store positive and negative values)
    val a: Byte = 1              // 8-bit → Range: -128 to 127
    val b: Short = 2             // 16-bit → Range: -32,768 to 32,767
    val c: Int = 3               // 32-bit → Default integer type
    val d: Long = 5_000_000_000L // 64-bit → 'L' suffix required, '_' improves readability

    // [2] UNSIGNED INTEGERS: Store only non-negative values (0 and positive)
    // Suffix 'u' or 'uL' is mandatory
    val e: UByte = 1u
    val f: UShort = 2u
    val g: UInt = 3u
    val h: ULong = 5_000_000uL

    // [3] FLOATING POINT TYPES: Used for decimal values
    val i: Float = 20.7f         // 32-bit → 'f' or 'F' suffix required
    val j: Double = 40.234       // 64-bit → Default decimal type (higher precision)

    // [4] CHARACTERS & STRINGS
    val k: Char = 'a'            // Single character → Single quotes
    val l: String = "Hello"      // Sequence of characters → Double quotes

    // [5] ANY TYPE
    // Any is the root class (super type) of all Kotlin types.
    // It can hold a value of any non-nullable type.
    var m: Any = 10

    m = "Amit"
    m = 12.49

    // You cannot directly access properties like m.length
    // because the compiler does not know the actual type at compile time.
    // Smart casting example:
    /*
    if (m is String) {
        println(m.length)
    }
    */

    // [6] NOTHING TYPE
    // Nothing represents a value that never exists.
    // It is a subtype of all types.
    // You cannot declare a variable of type Nothing directly.
    // It is mainly used in functions that never return (e.g., exceptions).

    // val n: Nothing  ❌ Invalid

    // [7] ARRAYS
    val o = arrayOf(1, 2, 3, 4, 5)         // Array<Int> (Boxed integers)
    val p = intArrayOf(1, 2, 3, 4, 5)      // IntArray (Primitive optimized)
    val q = charArrayOf('a', 'b', 'c', 'd', 'e') // CharArray
    val r = arrayOf("Hello", "World")      // Array<String>

    // Print the data type using reflection
    print(k::class.simpleName)  // Output: Char
}
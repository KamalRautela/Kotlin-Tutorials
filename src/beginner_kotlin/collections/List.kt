package beginner_kotlin.collections

/**
 * Demonstrates the use of Kotlin Collections (List and MutableList).
 *
 * Collections allow developers to group data for efficient access,
 * searching, iteration, and modification.
 */
fun main(args: Array<String>) {

    /**
     * [List] → Immutable (read-only) collection.
     * - Maintains insertion order.
     * - Allows duplicate elements.
     * - Cannot be structurally modified (no add/remove).
     */
    val shapes = listOf("circle", "rectangle", "triangle", "oval")

    /**
     * [MutableList] → Mutable collection.
     * - Can be modified at runtime.
     * - Supports add, remove, update operations.
     */
    val names: MutableList<String> = mutableListOf("Kamal", "Anuj", "Neeraj")

    /**
     * Read-Only View Pattern (Common in MVVM Architecture).
     *
     * _numbers → Private mutable source.
     * numbers  → Public read-only reference.
     *
     * This ensures encapsulation and prevents external modification.
     */
    val _numbers: MutableList<Int> = mutableListOf(12, 29, 18, 10)
    val numbers: List<Int> = _numbers

    // Modification happens only through the mutable reference
    _numbers.add(34)

    // Accessing elements (0-based indexing)
    println(numbers[2])   // Output: 18

    /**
     * Useful Extension Functions:
     * - first()  → Returns first element
     * - last()   → Returns last element
     * - count()  → Returns total number of elements
     */
    println(shapes.first())
    println(shapes.last())
    println(numbers.count())

    /**
     * 'in' Operator → Checks element existence (calls contains() internally)
     */
    println(12 in numbers)

    /**
     * MutableList Operations:
     * - add(element)
     * - remove(element) → Removes first matching element
     * - removeAt(index)
     */
    val fruits = mutableListOf("Apple", "Banana", "Pear")

    fruits.add("Mango")        // Adds to end
    fruits.add(fruits[0])      // Adds duplicate element
    fruits.remove("Apple")     // Removes first occurrence
    fruits.removeAt(2)         // Removes element at index 2

    println(fruits)
}
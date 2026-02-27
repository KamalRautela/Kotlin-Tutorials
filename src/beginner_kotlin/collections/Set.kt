package beginner_kotlin.collections

/**
 * Demonstrates the usage of Immutable and Mutable Sets in Kotlin.
 * * Key characteristics showcased:
 * - Unordered nature of elements.
 * - Requirement for unique elements (duplicates are ignored).
 * - Difference between read-only [Set] and [MutableSet].
 */
fun main(args: Array<String>) {
    /** * A read-only [Set] of fruits.
     * Once initialized, you cannot add or remove items.
     */
    val fruits = setOf("Apple", "Banana", "Pear")

    /** * A [MutableSet] of flowers.
     * This collection allows structural modifications like adding or removing elements.
     */
    val flowers = mutableSetOf("Apple", "Banana", "Pear")

    /**
     * Demonstrates the uniqueness property of a Set.
     * Even though "bajaj" is added twice, the Set will only store it once.
     */
    val bikes = mutableSetOf("bajaj", "tvs", "pulsar", "hero", "bajaj")
    print(bikes) // Output: [bajaj, tvs, pulsar, hero]

    /**
     * Demonstrates "Backing Properties" or Type Casting.
     * [_cars] is a mutable reference, while [cars] is a read-only view
     * pointing to the same data.
     */
    val _cars = mutableSetOf<String>("ferrari", "scorpio", "xuv", "sedan")
    val cars: Set<String> = _cars
}
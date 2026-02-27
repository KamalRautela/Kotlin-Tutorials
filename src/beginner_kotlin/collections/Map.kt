package beginner_kotlin.collections

/**
 * Demonstrates the functionality of Kotlin [Map] and [MutableMap].
 *
 * Key Characteristics:
 * - Stores data as key-value pairs.
 * - Keys must be unique (duplicate keys overwrite previous values).
 * - Values can be duplicated.
 * - Fast lookup based on keys.
 */
fun main(args: Array<String>) {

    /**
     * [MutableMap] → Allows adding, updating, and removing entries.
     * Use this when data needs to change at runtime.
     */
    val fruitPrices = mutableMapOf(
        "Apples" to 100,
        "Mangoes" to 120
    )

    // Updating value (same key overwrites old value)
    fruitPrices["Apples"] = 150

    /**
     * Backing Property Pattern:
     * _countryCapitals → Internal mutable source
     * countryCapitals  → Public read-only view
     */
    val _countryCapitals = mutableMapOf(
        "India" to "Delhi",
        "USA" to "Washington DC",
        "United Kingdom" to "London"
    )

    val countryCapitals: Map<String, String> = _countryCapitals

    // Accessing an existing key
    println(countryCapitals["India"])   // Output: Delhi

    // Accessing a non-existing key returns null
    println(countryCapitals["China"])   // Output: null

    // Check if a key exists
    println(countryCapitals.containsKey("USA"))  // true

    // Check if a value exists
    println(countryCapitals.containsValue("London"))  // true
}
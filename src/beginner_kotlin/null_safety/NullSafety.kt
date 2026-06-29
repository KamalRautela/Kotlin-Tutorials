package beginner_kotlin.null_safety

fun main() {
    val name: String? = "Kamal"
    val bio: String? = null       // user ne bio nahi bhara
    val phoneNumber: Long? = null // user ne phone nahi bhara

    // ?. — safe call — null hone pe null return karta hai, crash nahi
    val bioLength = bio?.length
    println("Bio Length: $bioLength")   // null

    // ?: — Elvis — null hone pe default value
    val userNumber = phoneNumber ?: "Not Provided"
    println("Phone: $userNumber")       // Not Provided

    // !! — force — null hone pe NullPointerException crash
    // sirf tab use karo jab 100% sure ho ki null nahi hai
    println("Name: ${name!!}")

    // !! risky example
    val city: String? = null
    // println(city!!)  // ❌ NullPointerException — production mein avoid karo
}
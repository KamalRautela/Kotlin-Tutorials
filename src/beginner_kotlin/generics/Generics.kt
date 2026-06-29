package beginner_kotlin.generics

class Box<T>(val value: T)

fun <T> printItem(item: T) = println(item)

sealed class Resource<T> {
    object Loading : Resource<Nothing>()
    data class Success<T>(val data: T) : Resource<T>()
    data class Failure<T>(val message: String?) : Resource<T>()
}

fun main() {
    // Box — same class, alag types
    val box1 = Box<Int>(3)
    val box2 = Box<String>("Kamal")
    println("Box1: ${box1.value}")
    println("Box2: ${box2.value}")

    // printItem — generic function
    printItem("Hello")
    printItem(42)

    // Resource<String>
    val stringResult: Resource<String> = Resource.Success("Kamal")
    when (stringResult) {
        is Resource.Loading -> println("Loading...")
        is Resource.Success -> println("Success: ${stringResult.data}")
        is Resource.Failure -> println("Failure: ${stringResult.message}")
    }

    // Resource<Int>
    val stringFailure: Resource<String> = Resource.Failure("Error")
    when (stringFailure) {
        is Resource.Loading -> println("Loading...")
        is Resource.Success -> println("Success: ${stringFailure.data}")
        is Resource.Failure -> println("Failure: ${stringFailure.message}")
    }

    // Resource<Int>
    val intResult: Resource<Int> = Resource.Success(42)
    when (intResult) {
        is Resource.Loading -> println("Loading...")
        is Resource.Success -> println("Success: ${intResult.data}")
        is Resource.Failure -> println("Failure: ${intResult.message}")
    }
}

package beginner_kotlin.coroutines

import kotlinx.coroutines.*

// suspend functions — network call simulate
suspend fun fetchUser(): String {
    delay(1000)  // 1 second delay — network call simulate
    return "Kamal"
}

suspend fun fetchPosts(): String {
    delay(1500)  // 1.5 second delay
    return "Post 1, Post 2, Post 3"
}

fun main() = runBlocking {

    // launch — fire and forget
    val job = launch {
        println("Fetching user...")
        val user = fetchUser()
        println("User: $user")
    }
    job.join()  // launch complete hone tak wait karo

    // async/await — parallel calls, dono saath chalein
    println("\nFetching in parallel...")
    val userDeferred = async { fetchUser() }
    val postsDeferred = async { fetchPosts() }
    println("User: ${userDeferred.await()}")
    println("Posts: ${postsDeferred.await()}")

    // withContext — IO thread pe kaam karo
    val result = withContext(Dispatchers.IO) {
        delay(500)
        "Data from IO thread"
    }
    println("\nwithContext result: $result")
}

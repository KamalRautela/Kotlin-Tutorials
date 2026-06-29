# Control Flow in Kotlin

## if/else vs when — Kab Kya Use Karein

| Situation | Use Karein |
|---|---|
| Simple ek condition | Direct return ya `if/else` |
| Multiple cases check karne ho | `when` |
| Enum/Sealed class handle karna ho | `when` — compiler sab cases ensure karta hai |

---

## if/else — Expression Hai Kotlin Mein

```kotlin
// Java style — verbose
if (status.isNullOrEmpty() || status == "0") {
    return true
} else {
    return false
}

// Kotlin style — clean
return status.isNullOrEmpty() || status == "0"
```

---

## when — Multiple Cases

```kotlin
// DKScore pattern — Status handle karna
sealed class Status {
    object Loading : Status()
    data class Success(val data: String, val code: Int) : Status()
    data class Failure(val message: String, val code: Int) : Status()
}

when(status) {
    is Status.Loading -> println("Loading")
    is Status.Success -> println("Success: ${status.data}")
    is Status.Failure -> println("Error: ${status.message}")
    // else nahi likha — compiler ensure karta hai sab cases handle hon
}
```

## when — Value Assign Karna

```kotlin
val message = when(status) {
    is Status.Loading -> "Loading..."
    is Status.Success -> "Data loaded"
    is Status.Failure -> "Something went wrong"
}
```

---

## Key Points

1. **`when` exhaustive hota hai** sealed class ke saath — koi case miss nahi ho sakta
2. **`when` expression bhi hai** — value return kar sakta hai
3. **`else` zaruri nahi** sealed class ke saath — but enum ke saath zaruri hai agar sab cases cover na ho
4. **`if/else` bhi expression hai** Kotlin mein — Java se alag

---

## Interview Mein Bolna
> *"`when` use karta hoon jab multiple cases handle karne ho — especially sealed class ya enum ke saath. Compiler ensure karta hai ki sab cases cover hon, isliye `if-else if` chain se better hai."*

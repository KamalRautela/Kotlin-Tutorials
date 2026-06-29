# Sealed Class vs Enum in Kotlin

## Kab Kaunsa Use Karein

| Situation | Use Karein |
|---|---|
| Sab values same structure — sirf naam alag | `enum` |
| Har value alag data rakh sakti ho | `sealed class` |

---

## Enum — Same Structure

```kotlin
// DKScore — Status.kt
enum class Status {
    SUCCESS,  // koi extra data nahi
    ERROR,    // koi extra data nahi
    LOADING   // koi extra data nahi
}
```

---

## Sealed Class — Har Case Ka Alag Data

```kotlin
// DKScore pattern
sealed class Resource<T> {
    data class Success<T>(val data: T) : Resource<T>()        // data chahiye
    data class Error<T>(val message: String) : Resource<T>()  // message chahiye
    object Loading : Resource<Nothing>()                       // koi data nahi
}
```

**Kyun sealed class better hai yahan:**
- `Success` mein sirf `data` — no null `message`
- `Error` mein sirf `message` — no null `data`
- `Loading` mein kuch nahi — `object` use kiya

---

## when — Exhaustive

```kotlin
val status: Statues = Statues.Loading

when (status) {
    is Statues.Success -> showData(status.data)
    is Statues.Failure -> showError(status.message)
    is Statues.Loading -> showLoader()
    // else nahi likha — compiler ensure karta hai sab cases handle hon
}
```

---

## Subclasses Kahan Define Karein

Sealed class ki subclasses **same file** mein honi chahiye — class ke andar ya bahar dono allowed.

```kotlin
// SealedClass.kt — same file mein, bahar bhi define kar sakte hain
sealed class Result
data class Success(val data: String) : Result()
data class Error(val message: String) : Result()
object Loading : Result()
```

---

## Object vs Data Class in Sealed Class

```kotlin
sealed class UiState {
    object Loading : UiState()                    // data nahi — object
    data class Success(val data: String) : UiState()  // data hai — data class
    data class Error(val message: String) : UiState() // data hai — data class
}
```

---

## Interview Mein Bolna
> *"`enum` use karta hoon jab sab values same structure ki hon — jaise `SUCCESS`, `ERROR`, `LOADING`. `sealed class` tab use karta hoon jab har state ka alag data ho — jaise `Success` mein data, `Error` mein message. `when` ke saath compiler ensure karta hai ki sab cases handle hon."*

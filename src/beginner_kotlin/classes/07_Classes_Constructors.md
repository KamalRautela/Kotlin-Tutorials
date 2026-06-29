# Classes + Constructors in Kotlin

## Basic Class

```kotlin
class Person(val name: String, val age: Int)

// Object banana — new keyword nahi Kotlin mein
val person = Person("Kamal", 25)
```

---

## Primary Constructor

Class declaration ke saath define hota hai — sabse common pattern.

```kotlin
// DKScore — Planet.kt
data class Planet(
    val name: String,
    val degree: String,
    val value: Int
)

val planet = Planet("Sun", "15°", 1)
```

---

## Secondary Constructor

Class ke andar `constructor` keyword se — jab alag alag combinations se object banana ho.

```kotlin
class ApiErrorResponse : Throwable() {
    var message: String = ""
    var code: Int = 0

    constructor(message: String) : super(message) {
        this.message = message
    }

    constructor(message: String, code: Int) : super(message) {
        this.message = message
        this.code = code
    }
}

val e1 = ApiErrorResponse("Something went wrong")
val e2 = ApiErrorResponse("Payment failed", 402)
```

---

## Default Parameters — Secondary Constructor Ki Zarurat Nahi

```kotlin
// DKScore — Availability.kt
data class Availability(
    var day: String = "",
    var selected: Boolean = false,
    var startTime: String = ""
)

val a1 = Availability()                           // sab default
val a2 = Availability(day = "Monday")             // sirf day
val a3 = Availability(day = "Monday", selected = true)
```

---

## constructor Keyword Kab Explicitly Likhte Hain

Jab constructor pe annotation lagana ho — jaise Hilt `@Inject`:

```kotlin
// DKScore — AppViewModel.kt
@HiltViewModel
class AppViewModel @Inject constructor(
    private val appRepository: AppRepository,
    application: Application
) : AndroidViewModel(application)
```

---

## init Block

Object create hone ke turant baad kuch execute karna ho:

```kotlin
class AppViewModel @Inject constructor(...) {
    init {
        loadUserData()    // ViewModel bante hi chalega
        checkAuthToken()
    }
}
```

---

## Primary vs Secondary — Kab Kaunsa

| | Primary | Secondary |
|---|---|---|
| Syntax | Class ke saath | Class ke andar |
| Kotlin preference | ✅ Prefer karo | Sirf zarurat ho tab |
| Default params ke saath | Sab cases cover hote hain | Nahi chahiye |

---

## Interview Mein Bolna
> *"Kotlin mein mostly primary constructor use karta hoon — default parameters se multiple cases handle ho jaate hain. Secondary constructor sirf tab banata hoon jab completely alag parameter combinations chahiye. `new` keyword nahi hota Kotlin mein — directly `ClassName(params)` se object banate hain."*

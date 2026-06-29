# Data Class vs Regular Class in Kotlin

## Kyu Use Karein?
Jab class sirf **data hold kare** — API response, DB model, UI state — `data class` use karo.
Auto-generated functions milte hain jo normal class mein manually likhne padte.

---

## Auto-Generated Functions

| Function | Kya Karta Hai | DKScore Use |
|---|---|---|
| `equals()` | Values compare karta hai (reference nahi) | 2 planets same hain? |
| `hashCode()` | Hash value generate karta hai | Collections mein use |
| `toString()` | Readable string representation | Logging/debugging |
| `copy()` | Object copy — kuch values change karke | Planet ki ek property update |
| `componentN()` | Destructuring ke liye | `val (name, degree) = planet` |

---

## equals() — Data Class vs Normal Class

```kotlin
// data class — values compare karta hai
data class Planets(val planetName: String, val planetNumber: Int)

val p1 = Planets("mercury", 1)
val p2 = Planets("mercury", 1)
println(p1 == p2)  // true ✅ — values same hain

// normal class — reference compare karta hai
class Planet(val name: String, val value: Int)

val p1 = Planet("mercury", 1)
val p2 = Planet("mercury", 1)
println(p1 == p2)  // false ❌ — alag objects hain
```

---

## copy() — Partial Update

```kotlin
// DKScore — Planet object mein sirf degree update karna ho
val sun = Planet("Sun", "15°", 1)
val modifiedSun = sun.copy(degree = "20°")  // sirf degree change, baaki same

// Bina copy() — sab 9 fields dobara likhne padte
val modifiedSun = Planet("Sun", "20°", 1, "Aries", ...)  // bahut lamba
```

---

## componentN() — Destructuring

```kotlin
data class Planet(val name: String, val degree: String, val value: Int)

val planet = Planet("Sun", "15°", 1)
val (name, degree, value) = planet  // componentN() ki wajah se
println("$name at $degree")
```

---

## DKScore Real Example

```kotlin
// Planet.kt — API response model
data class Planet(
    val CUST_NAKID: Int,
    val degree: String,
    val fullname: String,
    val name: String,
    val rashi: String,
    val value: Int
)
```

`data class` isliye — API se aata hai, compare karna padta hai, copy karna padta hai.

---

## Interview Mein Bolna
> *"`data class` use karta hoon jab class sirf data hold kare — jaise API response models ya Room entities. `equals()` values compare karta hai — normal class mein reference compare hota. `copy()` se partial update clean hota hai — sirf jo field change karni ho woh likhte hain, baaki automatic same rehta hai."*

# Scope Functions in Kotlin

## Quick Reference

| Function | Access | Returns | Use Case |
|---|---|---|---|
| `let` | `it` | Lambda result | Null check + transform |
| `apply` | `this` | Object | Object setup/initialize |
| `also` | `it` | Object | Logging, side effects |
| `run` | `this` | Lambda result | Operations + result chahiye |
| `with` | `this` | Lambda result | Non-nullable object pe multiple calls |

**Trick:**
- `it` wale → `let`, `also`
- Object return wale → `apply`, `also`

---

## let — Null Check + Transform

```kotlin
// DKScore — token null nahi hai toh API call karo
val token: String? = null
token?.let {
    apiCall()  // it = token
}

// Transform
val length = token?.let {
    it.length  // last line return hoti hai
}
```

---

## apply — Object Setup

```kotlin
// DKScore — NetworkHelper.kt
val innerJson = JsonObject().apply {
    requestParams.forEach { (key, value) ->
        add(key, value)  // this = innerJson
    }
}
```

---

## also — Logging/Side Effects

```kotlin
val food1 = Food().apply {
    foodName = "Momos"
    foodPrice = 2
}.also {
    println(it.foodPrice)  // it = food1 — side effect
}
```

---

## run — Operations + Result

```kotlin
// this se access, result return
val foodName = food1.run { foodName }

// Null check ke saath
val isLoggedIn = appCache?.run {
    val token = getLoginUserAuthToken()  // this = appCache
    token.isNotEmpty()                   // last line return
}
```

---

## with — Non-Nullable Object

```kotlin
// DKScore — AvailabilityFragment.kt
private fun bindUi() = with(binding) {
    startTime.setEditTextEditable(false)  // this = binding
    endTime.setEditTextEditable(false)
}

// run vs with
val r = food1.run { foodName }      // food1.run {}
val w = with(food1) { foodName }    // with(food1) {}
```

**run vs with:**
- `run` → nullable object pe `object?.run {}`
- `with` → non-nullable object pe `with(object) {}`

---

## Chaining — Real Power

```kotlin
val food = Food().apply {
    foodName = "Momos"   // setup
    foodPrice = 2
}.also {
    println(it.foodPrice) // log
}
```

---

## let vs run — Fark

```kotlin
// let — it se (explicit)
val result = user?.let { it.name.length }

// run — this se (implicit, clean)
val result = user?.run { name.length }
```

---

## Interview Mein Bolna
> *"`apply` use karta hoon object initialize karne ke liye — jaise `JsonObject` setup karna. `let` null check ke saath use karta hoon. `also` logging ke liye. `run` aur `with` tab jab object pe multiple operations karke result chahiye — fark sirf syntax ka hai."*

# Functions in Kotlin

## Basic Function

```kotlin
fun add(x: Int, y: Int): Int {
    return x + y
}
```

---

## Default Parameters

Agar function call mein parameter pass na karo toh default value use hoti hai.

```kotlin
// DKScore — NetworkHelper.kt
suspend fun makeApiRequest(
    requestParams: Map<String, Any?> = emptyMap(),  // default parameter
    apiCall: suspend (JsonObject) -> Response<T>
)

// requestParams pass kiya
makeApiRequest(requestParams = mapOf("id" to 123), apiCall = {...})

// requestParams pass nahi kiya — emptyMap() use hoga
makeApiRequest(apiCall = {...})
```

**Kyun use karein:** Ek hi function multiple cases handle kare — alag alag function banane ki zaroorat nahi.

---

## Named Parameters

Parameter ka naam explicitly likhna function call mein.

```kotlin
// Bina named params — confusing
makeApiRequest(mapOf("id" to 123), null, { getUser(it) })

// Named params ke saath — clear
makeApiRequest(
    requestParams = mapOf("id" to 123),
    apiCall = { getUser(it) }
)
```

**Kyun use karein:**
1. Default parameters ke saath precise hona padta hai
2. Readability — doosra developer turant samjhe

---

## Single Expression Function

```kotlin
// DKScore — AvailabilityAdapter.kt
override fun getItemCount(): Int = items.size

// Normal wala
override fun getItemCount(): Int {
    return items.size
}
```

**Rule:** Ek hi line return karni ho → `=` use karo, `{}` aur `return` nahi likhna.

---

## suspend Function

```kotlin
// DKScore — NetworkHelper.kt
suspend fun makeApiRequest(...): Resource<T>
```

`suspend` matlab — yeh function coroutine mein chalega, thread block nahi karega.
*(Coroutines topic mein detail se cover hoga)*

---

## Interview Mein Bolna
> *"Default parameters se overloaded functions banane ki zaroorat nahi — ek function multiple cases handle karta hai. Named parameters se code readable hota hai, especially jab multiple parameters hon. Single expression functions se boilerplate code kam hota hai."*

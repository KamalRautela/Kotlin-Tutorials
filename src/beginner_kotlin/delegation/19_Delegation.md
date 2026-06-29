# Delegation in Kotlin

## Kya Hai?
`by` keyword — kaam kisi aur (delegate) ko de do.

---

## by lazy — Pehli Access Pe Initialize

```kotlin
val retrofit: Retrofit by lazy {
    Retrofit.Builder().baseUrl(BASE_URL).build()
}
// pehli baar retrofit use karo tab initialize hoga
```

---

## by viewModels() — ViewModel Delegation

```kotlin
// DKScore — MainActivityAstrologer.kt

// Bina delegation — manually banana padta
private lateinit var forYouViewModel: ForYouViewModel
override fun onCreate(...) {
    forYouViewModel = ViewModelProvider(this)[ForYouViewModel::class.java]
}

// Delegation ke saath — ek line mein
private val forYouViewModel by viewModels<ForYouViewModel>()
// viewModels() delegate:
// - ViewModel banata hai
// - Lifecycle handle karta hai
// - Same instance return karta hai
```

---

## by activityViewModels() — Shared ViewModel

```kotlin
// Multiple fragments ek hi ViewModel share karein
private val appViewModel by activityViewModels<AppViewModel>()
```

---

## by Delegates.observable() — Value Change Pe Notify

```kotlin
var userName: String by Delegates.observable("") { property, oldValue, newValue ->
    println("$oldValue → $newValue")
    updateUI(newValue)  // value change hone pe automatically UI update
}
```

---

## Common Delegates — Summary

| Delegate | Kya Karta Hai | Use Case |
|---|---|---|
| `by lazy` | Pehli access pe initialize | Heavy objects — Retrofit, Gson |
| `by viewModels()` | ViewModel create + lifecycle | Fragment mein ViewModel |
| `by activityViewModels()` | Shared ViewModel | Multiple fragments |
| `by Delegates.observable()` | Value change pe notify | UI reactive update |

---

## Interview Mein Bolna
> *"Delegation `by` keyword se hoti hai — kaam kisi delegate ko de dete hain. Android mein `by viewModels()` sabse common hai — ViewModel banane ka boilerplate code ek line mein ho jaata hai aur lifecycle automatically handle hota hai. `by lazy` heavy objects ke liye use karta hoon startup time save karne ke liye."*

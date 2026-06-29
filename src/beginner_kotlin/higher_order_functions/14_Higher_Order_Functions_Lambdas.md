# Higher-Order Functions + Lambdas in Kotlin

## Kya Hai?

**Lambda** = naam ke bina function
```kotlin
// Normal function
fun add(a: Int, b: Int): Int = a + b

// Same kaam — Lambda
val add = { a: Int, b: Int -> a + b }
add(5, 3)  // 8
```

**Higher-Order Function** = function jo doosri function ko parameter mein leta hai
```kotlin
fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

calculate(5, 3) { x, y -> x + y }  // 8
calculate(5, 3) { x, y -> x * y }  // 15
```

---

## Lambda Syntax

```kotlin
{ parameters -> body }

// No parameter
val greet = { println("Hello") }

// One parameter
val price = { rate: Int -> println("Rate is $rate") }

// Two parameters — return value
val addTax = { price: Int, tax: Int -> price + tax }

// Last line automatically return hoti hai
```

---

## Common Patterns

| Pattern | Syntax | Use Case |
|---|---|---|
| No param, no return | `() -> Unit` | Click listener |
| Param, no return | `(T) -> Unit` | Data process |
| Param, return | `(T) -> R` | Transform |
| Filter | `(T) -> Boolean` | Collections |

```kotlin
// () -> Unit
fun doSomething(action: () -> Unit) { action() }
doSomething { println("clicked") }

// (T) -> R
fun doTask(name: String, task: (String) -> String): String = task(name)
doTask("kamal") { it.uppercase() }  // "KAMAL"
```

---

## Trailing Lambda

Jab lambda **last parameter** ho — `()` ke bahar likh sakte hain.

```kotlin
// Normal
makeApiRequest(params, apiCall = { json -> apiService.getUser(json) })

// Trailing — clean
makeApiRequest(params) { json -> apiService.getUser(json) }

// Sirf lambda ho — () bhi hata sakte hain
doSomething { println("Hello") }
```

---

## DKScore Real Use Cases

```kotlin
// 1. setOnClickListener
button.setOnClickListener {
    openPaymentScreen()
}

// 2. makeApiRequest — NetworkHelper.kt
makeApiRequest { json -> apiService.getUser(json) }
makeApiRequest { json -> apiService.getPlanets(json) }
// ek hi function — alag alag API calls

// 3. viewModelScope.launch
viewModelScope.launch {
    val data = repository.getUserData()
    _userLiveData.value = data
}

// 4. Collections
planets.filter { it.value > 5 }
planets.map { it.name }
```

---

## Kyun Use Karein

- Ek function multiple operations handle kare — `makeApiRequest`
- Code reuse — alag alag lambdas pass karo
- Android mein har jagah — click listeners, coroutines, collections

---

## Interview Mein Bolna
> *"Higher-order functions wo hote hain jo doosri functions ko parameter mein lete hain. DKScore mein `makeApiRequest` ek higher-order function hai — alag alag API calls lambda ke roop mein pass karte hain. Android mein click listeners, coroutines, collections sab mein lambdas use hote hain."*

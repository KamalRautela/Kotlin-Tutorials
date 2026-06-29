# Loops in Kotlin

## Types of Loops

| Loop | Kab Use Karein |
|---|---|
| `for` | Range ya collection iterate karna, break/continue chahiye |
| `while` | Condition true hone tak chalao |
| `do-while` | Kam se kam ek baar execute karna ho |
| `forEach` | Collection iterate karna, clean code chahiye |
| `forEachIndexed` | Collection iterate karna + index bhi chahiye |

---

## for Loop — Java se Alag

```kotlin
// Java style — Kotlin mein nahi hota
for (int i = 0; i < 9; i++) { }

// Kotlin style — range
for (id in 1..9) { }           // 1 to 9 (9 included)
for (id in 1 until 9) { }      // 1 to 8 (9 excluded)
for (id in 9 downTo 1) { }     // 9 to 1
for (id in 1..9 step 2) { }    // 1,3,5,7,9

// Collection iterate
for (planet in planetList) { }

// Index ke saath
for ((index, planet) in planetList.withIndex()) { }
```

---

## while — Retry Logic

```kotlin
// DKScore pattern — API retry
var retryCount = 0
while (retryCount < 3) {
    val response = apiCall()
    if (response.isSuccessful) break
    retryCount++
}
```

## do-while — Pehle Execute, Phir Check

```kotlin
var i = 0
do {
    println(i)
    i++
} while (i < 5)
// Atleast ek baar chalega chahe condition false ho
```

---

## forEach — Clean Iteration

```kotlin
// Basic
planetList.forEach { planet ->
    println(planet.name)
}

// Index ke saath
planetList.forEachIndexed { index, planet ->
    println("$index -> ${planet.name}")
}

// DKScore — NetworkHelper.kt — Map iterate
requestParams.forEach { (key, value) ->
    add(key, value)  // destructuring directly
}
```

---

## for vs forEach — Kab Kya

| Situation | Use Karein |
|---|---|
| Simple iteration | `forEach` |
| Index chahiye | `forEachIndexed` |
| Break/continue karna ho | `for` loop |
| Map iterate karna | `forEach { (key, value) }` |
| Transformation + null filter | `mapNotNull` |

**Important:** `forEach` mein `break`/`continue` nahi hota — yahi `for` loop se biggest difference hai.

---

## DKScore Real Example

```kotlin
// KundaliPlanetInformation.kt
// for loop ki jagah mapNotNull — null values auto filter
(1..9).mapNotNull { id ->
    kundaliPlanets[id.toString()]
}
```

---

## Interview Mein Bolna
> *"Simple iteration ke liye `forEach` use karta hoon — clean aur readable hai. Jab `break`/`continue` chahiye toh `for` loop. Transformation + null filtering ke liye `mapNotNull` use karta hoon — jaise DKScore mein planets iterate karte waqt."*

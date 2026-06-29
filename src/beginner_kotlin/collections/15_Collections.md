# Collections in Kotlin

## Types — List, Set, Map

| Type | Duplicates | Order | Use Case |
|---|---|---|---|
| `List` | Allowed | Maintained | Ordered data |
| `Set` | Not allowed | Not guaranteed | Unique values |
| `Map` | Keys unique | Not guaranteed | Key-value pairs |

---

## List — Immutable vs Mutable

```kotlin
// Immutable — change nahi kar sakte
val shapes = listOf("circle", "rectangle", "triangle")
shapes.add("oval")  // Error!

// Mutable — change kar sakte hain
val names = mutableListOf("Kamal", "Anuj")
names.add("Neeraj")    // OK
names.remove("Anuj")   // OK
names.removeAt(0)      // OK

// DKScore — AvailabilityFragment.kt
private val dataList = ArrayList<Availability>()
dataList.add(availability)
```

**MVVM Pattern — `_list` / `list`:**
```kotlin
// Private mutable — sirf ViewModel change kare
private val _planets = mutableListOf<Planet>()
// Public immutable — UI sirf read kare
val planets: List<Planet> = _planets
```

---

## Set — Unique Values

```kotlin
val set = setOf(1, 2, 2, 3, 3)
// [1, 2, 3] — duplicates remove

val mutableSet = mutableSetOf(1, 2, 3)
mutableSet.add(4)  // OK
mutableSet.add(2)  // Ignore — already exists

// DKScore use case — unique rashis
val uniqueRashis = planets.map { it.rashi }.toSet()
```

---

## Map — Key-Value Pairs

```kotlin
// DKScore — KundaliPlanetInformation.kt
val kundaliPlanets: Map<String, KundaliPlanetInformation>
// key = "1", "2", "AS"
// value = planet info

// Simple example
val planetMap = mapOf(
    "1" to Planet("Sun", "Aries"),
    "2" to Planet("Moon", "Taurus")
)
val sun = planetMap["1"]  // Planet("Sun", "Aries")

// Mutable Map
val mutableMap = mutableMapOf<String, Planet>()
mutableMap["3"] = Planet("Mars", "Scorpio")
mutableMap.remove("1")

// Nested Map
val studentGrades = mapOf(
    "A" to listOf("Kamal", "Anil"),
    "B" to listOf("Ronald", "Mary")
)
```

---

## Kab Kaunsa

| Situation | Use Karein |
|---|---|
| Order matter karta hai | `List` |
| Duplicates nahi chahiye | `Set` |
| Key se value dhundna | `Map` |
| Data change hoga | `mutableListOf` / `mutableSetOf` / `mutableMapOf` |
| Data fix hai | `listOf` / `setOf` / `mapOf` |

---

## Common Functions

| Function | Kya Karta Hai | Use Case |
|---|---|---|
| `map` | Har element transform | Names nikalna, price calculate |
| `filter` | Condition pe filter | Specific elements nikalna |
| `firstOrNull` | Pehla matching element | Search karna |
| `mapNotNull` | Transform + null filter | Nullable results handle |
| `groupBy` | Group banao | Category wise group |
| `joinToString` | List → String | Comma separated display |
| `flatMap` | Flatten + transform | Nested list handle |
| `flatten` | Sirf flatten | Nested list merge |

---

## map — Transform

```kotlin
val prices = listOf(100, 200, 300)

// Tax add karo
val withTax = prices.map { it + (it * 0.1).toInt() }
// [110, 220, 330]

// DKScore — planet names nikalo
val names = planets.map { it.name }
// ["Sun", "Moon", "Mars"]
```

---

## filter — Condition Pe Filter

```kotlin
val priceAbove200 = prices.filter { it > 200 }
// [300]

// DKScore — high value planets
val highValuePlanets = planets.filter { it.value > 5 }
```

---

## firstOrNull — Pehla Match

```kotlin
val first = prices.firstOrNull { it > 300 }
// 400 — ya null agar koi nahi mila
```

---

## mapNotNull — Null Filter

```kotlin
// DKScore — KundaliPlanetInformation.kt
ids.mapNotNull { kundaliPlanets[it]?.fullName }
// null values automatically remove

// map vs mapNotNull
ids.map { kundaliPlanets[it]?.fullName }     // ["Sun", null, "Moon"]
ids.mapNotNull { kundaliPlanets[it]?.fullName } // ["Sun", "Moon"]
```

---

## groupBy — Group Banao

```kotlin
data class Planet(val name: String, val rashi: String)

val grouped = planets.groupBy { it.rashi }
// {"Aries": [Sun, Mars], "Taurus": [Moon]}

// DKScore — planets rashi ke basis pe group
```

---

## joinToString — List to String

```kotlin
// DKScore — KundaliPlanetInformation.kt
val names = planets.joinToString(separator = ", ") { it.name }
// "Sun, Moon, Mars"
```

---

## flatMap vs flatten

```kotlin
val nested = listOf(listOf("Sun", "Mars"), listOf("Moon", "Venus"))

// flatten — sirf merge
nested.flatten()
// ["Sun", "Mars", "Moon", "Venus"]

// flatMap — merge + transform
nested.flatMap { it.map { name -> name.uppercase() } }
// ["SUN", "MARS", "MOON", "VENUS"]
```

---

## map {} vs map() — Same Hai

```kotlin
prices.map { it * 2 }      // trailing lambda — preferred
prices.map({ it * 2 })     // lambda andar — same result
```

---

## Interview Mein Bolna
> *"Collections mein `map` transform ke liye, `filter` filtering ke liye, `mapNotNull` null safe transform ke liye use karta hoon. DKScore mein `groupBy` se planets rashi ke basis pe group kiye, `joinToString` se names comma separated string mein convert kiye."*

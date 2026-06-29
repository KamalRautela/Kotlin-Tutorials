# Data Types in Kotlin

## Kyu Zaroori Hai?
Sahi data type choose karna memory optimize karta hai aur bugs avoid karta hai.
Rule: **API se kya format aaega** — wohi decide karta hai data type.

---

## Types aur Kab Use Karein

| Type | Size | Kab Use Karein | DKScore Example |
|---|---|---|---|
| `Int` | 32-bit | Count, ID, mathematical operations | `val value: Int` — Planet ID |
| `Long` | 64-bit | Timestamps, very large numbers | `val callStartTime: Long` — Call start time |
| `Double` | 64-bit | Price, decimal precision matters | Astrologer per-minute rate `₹12.50` |
| `Float` | 32-bit | Decimal, precision kam chahiye | Avoid karo — rounding errors aate hain |
| `String` | — | Text, symbols mixed values | `val degree: String` — `"15° 23' 45"` |
| `Boolean` | — | Status flags, true/false | `var selected: Boolean` — Astrologer available? |
| `Char` | 16-bit | Single character | Gender `'M'`/`'F'`, Status `'Y'`/`'N'` |
| `Byte` | 8-bit | Range 0-127, memory critical | Rarely used in Android |
| `Short` | 16-bit | Small known range | Rarely used in Android |
| `Any` | — | Unknown type at compile time | Avoid — type-safe code better hai |
| `Nothing` | — | Function jo kabhi return nahi karta | `throw Exception(...)` |

---

## Key Rules

**String vs Number:**
```kotlin
val degree: String = "15° 23' 45"  // symbols hain — String
val value: Int = 5                  // sirf number — Int
```

**Int vs Long:**
```kotlin
val planetCount: Int = 9                        // small number — Int kaafi
val callStartTime: Long = System.currentTimeMillis() // timestamp — Long zaroori
```

**Double vs Float:**
```kotlin
val price: Double = 12.50  // payment — Double use karo
val ratio: Float = 0.5f    // precision matter nahi — Float (f suffix zaroori)
```

**Any with Smart Cast:**
```kotlin
var data: Any = "Kamal"
if (data is String) {
    println(data.length)  // compiler ab jaanta hai — String hai
}
```

**Nothing:**
```kotlin
fun throwError(): Nothing {
    throw IllegalStateException("Fatal error")
    // yeh function kabhi return nahi karta
}
```

---

## Interview Mein Bolna
> *"Data type choose karte waqt main dekhta hoon ki API se kya format aaega aur uske saath kya operations karne hain. Jaise Planet ka `degree` field `String` hai kyunki usme `°` symbols hote hain jo `Double` mein store nahi ho sakte."*

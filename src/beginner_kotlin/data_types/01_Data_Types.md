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
| `Double` | 64-bit | Decimal calculations (~15-16 digits precision) | Planet degree calculation — paise ke liye nahi (neeche dekho) |
| `Float` | 32-bit | Decimal, precision kam chahiye (~6-7 digits) | Android graphics mein standard: `alpha`, `translationX`, animation values. Paise ke liye nahi |
| `String` | — | Text, symbols mixed values | `val degree: String` — `"15° 23' 45"` |
| `Boolean` | — | Status flags, true/false | `var selected: Boolean` — Astrologer available? |
| `Char` | 16-bit | Single character | Gender `'M'`/`'F'`, Status `'Y'`/`'N'` |
| `Byte` | 8-bit | Range -128 to 127, memory critical | Rarely used in Android |
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
val distance: Double = 12.50  // default decimal type — Double
val ratio: Float = 0.5f       // precision matter nahi — Float (f suffix zaroori)
```

**Paise (Money) ke liye Double/Float mat use karo:**
```kotlin
println(0.1 + 0.2)  // 0.30000000000000004 — floating point error

// ✅ Option 1: BigDecimal (String se banao, Double se nahi)
val rate = BigDecimal("12.50")

// ✅ Option 2: Paise mein Long store karo
val rateInPaise: Long = 1250L  // ₹12.50
```
> Astrologer per-minute rate `₹12.50` jaisi values ke liye `BigDecimal` ya paise mein `Long` use karo.

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

## Gotchas (Meri Galtiyan)

**1. Money ke liye Double**
```kotlin
// ❌ GALAT
val rate: Double = 12.50
println(0.1 + 0.2)              // 0.30000000000000004

// ✅ SAHI
val rate = BigDecimal("12.50")  // String se banao
val rateInPaise: Long = 1250L   // ya paise mein Long
```
> `0.1` binary mein exactly store nahi hota. Wallet mein har minute deduction pe yeh error judta jaata hai: 10 baar `0.1` minus karne pe `100.0` se `99.00000000000006` aata hai, `99.0` nahi.

```kotlin
println(0.1 + 0.2 == 0.3)   // false
```
> **Kyun:** Decimal mein `1/3` exactly nahi likh sakte (`0.333...`). Waise hi binary mein `0.1` recurring fraction hai, toh sirf uski closest value store hoti hai.

```kotlin
// BigDecimal: call cost = rate × minutes
val rate = BigDecimal("12.50")
val cost = rate * 15.toBigDecimal()          // 187.50

// Long paise: sirf display pe rupees banao
val balancePaise = 18750L
val text = "₹%d.%02d".format(balancePaise / 100, balancePaise % 100)  // ₹187.50
```

**2. Integer division**
```kotlin
println(7 / 2)     // 3    ← Int / Int = Int, decimal part kat jaata hai (round nahi hota)
println(7 / 2.0)   // 3.5  ← ek bhi Double ho toh result Double
println(7 % 2)     // 1    ← remainder
```
> Rule: result **wider type** ka hota hai: `Int` → `Long` → `Float` → `Double`. Number ka size nahi, type matter karta hai.

> **Kyun chalta hai jab implicit conversion nahi hai?** `Int` class mein **operator overloads** pehle se defined hain, jaise `operator fun div(other: Double): Double`. `7 / 2.0` asal mein `7.div(2.0)` hai, toh Int ko Double mein convert nahi kiya jaata, bas sahi overload call hota hai jo `Double` return karta hai.

**3. Overflow: compile error nahi hai**
```kotlin
println(Int.MAX_VALUE + 1)   // -2147483648  ← silently wrap around, koi exception nahi
```
> Compile time pe sirf **warning** aati hai ("This operation has led to an overflow"), error nahi.

```kotlin
// ✅ Fix
val a = Int.MAX_VALUE.toLong() + 1     // 2147483648  ← Long mein safe
Math.addExact(Int.MAX_VALUE, 1)        // ArithmeticException ← silently galat value se crash behtar hai
```

**4. Implicit conversion nahi hoti**
```kotlin
val minutes: Int = 15
// ❌ GALAT
val total: Long = minutes             // Type mismatch
val totalSec: Long = minutes * 60     // Type mismatch: Int * Int = Int, Long mein auto-convert nahi hota
// ✅ SAHI
val total: Long = minutes.toLong()
val totalSec: Long = minutes * 60L    // Int * Long = Long, yeh chalega
```

**5. Literal ke default types**
```kotlin
// ❌ GALAT
val ratio: Float = 0.5      // 0.5 Double hai
val price: Double = 5       // 5 Int hai

// ✅ SAHI
val ratio: Float = 0.5f
val price: Double = 5.0

val x: Long = 5             // ✅ yeh chalta hai! Whole number literal Long/Short/Byte ban sakta hai (range mein ho toh)
```

**6. `null` ek value hai, exception nahi**
```kotlin
// ❌ GALAT: null is NullPointerException hamesha false hai, null else mein chala jaayega
is NullPointerException -> "N/A"

// ✅ SAHI
null -> "N/A"
```
> `null` = "value nahi hai". `NullPointerException` = crash, jab null pe kuch access karne ki koshish karo.

**7. Milliseconds calculation mein overflow**
```kotlin
// ❌ GALAT: 36 minute ke baad Int overflow, negative value
val durationMs: Int = minutes * 60 * 1000
// ✅ SAHI: 1000L se poora calculation Long mein
val durationMs: Long = minutes * 60 * 1000L
```

**8. Float precision = total significant digits (decimal ke baad wale nahi)**
```kotlin
println(1.23456789f)    // 1.2345679     ← 7-8 digits ke baad kata
println(123456.789f)    // 123456.79     ← decimal ke baad sirf 2 bache!
println(12345678.9f)    // 1.2345679E7   ← decimal part poora gaya
println(12345678.9)     // 1.23456789E7  ← Double mein sab safe
```
> Float ke paas total ~7 **significant digits** hain, chahe decimal ke pehle hon ya baad. Number jitna bada, decimal ke baad utne kam digits bachte hain.

**9. Smart cast class ki `var` property pe nahi hota**
```kotlin
class CallSession { var astrologerName: String? = null }

// ❌ GALAT: compile error
if (session.astrologerName != null) {
    println(session.astrologerName.length)
    // Smart cast to 'String' is impossible, because 'astrologerName'
    // is a mutable property that could have been changed by this time
}

// ✅ Fix 1: local val copy
val name = session.astrologerName
if (name != null) println(name.length)

// ✅ Fix 2: ?.let
session.astrologerName?.let { println(it.length) }
```
> **Kyun:** Check aur use ke beech koi doosra thread ya function `var` property badal sakta hai, toh compiler ko guarantee nahi milti. Local `val` ko koi nahi badal sakta.

---

## Common Interview Questions

**Q: Type inference kya hai? Kotlin statically typed kaise hai?**
> Compiler assigned value dekh ke **compile time** pe type khud decide kar leta hai, toh type likhna optional ho jaata hai. Lekin type fix ho jaata hai: `var count = 10` ke baad `count = "Kamal"` compile error dega. `3_000_000_000` jaisi value Int range se bahar hai, toh compiler khud `Long` infer karta hai. Function parameters aur bina value wale variables mein type likhna padta hai.

**Q: `Any`, `Any?` aur `Nothing` mein kya fark hai?**
> `Any` type hierarchy ka root hai, har **non-null** type uska subtype hai. `null` bhi hold karna ho toh `Any?`. `Nothing` bilkul ulta hai: uski koi value nahi hoti, aur woh **har type ka subtype** hai. Isliye `val id: Int = response.id ?: throw Exception()` compile hota hai, kyunki `throw` ka type `Nothing` hai jo `Int` ki jagah fit ho jaata hai. `TODO()` bhi `Nothing` return karta hai.

**Q: `Unit` aur `Nothing` mein kya fark hai?**
> `Unit` wala function **return karta hai**, bas koi meaningful value nahi deta (Java ka `void`), jaise `fun showToast(msg: String)`. `Nothing` wala function **kabhi return nahi karta**: ya toh hamesha exception throw karta hai, ya infinite loop hai, jaise `fun fail(msg: String): Nothing = throw IllegalStateException(msg)`.
> ```kotlin
> val result = println("Hi")   // result ka type Unit hai
> println(result)              // kotlin.Unit
> ```
> `Unit` ek real type hai, ek `object` jiski **sirf ek value** hoti hai (`Unit` khud). Java ke `void` ki koi value nahi hoti, Kotlin ke `Unit` ki hoti hai. Isliye `() -> Unit` jaise generic/lambda types ban paate hain.

**Q: Double aur Float mein kya fark hai?**
> Double **64-bit** hai, precision ~**15-16** digits. Float **32-bit** hai, precision ~**6-7** digits. Kotlin mein decimal ka default Double hai, Float ke liye `f` suffix chahiye. Float round off nahi karta, bas uske paas digits kam hain: `println(1.23456789f)` → `1.2345679`.

**Q: Wallet balance ya per-minute rate ke liye kaunsa type use karoge?**
> Kabhi Double ya Float nahi, kyunki floating point binary mein `0.1` jaisi values exactly store nahi kar sakta. Main `BigDecimal` use karta hoon (String constructor se: `BigDecimal("12.50")`, `BigDecimal(12.50)` nahi), ya amount ko paise mein `Long` mein store karta hoon aur sirf display pe rupees mein convert karta hoon. Bonus: BigDecimal ka `==` scale bhi check karta hai, `BigDecimal("99.0") == BigDecimal("99.00")` false hai, value compare ke liye `compareTo` use karo.

**Q: Smart cast kya hai, aur kab kaam nahi karta?**
> `is` check ya null check ke baad us scope mein compiler variable ko specific type maan leta hai, explicit `as` cast nahi likhna padta. Variable ka declared type nahi badalta. Smart cast tabhi hota hai jab compiler ko guarantee ho ki check aur use ke beech value badal nahi sakti. Class ki `var` property, custom getter ya `open` property pe nahi hota: wahan local `val` mein copy karo ya `?.let { }` use karo.

**Q: Kotlin mein primitive types nahi hain, toh kya `Int` slow hai?**
> Nahi. Source code mein `Int` object jaisa dikhta hai (`5.toString()` chalta hai), lekin compiler non-null `Int` ko JVM ke primitive `int` mein compile karta hai, toh speed Java jaisi hi hai. `Int?` aur `List<Int>` jaise generics mein **boxing** hoti hai: woh `java.lang.Integer` object ban jaata hai (~16 bytes vs 4 bytes), kyunki primitive `null` hold nahi kar sakta aur generics ko objects chahiye. Isliye nullable tabhi use karo jab `null` ki sach mein zarurat ho.
> ```kotlin
> val a: Int = 100
> val boxedA: Int? = a; val anotherA: Int? = a
> println(boxedA === anotherA)   // true  ← -128..127 Integer cache se same object
>
> val b: Int = 1000
> val boxedB: Int? = b; val anotherB: Int? = b
> println(boxedB === anotherB)   // false ← cache ke bahar, har baar naya Integer object
> println(boxedB == anotherB)    // true  ← == value compare karta hai
> ```
> `IntArray` → JVM `int[]`, koi boxing nahi, memory kam. `List<Int>` / `Array<Int>` → `Integer` objects (boxing). Bade numeric data ke liye `IntArray`.

**Q: Kotlin mein implicit conversion kyun nahi hai?**
> Yeh type safety ke liye jaan-boojh ke liya gaya design decision hai. Java ki implicit widening mein do problems hain: silent precision loss (`long` se `float` mein digits badal jaate hain), aur boxed types mein equality toot jaati hai (`Long` aur `Integer` same value pe bhi equal nahi hote). Kotlin mein har conversion explicit hai (`toLong()`, `toInt()`), toh conversion code mein saaf dikhta hai aur hidden bugs compile time pe ruk jaate hain.

**Q: Data class ke fields ka type kaise choose karte ho?**
> API se kya aata hai aur us value pe kya operations honge, yeh dekh ke:
> ```kotlin
> data class Astrologer(
>     val id: Int,                     // whole number, Int range mein fit
>     val name: String,
>     val ratePerMinute: BigDecimal,   // money: precision error nahi chahiye
>     val rating: Double,              // sirf display, chhota error chalega
>     val isOnline: Boolean,
>     val lastActiveAt: Long,          // ms timestamp, Int ki range se bahar
>     val bio: String? = null          // API se null aa sakta hai
> )
> ```
> `rating` Double mein theek hai kyunki uspe money calculation nahi hoti, sirf display hota hai.

---

## Interview Mein Bolna
> *"Data type choose karte waqt main dekhta hoon ki API se kya format aaega aur uske saath kya operations karne hain. Jaise Planet ka `degree` field `String` hai kyunki usme `°` symbols hote hain jo `Double` mein store nahi ho sakte."*

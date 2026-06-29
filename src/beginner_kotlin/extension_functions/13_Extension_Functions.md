# Extension Functions in Kotlin

## Kya Hai?
Kisi bhi class mein — built-in ya custom — bahar se functionality add karna bina class change kiye.

**Analogy:** Phone mein new app install karna — hardware change nahi, sirf upar se functionality add.

---

## Syntax

```kotlin
fun ClassName.functionName(): ReturnType {
    // this = jo object pe call kiya
}
```

---

## DKScore Real Examples

**String extension:**
```kotlin
// ConverterUtils.kt
fun String.toSentenceList(): List<String> {
    return this.split(Regex("(?<=[.!?])\\s+"))
        .map { it.trim() }
        .filter { it.isNotEmpty() }
}

val text = "Hello. How are you?"
val sentences = text.toSentenceList()  // String ka method jaisa lagta hai
```

**Nullable IntArray extension:**
```kotlin
fun IntArray?.orEmpty(): IntArray {
    return this ?: intArrayOf()  // this = IntArray object
}

val arr: IntArray? = null
val result = arr.orEmpty()  // crash nahi hoga
```

---

## Custom Examples

**isPalindrome:**
```kotlin
fun String.isPalindrome(): Boolean {
    return this == this.reversed()
}

"Kamal".isPalindrome()  // false
"madam".isPalindrome()  // true
```

**Price validation:**
```kotlin
fun Int.isValidPrice(): Boolean = this > 0

100.isValidPrice()   // true
(-5).isValidPrice()  // false
```

**Positive/Negative check:**
```kotlin
fun Int.isValid(): String {
    return when {
        this > 0 -> "Positive"
        this < 0 -> "Negative"
        else -> "Zero"
    }
}
```

---

## when(value) vs when — Difference

```kotlin
// when(this) — specific value match
when(this) {
    1 -> "One"
    2 -> "Two"
    else -> "Other"
}

// when bina argument — condition/range check
when {
    this > 0 -> "Positive"
    this < 0 -> "Negative"
    else -> "Zero"
}
```

---

## Kyun Use Karein

- Built-in class mein code nahi likh sakte — `String`, `Int`, `List`
- Third-party library class extend karna ho
- Utility functions ko class ka part jaisa dikhana ho — clean code

---

## Interview Mein Bolna
> *"Extension functions se kisi bhi class mein — built-in ya third-party — bahar se functionality add kar sakte hain bina class modify kiye. DKScore mein `String` pe `toSentenceList()` aur `IntArray` pe `orEmpty()` extension functions use kiye hain — `this` us object ko refer karta hai jis pe function call hua."*

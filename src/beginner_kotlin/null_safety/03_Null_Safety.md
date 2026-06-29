# Null Safety in Kotlin

## Kyu Zaroori Hai?
Null value pe operation karne se **NullPointerException** aata hai — app crash ho jaata hai.
Kotlin mein null safety compile time pe enforce hoti hai — runtime crash se bachata hai.

---

## Teeno Operators

| Operator | Naam | Kab Use Karein |
|---|---|---|
| `?.` | Safe Call | Code tab execute karo jab object null na ho |
| `?:` | Elvis | Null hone pe default value do |
| `!!` | Not-null Assertion | Compiler ko batao — kabhi null nahi hoga (risky!) |

---

## Real Examples

**`?.` — Safe Call:**
```kotlin
val loginName = getLoginUser()?.name
// agar getLoginUser() null hai — loginName = null (crash nahi)
// agar getLoginUser() null nahi — name return karega
```

**`?:` — Elvis:**
```kotlin
val token = sharedPref.getString(KEY_AUTH_TOKEN, "") ?: ""
// agar getString null return kare — "" use karo
```

**Dono saath — Production pattern:**
```kotlin
val loginName = getLoginUser()?.name ?: "username not available"
// null safe chain — agar kahi bhi null mile toh default do
```

**`!!` — Not-null Assertion (avoid karo):**
```kotlin
val name = user!!.name  // agar user null hai — app crash!
// sirf tab use karo jab 100% sure ho
```

---

## DKScore Real Example

```kotlin
// AppViewModel.kt
fun hasCreditBalanceLessThanFive(): Boolean {
    val credit = appRepository
        .getLoginUserSubscriptionDetails()
        ?.creditBalance        // safe call
    return (credit ?: 0) < 5  // elvis — null ho toh 0
}
```

---

## Interview Mein Bolna
> *"Kotlin mein null safety compile time pe handle hoti hai. `?.` safe call use karta hoon jab object nullable ho, `?:` se default value deta hoon, aur `!!` se bachta hoon kyunki woh runtime crash ka risk hai."*

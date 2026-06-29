# OOP in Kotlin

## 4 Pillars

| Pillar | Simple Definition | DKScore Example |
|---|---|---|
| Encapsulation | Data protect karna — controlled access | `private var authToken` in AppCache |
| Abstraction | Implementation hide karna — sirf result do | Repository pattern — ViewModel ko andar ka pata nahi |
| Inheritance | Parent class ki properties child mein | `AppViewModel : AndroidViewModel` |
| Polymorphism | Ek method — alag alag behavior | Har ViewModel ka alag `loadData()` |

---

## Encapsulation

Data hide karo — sirf methods se access do.

```kotlin
// DKScore — AppCache.kt
class AppCache {
    private var authToken: String = ""     // bahar se direct access nahi

    fun getLoginUserAuthToken(): String = authToken   // sirf read
    fun saveAuthToken(token: String) { authToken = token }  // sirf write
}
```

---

## Abstraction

Internal complexity hide karo — sirf interface dikhao.

```kotlin
// DKScore — AppRepository.kt
suspend fun getUserData(): Resource<User> {
    // andar: Retrofit call, Room cache, error handling, retry logic
    // ViewModel ko kuch pata nahi — sirf result milta hai
}
```

**Abstraction vs Encapsulation:**
- Encapsulation = data **protect** karna (ATM ka PIN)
- Abstraction = complexity **hide** karna (ATM ka screen — andar ki wiring nahi dikhti)

---

## Inheritance

Parent class ki properties aur methods child mein aa jaati hain.

```kotlin
// Kotlin mein open keyword zaroori hai
open class Animal(val name: String) {
    fun eat() = println("$name is eating")
}

class Dog(name: String) : Animal(name) {
    fun bark() = println("Woof!")
}

// DKScore
class AppViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application)  // AndroidViewModel extend kiya
```

**Important:** By default Kotlin classes `final` hoti hain — `open` lagana zaroori hai.

---

## Polymorphism

Ek method — alag alag behavior.

```kotlin
// Same method naam — alag behavior
class AppViewModel : AndroidViewModel(application) {
    fun loadData() { /* user data */ }
}
class ForYouViewModel : AndroidViewModel(application) {
    fun loadData() { /* horoscope data */ }
}
```

---

## Interface vs Abstract Class

| | Interface | Abstract Class |
|---|---|---|
| Multiple implement | ✅ Haan | ❌ Sirf ek |
| Constructor | ❌ Nahi | ✅ Haan |
| Use case | Contract/capability | Shared behavior |

```kotlin
// DKScore — dono saath use kiya
class MainActivityAstrologer : AppCompatActivity(), PaymentResultWithDataListener
// AppCompatActivity = abstract class (ek hi le sakte)
// PaymentResultWithDataListener = interface (multiple le sakte)
```

**Razorpay ne Interface kyun banaya:**
Activity pehle se `AppCompatActivity` extend kar rahi hai — doosri abstract class nahi le sakti. Interface se multiple implement possible.

---

## Interview Mein Bolna
> *"OOP ke 4 pillars mein encapsulation data protect karta hai, abstraction complexity hide karta hai, inheritance code reuse karta hai, polymorphism ek method ko alag alag behave karne deta hai. Interface multiple implement kar sakte hain — isliye DKScore mein Razorpay ka `PaymentResultWithDataListener` interface hai, abstract class nahi."*

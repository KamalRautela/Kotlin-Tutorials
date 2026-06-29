# Variables in Kotlin

## val vs var vs const val

| Keyword | Meaning | Kab Use Karein |
|---|---|---|
| `val` | Reference immutable | Reference fix hai, object change ho sakta hai |
| `var` | Mutable | Value time ke saath change hoti hai |
| `const val` | Compile-time constant | Keys, tags, URLs — kabhi change nahi hote |

---

## val — Reference Immutable

```kotlin
// DKScore — CallChatHistoryViewModel.kt
private val _callHistoryLiveData = MutableLiveData<...>()

// Allowed — andar data change ho raha hai
_callHistoryLiveData.value = newData

// NOT allowed — nayi object assign nahi kar sakte
_callHistoryLiveData = MutableLiveData()  // Error!
```

**Key point:** `val` ka matlab object immutable nahi — sirf reference immutable hai.

---

## var — Mutable

```kotlin
// DKScore — ForYouViewModel.kt
var previousCustId: Int = -1  // tracking variable

// Jab naya customer load ho — update hota hai
previousCustId = newCustomerId
```

**Key point:** Jab value time ke saath change honi ho — `var` use karo.

---

## const val — Compile-Time Constant

Sirf 3 jagah declare kar sakte hain:
1. Top-level (file mein, kisi class ke bahar)
2. `companion object` ke andar
3. `object` (singleton) ke andar

```kotlin
// DKScore — AppCache.kt
companion object {
    const val KEY_AUTH_TOKEN = "auth_token"
    const val KEY_LANGUAGE = "language"
    const val PREF_NAME = "dkscore_prefs"
}
```

**val vs const val:**
```kotlin
const val MAX = 100                          // compile-time — OK
const val time = System.currentTimeMillis()  // Error — runtime value hai
val time = System.currentTimeMillis()        // OK — runtime
```

---

## Compile-time vs Runtime Constant

| | Compile-time (`const val`) | Runtime (`val`) |
|---|---|---|
| Value kab pata chalti hai | Build time pe — app run hone se pehle | App chalte waqt |
| Example | `"auth_token"` — hamesha same | `System.currentTimeMillis()` — tab pata chalega |
| DKScore use | SharedPreferences keys | User ka auth token (server se milega) |

```kotlin
const val KEY_AUTH_TOKEN = "auth_token"       // build time pe fix
val userToken = fetchTokenFromServer()         // runtime pe milega
```

---

## Interview Mein Bolna
> *"`val` use karta hoon jab reference fix rakhna ho — jaise LiveData object. `var` use karta hoon jab value change hoti rahe — jaise tracking variables. `const val` sirf compile-time constants ke liye — jaise SharedPreferences keys."*

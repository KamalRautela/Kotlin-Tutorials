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

## Custom Getter aur `private set`

`val` ka matlab **read-only** hai: is property ka **setter nahi hai**. Iska matlab "constant" nahi. Custom getter wali `val` har baar access karne pe nayi value de sakti hai.

| Likhne ka tareeka | Value kab calculate hoti hai | Backing field |
|---|---|---|
| `val x = expr` (initializer) | **Ek baar**, jab object banta hai | Hai, value store hoti hai |
| `val x get() = expr` (custom getter) | **Har access pe** dobara | Nahi, kuch store nahi hota |

```kotlin
// DKScore — call timer
class CallSession(private val ratePerMinute: Int) {

    var elapsedSeconds: Int = 0
        private set                // bahar se padh sakte ho, likh sirf class ke andar

    // Har access pe recompute — seconds badhe toh yeh bhi badhega
    val billableMinutes: Int
        get() = ((elapsedSeconds - FREE_SECONDS) / 60).coerceAtLeast(0)

    val currentCharge: Int
        get() = billableMinutes * ratePerMinute

    fun tick() { elapsedSeconds++ }

    companion object {
        const val FREE_SECONDS = 180
    }
}
```

```kotlin
val session = CallSession(ratePerMinute = 20)
println(session.billableMinutes)   // 0
repeat(300) { session.tick() }
println(session.billableMinutes)   // 2  ← same val, nayi value
session.elapsedSeconds = 0         // ❌ Error: setter private hai
```

**`private set` vs `private var`:**

| | `private var x` | `var x` + `private set` |
|---|---|---|
| Bahar se padh sakte | ❌ | ✅ |
| Bahar se likh sakte | ❌ | ❌ |
| Use | Pure internal state | Bahar dikhana hai, par badalna sirf class ke andar |

---

## Backing Property Pattern (MVVM)

ViewModel mein state ke **do** naam hote hain: ek private jo likh sakta hai (`_balance`), aur ek public jo sirf padh sakta hai (`balance`).

```kotlin
// DKScore — WalletViewModel.kt
class WalletViewModel : ViewModel() {

    private val _balance = MutableLiveData<Int>(0)   // ViewModel hi likhega
    val balance: LiveData<Int> = _balance            // UI sirf observe karegi

    fun addMoney(amount: Int) {
        _balance.value = (_balance.value ?: 0) + amount
    }
}
```

```kotlin
// Fragment
viewModel.balance.observe(viewLifecycleOwner) { tvBalance.text = it.toString() }
viewModel.balance.value = 500   // ❌ Error: LiveData mein public setValue nahi hai
```

**Public `var balance = MutableLiveData<Int>()` rakhne ke 2 problems:**

| Problem | Kya hota hai |
|---|---|
| 1. `MutableLiveData` public | UI khud `balance.value = 99999` likh sakti hai. State ka "single source of truth" (ViewModel) toot jaata hai |
| 2. `var` | Koi `balance = MutableLiveData()` se **naya object** assign kar de, toh Fragment ke observers **purane object** pe lage rehte hain aur unhe updates milna band ho jaate hain |

`val` problem 2 ko rokta hai, `LiveData` type problem 1 ko.

**StateFlow version (aajkal zyada use hota hai):**
```kotlin
private val _uiState = MutableStateFlow(WalletUiState())
val uiState: StateFlow<WalletUiState> = _uiState.asStateFlow()
```
> `asStateFlow()` ek read-only wrapper deta hai, toh UI `as MutableStateFlow` cast karke bhi likh nahi sakti. `val balance: LiveData<Int> = _balance` mein same object hai, toh cast karke likhna technically possible hai (yeh convention se rokte hain).

---

## Read-only `List` vs Immutable List

Kotlin ka `List<T>` **read-only** hai, **immutable nahi**.

| | Read-only (`List`) | Truly immutable |
|---|---|---|
| Matlab | Is **reference** se `add()` / `remove()` nahi kar sakte | List kisi bhi tarah se kabhi nahi badlegi |
| Kaise rokta hai | Compile time pe: `List` interface mein `add()` hai hi nahi | Koi bhi mutable reference exist nahi karta |
| Badal sakti hai? | ✅ Haan, agar andar `MutableList` hai aur uska koi aur reference hai | ❌ |

```kotlin
val mutable = mutableListOf("Astro A", "Astro B")
val readOnly: List<String> = mutable     // same object, sirf "view" read-only hai

readOnly.add("Astro C")                  // ❌ Compile error
mutable.add("Astro C")                   // ✅ original reference se badal diya
println(readOnly)                        // [Astro A, Astro B, Astro C]  ← badal gayi!

(readOnly as MutableList).add("Astro D") // ✅ chal jaata hai (andar ArrayList hai)
```

**Fix (bahar sach mein safe list deni ho):**
```kotlin
private val _astrologers = mutableListOf<Astrologer>()
val astrologers: List<Astrologer>
    get() = _astrologers.toList()   // har baar nayi copy, bahar wala original nahi badal sakta
```
> Aur strong guarantee chahiye toh `kotlinx.collections.immutable` ka `persistentListOf()`. List ke andar ke objects bhi safe rakhne hain toh unki properties `val` rakho (`data class Astrologer(val name: String, val rate: Int)`).

### Reference vs Copy

```kotlin
val rates = mutableListOf(20, 25)
val backup = rates          // ❌ copy NAHI, same object ka doosra naam
rates.add(30)
println(backup)             // [20, 25, 30]

val realBackup = rates.toMutableList()   // ✅ nayi list (shallow copy)
rates.add(40)
println(realBackup)         // [20, 25, 30]

var a = 10
val b = a                   // Int ki value copy hoti hai
a = 20
println(b)                  // 10
```
> **Shallow copy:** `toMutableList()` / `toList()` nayi list banate hain, par andar ke objects wahi rehte hain. `data class` ke andar `var` property ho toh copy mein bhi woh change dikhega.

---

## Environment-wise Base URL: `BuildConfig`

Base URL **const nahi** rakhte, kyunki debug (dev server) aur release (live server) mein alag hota hai. Ise Gradle se `BuildConfig` mein generate karwate hain.

```kotlin
// app/build.gradle.kts
android {
    buildFeatures {
        buildConfig = true          // AGP 8.0+ mein default false hai, on karna padta hai
    }
    buildTypes {
        debug {
            buildConfigField("String", "BASE_URL", "\"https://dev-api.example.com/\"")
        }
        release {
            buildConfigField("String", "BASE_URL", "\"https://api.example.com/\"")
        }
    }
}
```

```kotlin
// NetworkModule.kt (Hilt)
Retrofit.Builder()
    .baseUrl(BuildConfig.BASE_URL)    // build type ke hisaab se sahi URL apne aap
    .build()
```

- String value ke andar `\"...\"` quotes zaroori hain, kyunki Gradle ise as-is Java code mein likhta hai.
- Zyada environments (dev / staging / prod) ho toh `productFlavors` mein bhi `buildConfigField` likh sakte ho.
- ⚠️ `BuildConfig` APK ke andar jaata hai, decompile karke padha ja sakta hai. Base URL theek hai, **secret keys** yahan safe nahi hain.

**Kaunsa keyword kahan (DKScore):**

| Cheez | Kya use karein | Kyun |
|---|---|---|
| SharedPreferences **key** `"auth_token"` | `const val KEY_AUTH_TOKEN` | Naam build time pe fix hai |
| SharedPreferences **value** (asli token) | `val token = prefs.getString(KEY_AUTH_TOKEN, null)` | Login ke baad runtime pe milta hai |
| Base URL | `BuildConfig.BASE_URL` | Build type ke hisaab se badalta hai |
| Free minutes `3` | `const val FREE_MINUTES = 3` | Kabhi nahi badalta |
| Wallet balance | `MutableLiveData` / `MutableStateFlow` (backing property) | Runtime pe badalta hai, UI observe karti hai |

---

## Gotchas (Meri Galtiyan)

**1. Custom getter ki jagah initializer likh diya (20 aur 21 Nov)**
```kotlin
// GALAT — object bante waqt ek baar calculate, hamesha same (-3)
val billableMinutes = (elapsedSeconds - 180) / 60

// SAHI — har access pe recompute, negative nahi
val billableMinutes: Int
    get() = ((elapsedSeconds - 180) / 60).coerceAtLeast(0)
```

**2. `val backup = list` ko copy samjha (21 Nov)**
> `=` reference copy karta hai, list nahi. Copy ke liye `toMutableList()` / `toList()`.

**3. Key aur value mix kiye (20 aur 21 Nov)**
> `"auth_token"` **key** hai (`const val`). Token ki asli value runtime pe aati hai (`val`).

**4. `List` pe `.value.add()` likha (21 Nov)**
> `.value` LiveData / StateFlow ki property hai, `List` ki nahi. `List` pe `add()` compile hi nahi hoga.

**5. Constant naam `free_minutes` likha**
> Kotlin convention: `const val` → `SCREAMING_SNAKE_CASE` (`FREE_MINUTES`).

---

## Common Interview Questions

**Q: `val` matlab immutable?**
> Nahi. `val` read-only hai: reference dobara assign nahi hota aur setter nahi hota. Object andar se badal sakta hai (`val list = mutableListOf()` pe `add()` chalta hai), aur custom getter wali `val` har access pe alag value de sakti hai.

**Q: ViewModel mein `_balance` aur `balance` do property kyun?**
> Encapsulation ke liye. Private `MutableLiveData` sirf ViewModel likhta hai, public `LiveData` UI sirf observe karti hai. Isse state ka single source of truth ViewModel rehta hai. Dono `val` hain taaki object replace na ho, warna observers purane object pe atak jaate hain.

**Q: Read-only aur immutable list mein farak?**
> `List` interface mein `add()` nahi hai, toh is reference se badal nahi sakte, yeh compile-time restriction hai. Par andar ka object `MutableList` ho sakta hai jise koi aur reference badal de. Truly immutable ke liye defensive copy (`toList()`) ya `persistentListOf()`.

**Q: Base URL `const val` mein kyun nahi rakhte?**
> Kyunki debug aur release mein alag server hota hai. `buildConfigField` se har build type ka URL `BuildConfig.BASE_URL` mein generate hota hai, toh code ek hi rehta hai. AGP 8+ mein `buildFeatures { buildConfig = true }` on karna padta hai.

---

## Interview Mein Bolna
> *"`val` use karta hoon jab reference fix rakhna ho — jaise LiveData object. `var` use karta hoon jab value change hoti rahe — jaise tracking variables. `const val` sirf compile-time constants ke liye — jaise SharedPreferences keys."*

> *"`val` read-only hai, immutable nahi: setter nahi hota, par object andar se badal sakta hai aur custom getter har access pe recompute hota hai. ViewModel mein main backing property pattern use karta hoon: `private val _balance = MutableLiveData()` aur public `val balance: LiveData`, taaki UI sirf observe kare aur state sirf ViewModel badle. Bahar list deni ho toh `List` type ke saath `toList()` copy deta hoon, kyunki `List` sirf read-only view hai. Aur environment-wise values jaise Base URL `buildConfigField` se `BuildConfig` mein aati hain, `const val` mein nahi."*

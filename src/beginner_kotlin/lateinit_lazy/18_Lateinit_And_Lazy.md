# lateinit and by lazy in Kotlin

## lateinit — Baad Mein Initialize Karunga

Compiler ko batao — "abhi value nahi, baad mein dunga."

### Rules
1. Sirf `var` pe — `val` pe nahi
2. Sirf class body mein — constructor mein nahi
3. Sirf non-primitive — `String`, custom class OK — `Int`, `Boolean` nahi
4. Use karne se pehle initialize karna zaroori — warna `UninitializedPropertyAccessException`

```kotlin
// DKScore — Fragment mein
private lateinit var binding: FragmentBinding

override fun onCreateView(...): View {
    binding = FragmentBinding.inflate(layoutInflater)  // yahan initialize
    return binding.root
}

// DKScore — Activity mein
private lateinit var adapter: PlanetAdapter

override fun onCreate(...) {
    adapter = PlanetAdapter(planetList)  // data aane ke baad initialize
    recyclerView.adapter = adapter
}
```

### isInitialized Check
```kotlin
if (::binding.isInitialized) {
    binding.textView.text = "Hello"
}
```

### Kyun Primitive Pe Nahi
```kotlin
lateinit var count: Int  // Error! — Int ka default 0 hota hai
lateinit var name: String  // OK — String ka koi default nahi
```

---

## by lazy — Pehli Access Pe Initialize

Value automatically initialize hoti hai jab **pehli baar access karo**.

```kotlin
// Retrofit — pehli baar use karo tab bnega
val retrofit: Retrofit by lazy {
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .build()
}

// Gson
val gson: Gson by lazy { Gson() }
```

### Kyun Use Karein
Startup time save — heavy object tab bane jab zaroori ho, pehle nahi.

---

## lateinit vs by lazy

| | `lateinit` | `by lazy` |
|---|---|---|
| Keyword | `var` | `val` |
| Kab initialize | Tu khud kare | Pehli access pe automatic |
| Use case | View binding, Adapter | Heavy objects — Retrofit, Gson |
| Thread safe | Nahi | Haan (by default) |

---

## Interview Mein Bolna
> *"`lateinit` use karta hoon jab object baad mein initialize hoga — jaise Fragment mein `binding` jo `onCreateView` mein milti hai. `by lazy` use karta hoon heavy objects ke liye — jaise Retrofit — taaki startup time save ho aur object tab bane jab pehli baar actually use ho."*

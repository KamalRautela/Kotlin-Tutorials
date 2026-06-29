# Object vs Companion Object in Kotlin

## Difference

| | `object` | `companion object` |
|---|---|---|
| Kahan | Top-level ya class ke andar | Sirf class ke andar |
| Access | Object naam se | Class naam se |
| Use case | Singleton | Static members (constants, factory methods) |

---

## object — Singleton

Sirf ek instance — poori app mein reuse hota hai.

```kotlin
// DKScore — AppModule.kt
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }
}

// Access
AppModule.provideContext(app)
```

---

## companion object — Static Members

Class ke andar — class naam se access karte hain.

```kotlin
// DKScore — AppCache.kt
class AppCache {
    companion object {
        const val KEY_AUTH_TOKEN = "auth_token"
        const val PREF_NAME = "dkscore_prefs"
        const val KEY_LANGUAGE = "language"
    }
}

// Access — object banane ki zaroorat nahi
AppCache.KEY_AUTH_TOKEN
AppCache.PREF_NAME
```

---

## const val Kahan Declare Kar Sakte Hain

1. `companion object` ke andar
2. `object` (singleton) ke andar
3. Top-level — file mein, kisi class ke bahar

```kotlin
// Top-level
const val BASE_URL = "https://api.dkscore.com"

// companion object
class ApiService {
    companion object {
        const val TIMEOUT = 30L
    }
}

// object
object Constants {
    const val MAX_RETRY = 3
}
```

---

## Interview Mein Bolna
> *"`object` use karta hoon jab Singleton chahiye — jaise Hilt modules ya utility classes. `companion object` use karta hoon class ke static members ke liye — jaise constants aur factory methods. Dono mein object banane ki zaroorat nahi hoti — directly naam se access karte hain."*

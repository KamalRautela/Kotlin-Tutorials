# Generics in Kotlin

## Kya Hai?
Ek class ya function jo **kisi bhi type** ke saath kaam kare — type placeholder use karta hai.

---

## Bina Generics — Problem

```kotlin
// Har type ke liye alag class — bahut repetition
class UserResource(val data: User?)
class PlanetResource(val data: Planet?)
class HoroscopeResource(val data: Horoscope?)
// 100+ API calls = 100+ classes!
```

---

## Generics Se — Solution

```kotlin
// DKScore — Resource.kt
class Resource<T>(
    val status: Status,
    val data: T?,
    val message: String?
)

// T ki jagah actual type
val userResource = Resource<User>(Status.SUCCESS, userData, null)
val planetResource = Resource<Planet>(Status.SUCCESS, planetData, null)
```

---

## Generic Class — Custom Example

```kotlin
class ApiResponse<T>(
    val data: T?,
    val code: Int,
    val message: String?
)

// Use karna
val stringResponse = ApiResponse<String>(data = "Hello", 200, null)
val intResponse = ApiResponse<Int>(data = 42, 200, null)
```

---

## Generic Function

```kotlin
fun <T> makeApiRequest(apiCall: () -> T): T {
    return apiCall()
}

// String return karega
val name = makeApiRequest<String> { "Kamal" }

// Int return karega
val count = makeApiRequest<Int> { 42 }
```

---

## DKScore Real Use

```kotlin
// AppViewModel.kt
val response: Resource<TokenData> = appRepository.refreshToken()
// T = TokenData — compile time pe type safe

val planets: Resource<List<Planet>> = repository.getPlanets()
// T = List<Planet>
```

---

## Kyun Use Karein

- Code reuse — ek class/function multiple types handle kare
- Type safety — compile time pe type check hota hai
- DRY principle — Don't Repeat Yourself

---

## Interview Mein Bolna
> *"Generics use karta hoon jab ek class ya function multiple types ke saath kaam kare. DKScore mein `Resource<T>` ek generic wrapper class hai — `Resource<User>`, `Resource<Planet>` sab ek hi class se handle hote hain. Type safety compile time pe ensure hoti hai."*

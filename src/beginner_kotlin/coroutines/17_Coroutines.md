# Coroutines in Kotlin

## Kya Hai?
Lightweight threads — heavy tasks (network, database) background mein karo, Main thread free rakho.

**Problem bina coroutines ke:**
```kotlin
// Main thread pe API call — App FREEZE!
fun loadData() {
    val response = api.getUser()  // 2-3 second — UI respond nahi karega — ANR
}
```

**Solution — Coroutines:**
```kotlin
viewModelScope.launch(Dispatchers.IO) {
    val response = api.getUser()  // background thread — UI responsive
}
```

---

## Dispatchers — Kaunse Thread Pe

| Dispatcher | Kab Use Karein |
|---|---|
| `Dispatchers.IO` | Network calls, Database |
| `Dispatchers.Main` | UI update |
| `Dispatchers.Default` | Heavy calculations |

```kotlin
viewModelScope.launch(Dispatchers.IO) {
    val response = api.getUser()         // IO thread — network call

    withContext(Dispatchers.Main) {
        textView.text = response.name    // Main thread — UI update
    }
}
```

---

## suspend Function

Function jo coroutine mein chalega — thread block nahi karega.

```kotlin
// DKScore — AppRepository.kt
suspend fun refreshToken(): Resource<TokenData> {
    return apiService.refreshToken()  // network call
}
```

**Rule:** `suspend` function sirf coroutine ya doosre `suspend` function se call ho sakta hai.

---

## launch vs async

| | `launch` | `async` |
|---|---|---|
| Result | Nahi chahiye | Chahiye — `await()` se lo |
| Use case | Fire and forget | Parallel tasks |

```kotlin
// launch — result nahi chahiye
viewModelScope.launch {
    appRepository.saveUser(user)
}

// async — result chahiye, parallel
// DKScore — CallChatHistoryViewModel.kt
coroutineScope {
    val title = async { appRepository.translateText(it.title) }
    val desc = async { appRepository.translateText(it.text) }
    // Dono parallel chalenge

    it.title = title.await()   // result lo
    it.text = desc.await()
}
```

---

## Scopes — Kab Kaunsa

| Scope | Kab Use Karein |
|---|---|
| `viewModelScope` | ViewModel mein — most common |
| `lifecycleScope` | Fragment/Activity mein |
| `coroutineScope` | Suspend function ke andar |

```kotlin
// DKScore — AppViewModel.kt
fun refreshToken() {
    viewModelScope.launch(Dispatchers.IO) {
        val response = appRepository.refreshToken()
        _refreshTokenLiveData.postValue(response)
    }
}
```

**`viewModelScope` kyun:** ViewModel destroy hone pe sab coroutines automatically cancel — memory leak nahi.

**`GlobalScope` avoid karo** — ViewModel destroy ho gaya par coroutine chal raha hai — memory leak!

---

## DKScore Real Pattern

```kotlin
// ViewModel mein standard pattern
fun loadUserData() {
    viewModelScope.launch(Dispatchers.IO) {      // background thread
        val response = appRepository.getUser()   // suspend function call
        _userLiveData.postValue(response)         // LiveData automatically Main thread
    }
}
```

---

## Interview Mein Bolna
> *"Coroutines lightweight threads hain jo background tasks ke liye use hote hain — network calls, database operations. `viewModelScope` use karta hoon kyunki ViewModel destroy hone pe coroutines automatically cancel ho jaate hain — memory leak nahi hota. `launch` fire-and-forget ke liye, `async`+`await()` parallel tasks ke liye jahan result chahiye."*

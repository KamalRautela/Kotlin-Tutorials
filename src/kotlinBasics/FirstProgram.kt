package kotlinBasics

fun main() {
    // main() JVM ke liye entry point hota hai, Android mein onCreate() use hota hai

    // Console me ek line print karta hai aur cursor next line par chala jata hai
    println("My name is Kamal")

    // Console me bina new line ke 1+3 ka output print karega (4)
    print(1 + 3)

    // Console me bina new line ke ek character print karega ('K')
    print('K')
}

/*
Compilation Process:
- Kotlin code ko 'kotlinc-jvm' compiler se JVM compatible .class (bytecode) files me convert kiya jata hai.
- JVM, in .class files ko Just-In-Time (JIT) compiler ya interpreter se machine code me convert karta hai.
- Android apps me ye process thoda different hai; Kotlin bytecode ko Dalvik/ART ke liye optimized DEX bytecode me convert kiya jata hai.
- IDE me Tools -> Kotlin -> Show Kotlin Bytecode -> Decompile in Java se hum Kotlin code ka equivalent Java code dekh sakte hain.

Android me:
- 'main' function ki jagah 'onCreate()' method se execution shuru hota hai.
- Console output ke bajaye Log.d() ya Toast use karke user ko message dikhate hain.
*/

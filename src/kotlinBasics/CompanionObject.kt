package kotlinBasics

fun main() {
    MyClass.f()
    MyClass.AnotherObject.f()
}

class MyClass {
    companion object MyObject {
        @JvmStatic
        fun f() = println("Hello MyObject")
    }

    object AnotherObject {
        fun f() = println("Hello AnotherObject")
    }
}
//Understand the factory pattern example for companion object
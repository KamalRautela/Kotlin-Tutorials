package kotlinBasics

fun main() {
    val obj = Outer()
    obj.i

    val obj2 = Outer().Nested()
    obj2.test()

}

class Outer {

    var i = 0

    inner class Nested {
        fun test() {
            println("I am in nested - $i")
        }
    }
}
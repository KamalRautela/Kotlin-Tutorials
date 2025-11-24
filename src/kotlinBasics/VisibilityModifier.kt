package kotlinBasics

fun main() {
    val obj = Students()
    val obj1 = Kamal()
}

open class Students() {
    public val c = 10
    private val d = 10
    internal val e = 19
    protected val f = 15
}

class Kamal: Students() {
    fun test() {
        print(c)
//        print(d)
        print(e)
        print(f)
    }
}
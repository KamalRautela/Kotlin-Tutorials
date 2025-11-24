package kotlinBasics

fun main() {
    val p1 = Office(1,"John")
    val p2 = Office(1,"John")

    println(p1)
    println(p2)
    println(p2.hashCode())
    println(p1.hashCode())
    println(p1 == p2)

    val p3 = p1.copy(id = 4)
    println(p3)

    val(id, name) = p1
    println(id)

    println(p1.component1())
}

data class Office(val id: Int, val name: String) {

}
package kotlinBasics

fun main() {
    val ferrari = Car("Ferrari","Deisal",100)
    println(ferrari.name)
    println(ferrari.kmRan)

    ferrari.driveCar()

    val i = 89
    println(i.plus(30))
}

class Car(//Properties
    val name: String,
    val type: String,
    var kmRan: Int
) {
    fun driveCar() {//methods
        println("Driving.....")
    }

    fun applyBrake() {
        println("Stopping......")
    }

    fun applyGear() = println("Gear Applied")
}
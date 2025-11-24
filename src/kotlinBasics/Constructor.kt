package kotlinBasics

fun main() {
    // Object creation: init block automatic run hota hai
    val car = Automobile("Maruti", 4)      // Output: Maruti is Created
    val p1 = Person("Kamal", 25)           // Output: 2nd Initializer block
    val s1 = Student("a", 67, "Easy")      // Uses primary constructor
    val s3 = Student("",45,"")

    // Secondary constructor: additional initialization (rollNo = 102)
    val s2 = Student("Ankit", "Diesel")    // Calls secondary constructor, then init block
}

// Class with primary constructor and init block
class Automobile(val name: String, val tyres: Int) {
    fun drive() {
        // Custom Drive logic here
    }
    init {
        println("$name is Created")        // Initialization message
    }
}

// Class with primary constructor and manual property assignment + init block
class Person(nameParams: String, ageParams: Int) {
    val name: String = nameParams
    var age: Int = ageParams

    init {
        println("2nd Initializer block")   // Custom logic during object creation
    }
}

// Student class with primary and secondary constructor
class Student(
    val studName: String,
    val rollNo: Int,
    val engineType: String
) {
    // Secondary constructor providing default value for rollNo
    constructor(nameParam: String, engineParam: String): this(nameParam, 102, engineParam)

    init {
        println("$studName $rollNo $engineType")
    }
}

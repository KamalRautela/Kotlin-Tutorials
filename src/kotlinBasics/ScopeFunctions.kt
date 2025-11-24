package kotlinBasics

fun main() {
    val emp = Employee()
    emp.age = 19
    emp.name = "Kamal"

    /*
    // let function: object ko 'it' reference ke through scope me laata hai, mostly non-null checks me use hota hai
    emp.let {
        println(it.name)  // emp.name print karta hai
        println(it.age)   // emp.age print karta hai
    }
    */

    /*
    // with function: object ko receiver banata hai (is type ke jaise), direct properties ko access/modify kar sakte ho
    with(emp) {
        age = 90
        name = "K"
    }
    */

    // Run function: receiver object ko scope me laata hai, aur last expression ko return karta hai
    emp.run {
        age = 4
        name = "Kam"
        // yahan run ka return agar chahie to use kar sakte ho
    }

    /*
    // Apply function: receiver object ke saath kaam karta hai aur khud receiver (emp2) return karta hai
    val emp2 = Employee()
    val x = emp2.apply {
        name = "Anil"
        age = 20
    }
    println(x)  // emp2 object print hoga with updated properties
    */

    /*
    val emp1 = Employee("Rahul", 18)

    println(emp)
    println(emp1)
    println(emp2)
    */
}

// Data class for easy object creation and readable print
data class Employee(var name: String = "", var age: Int = 19)

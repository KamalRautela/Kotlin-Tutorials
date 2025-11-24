package kotlinBasics

fun main() {
    val a = 5
    val b = 6

    // Arithmetic Operators
    println(a + b)  //  11
    println(a - b)  //  -1
    println(a * b)  //  30
    println(b / a)  //  1
    println(a.toFloat() % b)  //  5

    // Relational Operators
    println(a > b)
    println(a < b)
    println(a == b)
    println(b != a)
    println(a <= b)
    println(a >= b)

    //  Increment Operator
    var i = 7
    println(i++)        // Post increment means first print then add 1
    println(i)
    println(++i)        // Pre increment means first add 1 the print

    var j = 10
    println(j++ + ++j)

    // Logical operator is used when working with boolean codes
    val above70 = false
    val knowsProgramming = true

    var calledForInterview =
        above70 && knowsProgramming    // prints false if anyone or both variables have false otherwise true
    println(calledForInterview)

    calledForInterview =  above70 || knowsProgramming
    println(calledForInterview)     // prints true if one of the variables have true

    var c = 10
    var d = 12

    val result = c == 10 || ++d == 12
    println(d)      // This is Short circuiting means that if first condition true compiler does not check second condition

    val answer = false
    val r = !answer
    print(r)
}
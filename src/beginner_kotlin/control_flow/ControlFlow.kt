package beginner_kotlin.control_flow

fun main() {
    val score = 85

    // if/else as expression
    val gradeIfElse = if (score >= 85) "A"
    else if (score >= 70) "B"
    else if (score >= 55) "C"
    else "D"
    println("if/else grade: $gradeIfElse")

    // when as expression — preferred, more readable with multiple conditions
    val gradeWhen = when {
        score >= 85 -> "A"
        score >= 70 -> "B"
        score >= 55 -> "C"
        else -> "D"
    }
    println("when grade: $gradeWhen")

    // when — type check on Any variable
    val data: Any = 42
    when (data) {
        is String -> println("$data is String type")
        is Int -> println("$data is Int type")
        is Double -> println("$data is Double type")
        is Boolean -> println("$data is Boolean type")
    }
}
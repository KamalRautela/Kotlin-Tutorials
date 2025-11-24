package kotlinBasics

fun main() {
    /*val day = Day.MONDAY
    println(day.number)

    for (i in Day.entries) {
        println(i)
    }

    day.printFormatedDay()*/

    val tile: Tile = Red("Mushroom",26)
    val tile2 = Blue(29)
//    println("${tile.points} - ${tile.name}")

    val points = when(tile) {
        is Red -> tile.points * 2
        is Blue -> tile.points * 4
    }

    println(points)

}

enum class Day(val number: Int) {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3);

    fun printFormatedDay() {
        println("Day is $this")
    }
}

sealed class Tile
class Red(val name: String, val points: Int) : Tile()
class Blue(val points: Int) : Tile()
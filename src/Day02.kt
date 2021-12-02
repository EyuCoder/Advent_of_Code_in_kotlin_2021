fun main() {
    fun part1(input: List<String>): Int {
        var horizontalPosition = 0
        var depthPosition = 0
        for (direction in input) {
            val directionTrimmed = direction.trim()
            val (directionString, valueString) = directionTrimmed.split(" ")
            when (directionString) {
                "forward" -> horizontalPosition += valueString.toInt()
                "down" -> depthPosition += valueString.toInt()
                "up" -> depthPosition -= valueString.toInt()
                else -> println("Got a bad direction : $directionString")
            }
        }
        return horizontalPosition * depthPosition
    }

    fun part2(input: List<String>): Int {
        var horizontalPosition = 0
        var depth = 0
        var aim = 0
        for (direction in input) {
            val directionTrimmed = direction.trim()
            val (directionString, valueString) = directionTrimmed.split(" ")
            when (directionString) {
                "forward" -> {
                    horizontalPosition += valueString.toInt()
                    depth += valueString.toInt() * aim
                }
                "down" -> aim += valueString.toInt()
                "up" -> aim -= valueString.toInt()
                else -> println("Got a bad direction : $directionString")
            }
        }
        return horizontalPosition * depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
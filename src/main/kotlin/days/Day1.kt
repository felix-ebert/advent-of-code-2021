package days

// source: https://todd.ginsberg.com/post/advent-of-code/2021/day1/
class Day1 : Day(1) {

    override fun partOne(): Any {
        // docs: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/zip-with-next.html
        return inputList
            .map { it.toInt() }
            .zipWithNext()
            .count { it.first < it.second }
    }

    override fun partTwo(): Any {
        // docs: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/windowed.html
        return inputList
            .map { it.toInt() }
            .windowed(3, 1)
            .map { it.sum() }
            .zipWithNext()
            .count { it.first < it.second }
    }
}

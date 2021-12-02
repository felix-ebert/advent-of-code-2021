package days

class Day2 : Day(2) {

    override fun partOne(): Any {
        var horizontal = 0
        var depth = 0

        inputList.asSequence().forEach {
            val value = it.substringAfter(" ").toInt()
            when (it.substringBefore(" ")) {
                "forward" -> horizontal += value
                "down" -> depth += value
                "up" -> depth -= value
            }
        }

        return horizontal * depth
    }

    override fun partTwo(): Any {
        var horizontal = 0
        var depth = 0
        var aim = 0

        inputList.asSequence().forEach {
            val value = it.substringAfter(" ").toInt()
            when (it.substringBefore(" ")) {
                "forward" -> {
                    horizontal += value
                    depth += aim * value
                }
                "down" -> aim += value
                "up" -> aim -= value
            }
        }

        return horizontal * depth
    }
}

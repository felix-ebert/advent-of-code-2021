package days

class Day5 : Day(5) {

    data class Position(val x: Int, val y: Int)

    override fun partOne(): Any {
        val maxPosition = inputList.flatMap { it.split(" -> ", ",").map { str -> str.toInt() } }.maxOrNull()!!.plus(1)
        val grid = Array(maxPosition) { IntArray(maxPosition) }

        inputList.forEach { line ->
            val start = line.substringBefore(" -> ").split(',').zipWithNext()
                .map { Position(it.first.toInt(), it.second.toInt()) }.first()
            val end = line.substringAfter(" -> ").split(',').zipWithNext()
                .map { Position(it.first.toInt(), it.second.toInt()) }.first()

            if (start.x == end.x) {
                val y1 = minOf(start.y, end.y)
                val y2 = maxOf(start.y, end.y)

                for (y in y1..y2) {
                    grid[y][start.x]++
                }
            }

            if (start.y == end.y) {
                val x1 = minOf(start.x, end.x)
                val x2 = maxOf(start.x, end.x)

                for (x in x1..x2) {
                    grid[start.y][x]++
                }
            }
        }

        return grid.flatMap { it.asIterable() }.count { it >= 2 }
    }

    override fun partTwo(): Any {
        return "todo"
    }
}

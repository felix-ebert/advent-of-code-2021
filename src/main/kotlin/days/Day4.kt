package days

class Day4 : Day(4) {

    private val scores = getScores()

    override fun partOne(): Any {
        return scores.first
    }

    override fun partTwo(): Any {
        return scores.second
    }

    private fun parseDrawnNumbers(str: String): List<Int> {
        val regex = Regex("\\d+")
        return regex.findAll(str).map { it.value.toInt() }.toList()
    }

    private fun parseBoards(): List<List<MutableList<Pair<Int, Boolean>>>> {
        val boards = arrayListOf<List<MutableList<Pair<Int, Boolean>>>>()
        var board = arrayListOf<MutableList<Pair<Int, Boolean>>>()

        for (i in 2 until inputList.size) {
            if (inputList[i].isEmpty()) {
                boards.add(board)
                board = arrayListOf()
                continue
            }

            val numbersWithBoolean = parseDrawnNumbers(inputList[i]).map { Pair(it, false) }.toMutableList()
            board.add(numbersWithBoolean)
        }

        boards.add(board)
        return boards
    }

    private fun getScores(): Pair<Int, Int> {
        val drawnNumbers = parseDrawnNumbers(inputList[0])
        val boards = parseBoards()
        val boardsWon = mutableSetOf<Int>()
        val scores = mutableListOf<Int>()

        drawnNumbers.forEach { drawnNumber ->
            boards.forEachIndexed { boardNumber, board ->
                board.forEach { row ->
                    row.forEachIndexed { x, number ->
                        if (number.first == drawnNumber) {
                            row[x] = row[x].copy(second = true)
                        }
                        if (board.map { it[x] }.all { it.second } || row.all { it.second }) {
                            if (boardsWon.add(boardNumber)) {
                                scores.add(board.flatten().filter { !it.second }.sumOf { it.first } * drawnNumber)
                            }
                        }
                    }
                }
            }
        }

        return Pair(scores.first(), scores.last())
    }
}

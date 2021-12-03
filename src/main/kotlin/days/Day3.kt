package days

class Day3 : Day(3) {

    override fun partOne(): Any {
        var gamma = ""
        var epsilon = ""

        for (i in inputList[0].indices) {
            gamma += inputList.groupingBy { it[i] }.eachCount().maxWithOrNull(compareBy { it.value })?.key
            epsilon += inputList.groupingBy { it[i] }.eachCount().minWithOrNull(compareBy { it.value })?.key
        }

        return gamma.toInt(2) * epsilon.toInt(2)
    }

    override fun partTwo(): Any {
        val o2Rating = getRating(inputList, true)
        val co2Rating = getRating(inputList, false)
        return o2Rating * co2Rating
    }

    private fun getRating(input: List<String>, isMostCommonRating: Boolean): Int {
        var report = input

        for (i in input[0].indices) {
            val mostCommonBit = report.groupingBy { it[i] }.eachCount().maxWithOrNull(compareBy { it.value })?.key
            val leastCommonBit = report.groupingBy { it[i] }.eachCount().minWithOrNull(compareBy { it.value })?.key

            val bitCriteria = if (mostCommonBit != leastCommonBit) {
                if (isMostCommonRating) {
                    mostCommonBit!!
                } else {
                    leastCommonBit!!
                }
            } else {
                if (isMostCommonRating) {
                    '1'
                } else {
                    '0'
                }
            }

            if (report.size > 1) {
                report = report.filter { it[i] == bitCriteria }
            }
        }

        return report[0].toInt(2)
    }

}

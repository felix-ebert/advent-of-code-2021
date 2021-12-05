package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test

class Day5Test {

    private val day = Day5()

    @Test
    fun testPartOne() {
        assertThat(day.partOne(), `is`(5))
    }

    @Test
    fun testPartTwo() {
        assertThat(day.partTwo(), `is`(12))
    }
}

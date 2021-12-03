package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test

class Day3Test {

    private val day = Day3()

    @Test
    fun testPartOne() {
        assertThat(day.partOne(), `is`(198))
    }

    @Test
    fun testPartTwo() {
        assertThat(day.partTwo(), `is`(230))
    }
}

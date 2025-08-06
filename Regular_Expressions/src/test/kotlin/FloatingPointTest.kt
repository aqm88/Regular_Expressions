import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class FloatingPointTest {

    @Test
    fun testValidFloatingPoints() {
        // Valid: non-zero followed by digits and a period and more digits
        assertTrue(isValidFloatingPoint("1.0"))
        assertTrue(isValidFloatingPoint("123.456"))
        assertTrue(isValidFloatingPoint("9.9"))
        assertTrue(isValidFloatingPoint("0.1"))
        assertTrue(isValidFloatingPoint("0.123456789"))
    }

    @Test
    fun testInvalidFloatingPoints_missingDigitsAfterPeriod() {
        // Valid transitions until missing digits after period
        assertFalse(isValidFloatingPoint("1."))
        assertFalse(isValidFloatingPoint("123."))
    }

    @Test
    fun testInvalidFloatingPoints_noPeriod() {
        // No period, so not a floating point
        assertFalse(isValidFloatingPoint("123"))
        assertFalse(isValidFloatingPoint("0"))
        assertFalse(isValidFloatingPoint("5"))
    }

    @Test
    fun testInvalidFloatingPoints_invalidCharacters() {
        // Contain letters or other invalid characters
        assertFalse(isValidFloatingPoint("1.a"))
        assertFalse(isValidFloatingPoint("a.1"))
        assertFalse(isValidFloatingPoint("1.0.1"))
        assertFalse(isValidFloatingPoint("1,0"))
    }

    @Test
    fun testInvalidFloatingPoints_emptyOrSingleChar() {
        assertFalse(isValidFloatingPoint(""))
        assertFalse(isValidFloatingPoint("."))
    }

    @Test
    fun testValidFloatingPoints_startWithZeroAndPeriod() {
        assertTrue(isValidFloatingPoint("0.1"))
        assertTrue(isValidFloatingPoint("0.123"))
    }

    @Test
    fun testAllStateTransitionsAndBranches() {
        // Covers: FirstValueState_FP -> HasDigitState_FP -> HasPeriodState_FP -> ValidState_FP
        assertTrue(isValidFloatingPoint("1.2"))

        // Covers: FirstValueState_FP -> ZeroFirstState_FP -> HasPeriodState_FP -> ValidState_FP
        assertTrue(isValidFloatingPoint("0.3"))

        // Covers: HasDigitState_FP stays in same state with more digits
        assertFalse(isValidFloatingPoint("12a"))  // invalid transition

        // Covers: HasPeriodState_FP with non-digit goes to InvalidState_FP
        assertFalse(isValidFloatingPoint("1.a"))

        // Covers: ValidState_FP with digit remains in same state
        assertTrue(isValidFloatingPoint("1.23456789"))

        // Covers: ValidState_FP with invalid char becomes InvalidState_FP
        assertFalse(isValidFloatingPoint("1.0a"))

        // Covers: HasPeriodState_FP followed by invalid (non-digit)
        assertFalse(isValidFloatingPoint("1."))

        // Covers: ZeroFirstState_FP followed by invalid char (not '.')
        assertFalse(isValidFloatingPoint("0a"))
    }
}

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IntegerTest {

    @Test
    fun testValidIntegers() {
        assertTrue(isValidInteger("1"))
        assertTrue(isValidInteger("123"))
        assertTrue(isValidInteger("9"))
        assertTrue(isValidInteger("567890"))
    }

    @Test
    fun testInvalid_emptyAndZero() {
        // Empty string
        assertFalse(isValidInteger(""))

        // Starts with zero — not valid
        assertFalse(isValidInteger("0"))

        // Multiple digits starting with zero
        assertFalse(isValidInteger("0123"))
    }

    @Test
    fun testInvalid_nonDigitCharacters() {
        // Non-digit at the start
        assertFalse(isValidInteger("a123"))

        // Digit followed by invalid character
        assertFalse(isValidInteger("1a"))

        // Mixed invalid input
        assertFalse(isValidInteger("2.3"))
        assertFalse(isValidInteger("4,5"))
        assertFalse(isValidInteger("6 7"))
        assertFalse(isValidInteger("7-1"))
    }

    @Test
    fun testAllStatePaths() {
        // FirstValueState_INT -> ValidState_INT (with more digits)
        assertTrue(isValidInteger("8"))
        assertTrue(isValidInteger("81"))

        // ValidState_INT stays in same state on digit
        assertTrue(isValidInteger("123456789"))

        // ValidState_INT to InvalidState_INT on invalid char
        assertFalse(isValidInteger("5a"))

        // FirstValueState_INT directly to InvalidState_INT
        assertFalse(isValidInteger("0"))
        assertFalse(isValidInteger("z"))
    }
}

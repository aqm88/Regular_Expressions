import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class BinaryTest {

    @Test
    fun testValidBinaryStrings() {
        assertTrue(isValidBinary("1"))             // Single digit
        assertTrue(isValidBinary("11"))            // All 1s
        assertTrue(isValidBinary("101"))           // 1-0-1
        assertTrue(isValidBinary("1001"))          // Has 0s in middle
        assertTrue(isValidBinary("10011010001"))   // Long valid binary
    }

    @Test
    fun testInvalidBinaryStrings_wrongStartOrEnd() {
        assertFalse(isValidBinary(""))             // Empty string
        assertFalse(isValidBinary("0"))            // Starts with 0
        assertFalse(isValidBinary("01"))           // Starts with 0
        assertFalse(isValidBinary("10"))           // Ends with 0
        assertFalse(isValidBinary("1000010"))      // Ends with 0
    }

    @Test
    fun testInvalidBinaryStrings_invalidCharacters() {
        assertFalse(isValidBinary("100a01"))       // Contains 'a'
        assertFalse(isValidBinary("1.1"))          // Contains '.'
        assertFalse(isValidBinary("1 1"))          // Contains space
        assertFalse(isValidBinary("1,1"))          // Contains comma
        assertFalse(isValidBinary("1-1"))          // Contains dash
        assertFalse(isValidBinary("1\n1"))         // Contains newline
    }

    @Test
    fun testStateTransitions_exhaustive() {
        // FirstValueState_BIN: transition to ValidState_BIN on '1'
        assertTrue(isValidBinary("1"))

        // FirstValueState_BIN: transition to InvalidState on '0'
        assertFalse(isValidBinary("0"))

        // ValidState_BIN: stays on '1'
        assertTrue(isValidBinary("1111"))

        // ValidState_BIN: goes to IsThereOneState_BIN on '0'
        // IsThereOneState_BIN: stays on '0', then goes back to ValidState_BIN on '1'
        assertTrue(isValidBinary("1001"))

        // IsThereOneState_BIN: remains on '0'
        assertFalse(isValidBinary("100")) // Ends in IsThereOneState_BIN

        // ValidState_BIN: goes to InvalidState on invalid char
        assertFalse(isValidBinary("1a"))

        // IsThereOneState_BIN: goes to InvalidState on invalid char
        assertFalse(isValidBinary("10a1"))
    }
}

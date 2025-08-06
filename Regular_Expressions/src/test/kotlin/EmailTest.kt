import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class EmailTest {

    @Test
    fun testValidEmails() {
        assertTrue(isValidEmail("a@b.c"))
        assertTrue(isValidEmail("john.doe@domain.com"))
        assertTrue(isValidEmail("user+123@sub.domain"))
        assertTrue(isValidEmail("{}*$.&$*(@*$%&.*&*"))
    }

    @Test
    fun testInvalidEmails_emptyOrMissingParts() {
        assertFalse(isValidEmail(""))              // Empty
        assertFalse(isValidEmail("@b.c"))          // Missing part1
        assertFalse(isValidEmail("a@.c"))          // Missing part2
        assertFalse(isValidEmail("a@b."))          // Missing part3
        assertFalse(isValidEmail("a@b"))           // Missing period and part3
    }

    @Test
    fun testInvalidEmails_multipleAtOrPeriod() {
        assertFalse(isValidEmail("a@b@c.com"))     // Two @s
        assertFalse(isValidEmail("a.b@b.b.c"))     // Multiple periods after @
    }

    @Test
    fun testInvalidEmails_withSpace() {
        assertFalse(isValidEmail("a @b.c"))        // Space before @
        assertFalse(isValidEmail("a@ b.c"))        // Space after @
        assertFalse(isValidEmail("a@b .c"))        // Space before .
        assertFalse(isValidEmail("a@b. c"))        // Space after .
        assertFalse(isValidEmail("john doe@x.y"))  // Space in part1
    }

    @Test
    fun testInvalidEmails_invalidCharactersAtInvalidPositions() {
        assertFalse(isValidEmail("@a.b"))          // Starts with @
        assertFalse(isValidEmail("a @b.c"))        // Invalid extra . before @
        assertFalse(isValidEmail("a@.b.c"))        // Period right after @
        assertFalse(isValidEmail("a@b.c."))        // Extra period at end
        assertFalse(isValidEmail("a@b..c"))        // Double period after @
        assertFalse(isValidEmail("a@b.c@"))        // @ after .
    }

    @Test
    fun testAllStatesExhaustively() {
        // FirstValueState_EM → LookForAtState_EM
        assertFalse(isValidEmail(" "))             // Space → InvalidState

        // LookForAtState_EM → AfterAtState_EM
        assertTrue(isValidEmail("a@b.c"))

        // AfterAtState_EM → LookForPeriodState_EM
        assertFalse(isValidEmail("a@.c"))          // Invalid char after @

        // LookForPeriodState_EM → AfterPeriodState_EM
        assertFalse(isValidEmail("a@b@c"))         // Extra @ in domain

        // AfterPeriodState_EM → ValidState_EM
        assertTrue(isValidEmail("x@y.z"))

        // ValidState_EM remains on valid characters
        assertTrue(isValidEmail("abc@def.xyz123"))

        // ValidState_EM fails on invalid char
        assertFalse(isValidEmail("abc@def.z y"))   // space in part3
        assertFalse(isValidEmail("abc@def.z@y"))   // extra @
        assertFalse(isValidEmail("abc@def.z."))    // extra .
    }

    @Test
    fun testDotImmediatelyAfterAt_invalid() {
        assertFalse(isValidEmail("a@.com"))  // "." after @
    }

    @Test
    fun testAtRightAfterPeriod(){
        assertFalse(isValidEmail("a@b.@c"))  // period immediately after another period
    }

    @Test
    fun testSecondAtRightAfterFirstAt(){
        assertFalse(isValidEmail("a@@b.c"))  // second @ immediately after first
    }

    @Test
    fun testSecondPeriodAfterPeriod_invalid() {
        assertFalse(isValidEmail("a@b..com"))  // extra period in part3
    }
}

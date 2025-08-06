import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse
import isValidPassword

class PasswordValidationTest {

    @Test
    fun testPasswordTooShort() {
        assertFalse(isValidPassword("a"))
        assertFalse(isValidPassword("A!12345"))
    }

    @Test
    fun testNoCapitalLetter() {
        assertFalse(isValidPassword("abcd!@#$"))
        assertFalse(isValidPassword("abcde@123"))
    }

    @Test
    fun testNoSpecialCharacter() {
        assertFalse(isValidPassword("Abcdefgh"))
        assertFalse(isValidPassword("ValidPass"))
    }

    @Test
    fun testEndsWithSpecialCharacter() {
        assertFalse(isValidPassword("Aabcde!@"))
        assertFalse(isValidPassword("GoodPass!"))
    }

    @Test
    fun testValidPassword() {
        assertTrue(isValidPassword("A!aaaaaa"))
        assertTrue(isValidPassword("P@ssword1"))
        assertTrue(isValidPassword("!Passw0rd"))
        assertTrue(isValidPassword("1234!Aabc"))
    }

    @Test
    fun testMultipleCapitalsAndSpecials() {
        assertTrue(isValidPassword("A!B@C#abc"))
        assertTrue(isValidPassword("!@#ABCabc"))
    }

    @Test
    fun testValidLookingPasswordEndingWithSpecial() {
        assertFalse(isValidPassword("!Abcdefg!"))
        assertFalse(isValidPassword("H!@#1234!"))
    }

    @Test
    fun testNeitherFoundThenCapital(){
        assertFalse(isValidPassword("aBcdefgh"))
        assertFalse(isValidPassword("12A345678"))
    }
}
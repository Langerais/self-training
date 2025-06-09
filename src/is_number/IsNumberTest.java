package is_number;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IsNumberTest {

    private final IsNumber parser = new IsNumber();

    private void assertValid(String s) {
        assertTrue(parser.isNumber(s), "Expected valid number, but got invalid: \"" + s + "\"");
    }

    private void assertInvalid(String s) {
        assertFalse(parser.isNumber(s), "Expected invalid number, but got valid: \"" + s + "\"");
    }

    @Test void testValidIntegers() {
        assertValid("0");
        assertValid("10");
        assertValid("+10");
        assertValid("-10");
    }

    @Test void testValidFloats() {
        assertValid("0.1");
        assertValid(".5");
        assertValid("3.");
        assertValid("-0.1");
        assertValid("+.8");
    }

    @Test void testValidScientific() {
        assertValid("2e10");
        assertValid("2e+10");
        assertValid("2e-10");
        assertValid("-2e10");
        assertValid("+2e10");
        assertValid("2.5e3");
        assertValid(".5e3");
        assertValid("3.e1");
        assertValid("-1.23e-10");
    }

    @Test void testInvalidNumbers() {
        assertInvalid("abc");
        assertInvalid("1a");
        assertInvalid("e9");
        assertInvalid("1e");
        assertInvalid("e");
        assertInvalid(".");
        assertInvalid("");
        assertInvalid("..");
        assertInvalid("1..0");
        assertInvalid("1e1e1");
        assertInvalid("+");
        assertInvalid("4e+");
        assertInvalid("4e-");
        assertInvalid("4e.");
        assertInvalid("4e1.2");
        assertInvalid("--6");
        assertInvalid("-+3");
        assertInvalid("95a54e53");
    }

    @Test void testValidWithWhitespace() {
        assertValid(" 2 ");
        assertValid(" -90e3   ");
        assertValid(" 3. ");
        assertValid(" .2 ");
    }

    @Test void testInvalidWithWhitespaceOrTrailingChars() {
        assertInvalid(" 1a");
        assertInvalid(" 1e1a");
        assertInvalid(" 2.3.4 ");
        assertInvalid("6e6.5");
    }

    @Test void testMaxLengthValid() {
        assertValid("1e10");
        assertValid("-1.23e+10");
        assertValid("12345678901234567890");
    }

    @Test void testMaxLengthInvalid() {
        assertInvalid("1e1e1e1e1e1e1e1e1");
        assertInvalid("abcdabcdabcdabcdabcd");
    }
}


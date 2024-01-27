package academy.kata.calculator.converteres;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RomanToArabicTest {

    // Numbers can range  from I (1)  to MMMCMXCIX (3999)
    @Nested
    public class Convert {

        @Test
        void shouldConvertRomanNumeralsToArabicNumerals_WhenPassedRomanNumeral_FromMiddleOfRange() {
            final String test = "MMXXIV";
            final int expected = 2024;

            final int actual = RomanToArabic.convert(test);

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldConvertRomanNumeralsToArabicNumerals_WhenPassedRomanNumeral_FromStartOfRange() {
            final String test = "I";
            final int expected = 1;

            final int actual = RomanToArabic.convert(test);

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldConvertRomanNumeralsToArabicNumerals_WhenPassedRomanNumeral_FromEndOfRange() {
            final String test = "MMMCMXCIX";
            final int expected = 3999;

            final int actual = RomanToArabic.convert(test);

            Assertions.assertEquals(expected, actual);
        }
    }
}
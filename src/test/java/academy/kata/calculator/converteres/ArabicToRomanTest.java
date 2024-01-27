package academy.kata.calculator.converteres;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


public class ArabicToRomanTest {
    // Numbers can range  from 1 (I)  to 3999 (MMMCMXCIX)
    @Nested
    public class Convert {

        @Test
        void shouldConvertArabicNumeralsToRomanNumerals_WhenPassedRomanNumeral_FromMiddleOfRange() {
            final int test = 2024;
            final String expected = "MMXXIV";

            final String actual = ArabicToRoman.convert(test);

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldConvertArabicNumeralsToRomanNumerals_WhenPassedRomanNumeral_FromStartOfRange() {
            final int test = 1;
            final String expected = "I";

            final String actual = ArabicToRoman.convert(test);

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldConvertArabicNumeralsToRomanNumerals_WhenPassedRomanNumeral_FromEndOfRange() {
            final int test = 3999;
            final String expected = "MMMCMXCIX";

            final String actual = ArabicToRoman.convert(test);

            Assertions.assertEquals(expected, actual);
        }
    }
}

package academy.kata.calculator;

import academy.kata.calculator.enums.NumberSystem;
import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MainTest extends TestCase {

    @Nested
    public class Calc {

        @Test
        void shouldReturnCorrectResultInArabicNumberSystem_WhenPassedExpressionArabicNumerals_AndTwoArguments_AndResultIsPositive() {
            final String test = "5 * 10";
            final String expected = "50";

            final String actual = Main.calc(test);

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnCorrectResultInArabicNumberSystem_WhenPassedExpressionArabicNumerals_AndTwoArguments_AndResultIsNegative() {
            final String test = "5 - 10";
            final String expected = "-5";

            final String actual = Main.calc(test);

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnCorrectResultInArabicNumberSystem_WhenPassedExpressionArabicNumerals_AndAnyArguments_AndResultIsPositive() {
            final String test = "5 * 10 * 10 - 1";
            final String expected = "499";

            final String actual = Main.calc(test);

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnCorrectResultInArabicNumberSystem_WhenPassedExpressionArabicNumerals_AndAnyArguments_AndResultIsNegative() {
            final String test = "5 - 8 - 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 7 * 10 * 9";
            final String expected = "1322980096";

            final String actual = Main.calc(test);

            Assertions.assertEquals(expected, actual);
        }


        @Test
        void shouldReturnCorrectResultInRomanNumberSystem_WhenPassedExpressionRomanNumerals_AndTwoArguments() {
            final String test = "V * X";
            final String expected = "L";

            final String actual = Main.calc(test);

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnCorrectResultInRomanNumberSystem_WhenPassedExpressionRomanNumerals_AndAnyArguments() {
            final String test = "V * X - I * IX";
            final String expected = "CDXLI";

            final String actual = Main.calc(test);

            Assertions.assertEquals(expected, actual);
        }
    }


    @Nested
    public class GetNumberSystem {

        @Test
        void shouldReturnArabicNumberSystem_WhenPassedExpressionArabicNumerals() {
            final String test = "1 + 2";
            final NumberSystem expected = NumberSystem.ARABIC;

            final NumberSystem actual = Main.getNumberSystem(test);

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnRomanNumberSystem_WhenPassedExpressionRomanNumerals() {
            final String test = "X + V";
            final NumberSystem expected = NumberSystem.ROMAN;

            final NumberSystem actual = Main.getNumberSystem(test);

            Assertions.assertEquals(expected, actual);
        }
    }
}
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
        void shouldReturnCorrectResultInArabicNumberSystem_WhenPassedExpressionArabicNumerals() {
            final String test = "5 * 10";
            final String expected = "50";

            final String actual = Main.calc(test);

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnCorrectResultInRomanNumberSystem_WhenPassedExpressionRomanNumerals() {
            final String test = "V * X";
            final String expected = "L";

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
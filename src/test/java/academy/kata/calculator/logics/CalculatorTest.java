package academy.kata.calculator.logics;

import academy.kata.calculator.enums.NumberSystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Nested
    public class CalculateTests {

        // ARABIC
        @Test
        void shouldReturnSumArabicNumerals_WhenPassedTwoArabicNumerals() {
            final String arg1 = "8";
            final String arg2 = "9";
            final String operand = "+";
            final NumberSystem numberSystem = NumberSystem.ARABIC;

            final int actual = Calculator.getResult(arg1, operand, arg2, numberSystem);
            final int expected = 17;

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnDifferenceArabicNumerals_WhenPassedTwoArabicNumerals() { // '-'
            final String arg1 = "8";
            final String arg2 = "9";
            final String operand = "-";
            final NumberSystem numberSystem = NumberSystem.ARABIC;

            final int actual = Calculator.getResult(arg1, operand, arg2, numberSystem);
            final int expected = -1;

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnMultiplicationArabicNumerals_WhenPassedTwoArabicNumerals() { // /*/
            final String arg1 = "8";
            final String arg2 = "9";
            final String operand = "*";
            final NumberSystem numberSystem = NumberSystem.ARABIC;

            final int actual = Calculator.getResult(arg1, operand, arg2, numberSystem);
            final int expected = 72;

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnDivisionArabicNumerals_WhenPassedTwoArabicNumerals() { // '/'
            final String arg1 = "8";
            final String arg2 = "4";
            final String operand = "/";
            final NumberSystem numberSystem = NumberSystem.ARABIC;

            final int actual = Calculator.getResult(arg1, operand, arg2, numberSystem);
            final int expected = 2;

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnDivisionArabicNumerals_AndDiscardTheRemainderOfTheDivision_WhenPassedTwoArabicNumerals() { // '/'
            final String arg1 = "9";
            final String arg2 = "8";
            final String operand = "/";
            final NumberSystem numberSystem = NumberSystem.ARABIC;

            final int actual = Calculator.getResult(arg1, operand, arg2, numberSystem);
            final int expected = 1;

            Assertions.assertEquals(expected, actual);
        }

        // ROMAN
        @Test
        void shouldReturnSumRomanNumerals_WhenPassedTwoRomanNumerals() {
            final String arg1 = "VIII";
            final String arg2 = "IX";
            final String operand = "+";
            final NumberSystem numberSystem = NumberSystem.ROMAN;

            final int actual = Calculator.getResult(arg1, operand, arg2, numberSystem);
            final int expected = 17;

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnDifferenceRomanNumerals_WhenPassedTwoRomanNumerals() { // '-'
            final String arg1 = "VIII";
            final String arg2 = "V";
            final String operand = "-";
            final NumberSystem numberSystem = NumberSystem.ROMAN;

            final int actual = Calculator.getResult(arg1, operand, arg2, numberSystem);
            final int expected = 3;

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnMultiplicationRomanNumerals_WhenPassedTwoRomanNumerals() { // /*/
            final String arg1 = "VIII";
            final String arg2 = "IX";
            final String operand = "*";
            final NumberSystem numberSystem = NumberSystem.ROMAN;

            final int actual = Calculator.getResult(arg1, operand, arg2, numberSystem);
            final int expected = 72;

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnDivisionRomanNumerals_WhenPassedTwoRomanNumerals() { // '/'
            final String arg1 = "VIII";
            final String arg2 = "IV";
            final String operand = "/";
            final NumberSystem numberSystem = NumberSystem.ROMAN;

            final int actual = Calculator.getResult(arg1, operand, arg2, numberSystem);
            final int expected = 2;

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnDivisionRomanNumerals_AndDiscardTheRemainderOfTheDivision_WhenPassedTwoArabicNumerals() { // '/'
            final String arg1 = "IX";
            final String arg2 = "VIII";
            final String operand = "/";
            final NumberSystem numberSystem = NumberSystem.ROMAN;

            final int actual = Calculator.getResult(arg1, operand, arg2, numberSystem);
            final int expected = 1;

            Assertions.assertEquals(expected, actual);
        }
    }
}
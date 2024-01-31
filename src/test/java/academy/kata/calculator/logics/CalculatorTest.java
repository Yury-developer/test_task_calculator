package academy.kata.calculator.logics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class CalculatorTest {

    @Nested
    public class CalculateTests {

        @Test
        void shouldReturnSumArabicNumerals_WhenPassedTwoArabicNumerals() {
            final int arg1 = 8;
            final int arg2 = 9;
            final String operand = "+";

            final int actual = Calculator.getResult(arg1, operand, arg2);
            final int expected = 17;

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnDifferenceArabicNumerals_WhenPassedTwoArabicNumerals() { // '-'
            final int arg1 = 8;
            final int arg2 = 9;
            final String operand = "-";

            final int actual = Calculator.getResult(arg1, operand, arg2);
            final int expected = -1;

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnMultiplicationArabicNumerals_WhenPassedTwoArabicNumerals() { // /*/
            final int arg1 = 8;
            final int arg2 = 9;
            final String operand = "*";

            final int actual = Calculator.getResult(arg1, operand, arg2);
            final int expected = 72;

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnDivisionArabicNumerals_WhenPassedTwoArabicNumerals() { // '/'
            final int arg1 = 8;
            final int arg2 = 4;
            final String operand = "/";

            final int actual = Calculator.getResult(arg1, operand, arg2);
            final int expected = 2;

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnDivisionArabicNumerals_AndDiscardTheRemainderOfTheDivision_WhenPassedTwoArabicNumerals() { // '/'
            final int arg1 = 9;
            final int arg2 = 8;
            final String operand = "/";

            final int actual = Calculator.getResult(arg1, operand, arg2);
            final int expected = 1;

            Assertions.assertEquals(expected, actual);
        }
    }
}
package academy.kata.calculator.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class RomanValidatorTest {

    @Nested
    public class IsRomanExpressionTest {

        @Test
        void shouldReturnFalse_WhenPassedEmptyLine() {
            final String test = "";

            final boolean actual = RomanValidator.isRomanExpression(test);
            Assertions.assertFalse(actual);
        }

        @Test
        void shouldReturnTrue_WhenPassedCorrectRomanExpression_WithSingleOperation() {
            final String test = "X + V";

            final boolean actual = RomanValidator.isRomanExpression(test);
            Assertions.assertTrue(actual);
        }

        @Test
        void shouldReturnFalse_WhenPassedNotCorrectRomanExpression_WithSingleOperation() {
            final String test = "X + wV";

            final boolean actual = RomanValidator.isRomanExpression(test);
            Assertions.assertFalse(actual);
        }


        @Test
        void shouldReturnTrue_WhenPassedCorrectRomanExpression_WithAnyOperation() {
            final String test = "X + V * IV";

            final boolean actual = RomanValidator.isRomanExpression(test);
            Assertions.assertTrue(actual);
        }

        @Test
        void shouldReturnFalse_WhenPassedNotCorrectRomanExpression_WithAnyOperation() {
            final String test = "X + V *t IV";

            final boolean actual = RomanValidator.isRomanExpression(test);
            Assertions.assertFalse(actual);
        }
    }


    @Nested
    public class RemoveRomanNumsFromExpressionTest {

        @Test
        void shouldReturnExceptionWithoutOperations_WhenPassedCorrectExpression_WithSingleOperation() {
            final String test = "X + V";
            final String expected = "X  V";

            final String actual = RomanValidator.removeOperationsFromExpression(test);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnExceptionWithoutOperations_WhenPassedCorrectExpression_WithAnyOperations() {
            final String test = "X + II * I / V - II";
            final String expected = "X  II  I  V  II";

            final String actual = RomanValidator.removeOperationsFromExpression(test);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnExceptionWithoutOperations_WhenPassedNotCorrectExpression_WithAnyOperations() {
            final String test = " I +/+-* III */ V IV I  -- 4   ";
            final String expected = " I  III  V IV I   4   ";

            final String actual = RomanValidator.removeOperationsFromExpression(test);
            Assertions.assertEquals(expected, actual);
        }
    }
}
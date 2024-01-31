package academy.kata.calculator.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    private static final AbstractValidator ARABIC_VALIDATOR = new RomanValidator();

    @Nested
    public class RemoveOperationsFromExpressionTest {

        @Test
        void shouldReturnFalse_WhenPassedEmptyLine() {
            final String test = "";

            final boolean actual = ARABIC_VALIDATOR.isIt(test);
            Assertions.assertFalse(actual);
        }

        @Test
        void shouldReturnExceptionWithoutOperations_WhenPassedCorrectArabicExpression_WithSingleOperation() {
            final String test = "5 + 8";
            final String expected = "5  8";

            final String actual = ARABIC_VALIDATOR.removeOperationsFromExpression(test);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnExceptionWithoutOperations_WhenPassedCorrectArabicExpression_WithAnyOperations() {
            final String test = "5 + 8 * 9 / 2 - 4";
            final String expected = "5  8  9  2  4";

            final String actual = ARABIC_VALIDATOR.removeOperationsFromExpression(test);
            Assertions.assertEquals(expected, actual);
        }
        @Test
        void shouldReturnExceptionWithoutOperations_WhenPassedNotCorrectArabicExpression_WithAnyOperations() {
            final String test = " 5 +/+-* 8 */ 9 4 2 -- 4   ";
            final String expected = " 5  8  9 4 2  4   ";

            final String actual = ARABIC_VALIDATOR.removeOperationsFromExpression(test);
            Assertions.assertEquals(expected, actual);
        }




        @Test
        void shouldReturnExceptionWithoutOperations_WhenPassedCorrectRomanExpression_WithSingleOperation() {
            final String test = "X + I";
            final String expected = "X  I";

            final String actual = ARABIC_VALIDATOR.removeOperationsFromExpression(test);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnExceptionWithoutOperations_WhenPassedCorrectRomanExpression_WithAnyOperations() {
            final String test = "I + I * II / V - V";
            final String expected = "I  I  II  V  V";

            final String actual = ARABIC_VALIDATOR.removeOperationsFromExpression(test);
            Assertions.assertEquals(expected, actual);
        }
        @Test
        void shouldReturnExceptionWithoutOperations_WhenPassedNotCorrectRomanExpression_WithAnyOperations() {
            final String test = " V +/+-* IV */ III III II -- V   ";
            final String expected = " V  IV  III III II  V   ";

            final String actual = ARABIC_VALIDATOR.removeOperationsFromExpression(test);
            Assertions.assertEquals(expected, actual);
        }
    }
}
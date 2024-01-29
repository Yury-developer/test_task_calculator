package academy.kata.calculator.validator;

import academy.kata.calculator.exepcions.CalculatorException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class ArabicValidatorTest {
    private static final Validator ARABIC_VALIDATOR = new ArabicValidator();

    @Nested
    public class ValidateTest {

        @Test
        void shouldNotThrowCalculatorException_WhenPassedCorrectExpression() {
            final int test = 5;
            final int min = 1;
            final int max = 10;
            CalculatorException actual = null;

            try {
                ARABIC_VALIDATOR.validate(test, min, max);
            } catch (CalculatorException e) {
                actual = e;
            }

            Assertions.assertNull(actual);
        }

        @Test
        void shouldThrowCalculatorException_WhenPassedValueLessThanMinimum() {
            final int test = 5;
            final int min = 9;
            final int max = 10;
            final Class<CalculatorException> expected = CalculatorException.class;
            Class actual = null;

            try {
                ARABIC_VALIDATOR.validate(test, min, max);
            } catch (CalculatorException e) {
                actual = e.getClass();
            }

            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldThrowCalculatorException_WhenPassedValueMoreThanMaximum() {
            final int test = 5;
            final int min = 1;
            final int max = 2;
            final Class<CalculatorException> expected = CalculatorException.class;
            Class actual = null;

            try {
                ARABIC_VALIDATOR.validate(test, min, max);
            } catch (CalculatorException e) {
                actual = e.getClass();
            }

            Assertions.assertEquals(expected, actual);
        }
    }


    @Nested
    public class IsArabicExpressionTest {

        @Test
        void shouldReturnFalse_WhenPassedEmptyLine() {
            final String test = "";

            final boolean actual = ARABIC_VALIDATOR.isIt(test);
            Assertions.assertFalse(actual);
        }

        @Test
        void shouldReturnTrue_WhenPassedCorrectArabicExpression_WithSingleOperation() {
            final String test = "2 + 5";

            final boolean actual = ARABIC_VALIDATOR.isIt(test);
            Assertions.assertTrue(actual);
        }

        @Test
        void shouldReturnFalse_WhenPassedNotCorrectArabicExpression_WithSingleOperation() {
            final String test = "2 + w5";

            final boolean actual = ARABIC_VALIDATOR.isIt(test);
            Assertions.assertFalse(actual);
        }


        @Test
        void shouldReturnTrue_WhenPassedCorrectArabicExpression_WithAnyOperation() {
            final String test = "2 + 5 * 8";

            final boolean actual = ARABIC_VALIDATOR.isIt(test);
            Assertions.assertTrue(actual);
        }

        @Test
        void shouldReturnFalse_WhenPassedNotCorrectArabicExpression_WithAnyOperation() {
            final String test = "4 + 1 *t 6";

            final boolean actual = ARABIC_VALIDATOR.isIt(test);
            Assertions.assertFalse(actual);
        }
    }


    @Nested
    public class RemoveArabicNumsFromExpressionTest {

        @Test
        void shouldReturnExceptionWithoutOperations_WhenPassedCorrectExpression_WithSingleOperation() {
            final String test = "5 + 9";
            final String expected = " + ";

            final String actual = ARABIC_VALIDATOR.removeNums(test);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnExceptionWithoutOperations_WhenPassedCorrectExpression_WithAnyOperations() {
            final String test = "8 + 7 * 7 / 8 - 9";
            final String expected = " +  *  /  - ";

            final String actual = ARABIC_VALIDATOR.removeNums(test);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void shouldReturnExceptionWithoutOperations_WhenPassedNotCorrectExpression_WithAnyOperations() {
            final String test = " 8 +/+-* 8 */ 9 6 4  -- 4   ";
            final String expected = "  +/+-*  */     --    ";

            final String actual = ARABIC_VALIDATOR.removeNums(test);
            Assertions.assertEquals(expected, actual);
        }
    }
}
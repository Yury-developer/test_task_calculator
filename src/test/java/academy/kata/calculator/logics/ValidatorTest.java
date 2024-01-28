package academy.kata.calculator.logics;

import academy.kata.calculator.exepcions.CalculatorException;
import academy.kata.calculator.validator.ArabicValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class ValidatorTest {

    @Nested
    public class Validate {

        @Test
        void shouldNotThrowCalculatorException_WhenPassedCorrectExpression() {
            final int test = 5;
            final int min = 1;
            final int max = 10;
            CalculatorException actual = null;

            try {
                ArabicValidator.validate(test, min, max);
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
                ArabicValidator.validate(test, min, max);
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
                ArabicValidator.validate(test, min, max);
            } catch (CalculatorException e) {
                actual = e.getClass();
            }

            Assertions.assertEquals(expected, actual);
        }
    }
}
package academy.kata.calculator.exepcions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CalculatorExceptionTest {

    @Test
    void shouldMustBeConstructorToThrowAnCalculatorException() {
        final CalculatorException actual = new CalculatorException("");
        Assertions.assertEquals(CalculatorException.class, actual.getClass());
    }
}
package academy.kata.calculator.logics;

import academy.kata.calculator.exepcions.CalculatorException;

import static academy.kata.calculator.constants.Constants.*;


public class Validator {

    public static void validate(int value, int min, int max) {
        if (value < min || value > max) {
            throw new CalculatorException(OUT_OF_RANGE_EXCEPTION_HEAD_MSG + value
                    + OUT_OF_RANGE_EXCEPTION_MIDDLE1_MSG + min
                    + OUT_OF_RANGE_EXCEPTION_MIDDLE2_MSG + max
                    + OUT_OF_RANGE_EXCEPTION_TAIL_MSG);
        }
    }
}

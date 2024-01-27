package academy.kata.calculator.logics;

import academy.kata.calculator.converteres.RomanToArabic;
import academy.kata.calculator.enums.NumberSystem;
import academy.kata.calculator.enums.Operations;
import academy.kata.calculator.exepcions.CalculatorException;

import static academy.kata.calculator.constants.CalculatorConstants.*;
import static academy.kata.calculator.constants.MainConstants.INTERNAL_ERROR_EXCEPTION_MSG;
import static academy.kata.calculator.logics.Validator.validate;


public class Calculator {

    public static int getResult(String arg1, String operand, String arg2, NumberSystem numberSystem) throws CalculatorException{
        int first;
        int second;

        try {
            switch (numberSystem) {
                case ARABIC:
                    first = Integer.parseInt(arg1);
                    validate(first, MIN_INPUT_ARABIC_VALUE, MAX_INPUT_ARABIC_VALUE);
                    second = Integer.parseInt(arg2);
                    validate(second, MIN_INPUT_ARABIC_VALUE, MAX_INPUT_ARABIC_VALUE);
                    break;

                case ROMAN:
                    first = RomanToArabic.convert(arg1);
                    validate(first, MIN_INPUT_ARABIC_VALUE, MAX_INPUT_ARABIC_VALUE);
                    second = RomanToArabic.convert(arg2);
                    validate(second, MIN_INPUT_ARABIC_VALUE, MAX_INPUT_ARABIC_VALUE);
                    break;

                default:
                    throw new CalculatorException(INTERNAL_ERROR_EXCEPTION_MSG);
            }
        } catch (NumberFormatException e) {
            throw new CalculatorException(NOT_INTEGER_EXCEPTION_HEAD_MSG + arg1
                    + NOT_INTEGER_EXCEPTION_MIDDLE_MSG + arg2 + NOT_INTEGER_EXCEPTION_TAIL_MSG);
        }

        Operations operation = null;
        Operations[] possibleOperations = Operations.values();
        for (Operations possible: possibleOperations) {
            if (operand.equals(possible.toString())) {
                operation = possible;
                break;
            }
        }

        if (operation == null) {
            throw new CalculatorException(IMPOSSIBLE_OPERATION_EXCEPTION_HEAD_MSG
                    + operand + IMPOSSIBLE_OPERATION_EXCEPTION_TAIL_MSG);
        }

        return operation.calculate(first, second);
    }
}

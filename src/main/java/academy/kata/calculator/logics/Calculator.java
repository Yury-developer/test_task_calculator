package academy.kata.calculator.logics;

import academy.kata.calculator.converteres.RomanToArabic;
import academy.kata.calculator.enums.NumberSystem;
import academy.kata.calculator.enums.Operations;
import academy.kata.calculator.exepcions.CalculatorException;
import academy.kata.calculator.validator.ArabicValidator;
import academy.kata.calculator.validator.RomanValidator;
import academy.kata.calculator.validator.Validator;
import static academy.kata.calculator.constants.CalculatorConstants.*;
import static academy.kata.calculator.constants.MainConstants.INTERNAL_ERROR_EXCEPTION_MSG;


public class Calculator {
    private static final Validator ARABIC_VALIDATOR = new ArabicValidator();
    private static final Validator ROMAN_VALIDATOR = new RomanValidator();

    public static int getResult(String arg1, String operand, String arg2, NumberSystem numberSystem) throws CalculatorException{
        int first;
        int second;

        try {
            switch (numberSystem) {
                case ARABIC:
                    first = Integer.parseInt(arg1);
                    ARABIC_VALIDATOR.validate(first, MIN_INPUT_ARABIC_VALUE, MAX_INPUT_ARABIC_VALUE);
                    second = Integer.parseInt(arg2);
                    ARABIC_VALIDATOR.validate(second, MIN_INPUT_ARABIC_VALUE, MAX_INPUT_ARABIC_VALUE);
                    break;

                case ROMAN:
                    first = RomanToArabic.convert(arg1);
                    ROMAN_VALIDATOR.validate(first, MIN_INPUT_ROMAN_VALUE, MAX_INPUT_ROMAN_VALUE);
                    second = RomanToArabic.convert(arg2);
                    ROMAN_VALIDATOR.validate(second, MIN_INPUT_ROMAN_VALUE, MAX_INPUT_ROMAN_VALUE);
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

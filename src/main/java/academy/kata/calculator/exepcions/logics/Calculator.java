package academy.kata.calculator.exepcions.logics;

import academy.kata.calculator.converteres.RomanToArabic;
import academy.kata.calculator.enums.NumberSystem;
import academy.kata.calculator.enums.Operations;
import academy.kata.calculator.exepcions.CalculatorException;
import static academy.kata.calculator.constants.CalculatorConstants.MAX_INPUT_ARABIC_VALUE;
import static academy.kata.calculator.constants.CalculatorConstants.MIN_INPUT_ARABIC_VALUE;
import static academy.kata.calculator.exepcions.logics.Validator.validate;


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
                    throw new CalculatorException("Внутренняя ошибка программы, неизвестная числовая система.");
            }
        } catch (NumberFormatException e) {
            throw new CalculatorException("Переданные аргументы не являются целыми числами: аргумент1 = '" + arg1 + "'; аргумент2 = '" + arg2 + "'.");
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
            throw new CalculatorException("Передана невыполнимая/ невозможная операция: '" + operand + "'.");
        }

        return operation.calculate(first, second);
    }
}

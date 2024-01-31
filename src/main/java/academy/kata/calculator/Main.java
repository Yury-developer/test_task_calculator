package academy.kata.calculator;

import academy.kata.calculator.converteres.ArabicToRoman;
import academy.kata.calculator.enums.NumberSystem;
import academy.kata.calculator.exepcions.CalculatorException;
import academy.kata.calculator.logics.Calculator;
import academy.kata.calculator.validator.ArabicValidator;
import academy.kata.calculator.validator.RomanValidator;
import academy.kata.calculator.validator.Validator;

import java.util.NoSuchElementException;
import java.util.Scanner;
import static academy.kata.calculator.constants.CalculatorConstants.*;
import static academy.kata.calculator.constants.MainConstants.*;


/**
 * @author Yury Lapitski
 * @version 2024-01-29
 */
public class Main {
    private static final Validator ARABIC_VALIDATOR = new ArabicValidator();
    private static final Validator ROMAN_VALIDATOR = new RomanValidator();

    public static String calc(String input) throws CalculatorException{
        int result;
        Scanner sc = new Scanner(input);
        final NumberSystem numberSystem = getNumberSystem(input);

        try {
            result = Calculator.getResult(sc.next(), sc.next(), sc.next(), numberSystem);
        } catch (NoSuchElementException e) {
            throw new CalculatorException(NOT_ENOUGH_ARGUMENTS_EXCEPTION_HEAD_MSG
                    + input + NOT_ENOUGH_ARGUMENTS_EXCEPTION_TAIL_MSG + e);
        }

        switch (numberSystem) {
            case ARABIC:
                return Integer.toString(result);

            case ROMAN:
                ROMAN_VALIDATOR.validate(result, MIN_OUTPUT_ROMAN_VALUE, MAX_OUTPUT_ROMAN_VALUE);
                return ArabicToRoman.convert(result);

            default:
                throw new CalculatorException(INTERNAL_ERROR_EXCEPTION_MSG);
        }
    }

    static NumberSystem getNumberSystem(String expression) throws CalculatorException{
        boolean isArabic = ARABIC_VALIDATOR.isIt(expression);
        boolean isRoman = ROMAN_VALIDATOR.isIt(expression);

        if (isArabic && !isRoman) {
            return NumberSystem.ARABIC;
        } else if (!isArabic && isRoman) {
            return NumberSystem.ROMAN;
        }

        throw new CalculatorException(INVALID_CHARACTERS_EXCEPTION_HEAD_MSG
                + expression + INVALID_CHARACTERS_EXCEPTION_TAIL_MSG);
    }
}

package academy.kata.calculator;

import academy.kata.calculator.converteres.ArabicToRoman;
import academy.kata.calculator.converteres.RomanToArabic;
import academy.kata.calculator.enums.NumberSystem;
import academy.kata.calculator.exepcions.CalculatorException;
import academy.kata.calculator.logics.Calculator;
import academy.kata.calculator.validator.*;
import java.util.Scanner;
import static academy.kata.calculator.constants.CalculatorConstants.*;
import static academy.kata.calculator.constants.MainConstants.*;


/**
 * @author Yury Lapitski
 * @version 2024-01-31
 */
public class Main {
    private static final Validator ARABIC_VALIDATOR = new ArabicValidator();
    private static final Validator ROMAN_VALIDATOR = new RomanValidator();


    public static String calc(String input) throws CalculatorException{
        String result;
        final NumberSystem numberSystem = getNumberSystem(input);

        try {
            switch (numberSystem) {
                case ARABIC:
                    result = Integer.toString(arabicCalc(input));
                    break;

                case ROMAN:
                    int resInt = romanCalc(input);
                    ROMAN_VALIDATOR.validate(resInt, MIN_OUTPUT_ROMAN_VALUE, MAX_OUTPUT_ROMAN_VALUE);
                    result = ArabicToRoman.convert(resInt);
                    break;

                default:
                    throw new CalculatorException(INTERNAL_ERROR_EXCEPTION_MSG);
            }

        } catch (NumberFormatException e) {
            throw new CalculatorException(NOT_INTEGER_EXCEPTION_HEAD_MSG + input + NOT_INTEGER_EXCEPTION_TAIL_MSG);
        }

        return result;
    }


    static NumberSystem getNumberSystem(String expression) throws CalculatorException{
        boolean isArabic = ARABIC_VALIDATOR.isIt(expression);
        boolean isRoman = ROMAN_VALIDATOR.isIt(expression);

        if (isArabic && !isRoman) {
            return NumberSystem.ARABIC;
        } else if (!isArabic && isRoman) {
            return NumberSystem.ROMAN;
        } else {
            throw new CalculatorException(INVALID_CHARACTERS_EXCEPTION_HEAD_MSG
                    + expression + INVALID_CHARACTERS_EXCEPTION_TAIL_MSG);
        }
    }


    private static int arabicCalc(String line) throws NumberFormatException{
        int result;
        int first, second;
        String operand;

        Scanner sc = new Scanner(line);
        first = Integer.parseInt(sc.next());
        ARABIC_VALIDATOR.validate(first, MIN_INPUT_ARABIC_VALUE, MAX_INPUT_ARABIC_VALUE);

        do {
            operand = sc.next();
            second = Integer.parseInt(sc.next());
            ARABIC_VALIDATOR.validate(second, MIN_INPUT_ARABIC_VALUE, MAX_INPUT_ARABIC_VALUE);
            result = Calculator.getResult(first, operand, second);
            first = result;
        } while (sc.hasNext());

        return result;
    }


    private static int romanCalc(String line) throws NumberFormatException{
        int result;
        int first, second;
        String operand;

        Scanner sc = new Scanner(line);
        first = RomanToArabic.convert(sc.next());
        ROMAN_VALIDATOR.validate(first, MIN_INPUT_ROMAN_VALUE, MAX_INPUT_ROMAN_VALUE);

        do {
            operand = sc.next();
            second = RomanToArabic.convert(sc.next());
            ROMAN_VALIDATOR.validate(second, MIN_INPUT_ROMAN_VALUE, MAX_INPUT_ROMAN_VALUE);
            result = Calculator.getResult(first, operand, second);
            first = result;
        } while (sc.hasNext());

        return result;
    }
}

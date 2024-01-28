package academy.kata.calculator;

import academy.kata.calculator.converteres.ArabicToRoman;
import academy.kata.calculator.enums.NumberSystem;
import academy.kata.calculator.exepcions.CalculatorException;
import academy.kata.calculator.logics.Calculator;
import academy.kata.calculator.validator.ArabicValidator;

import java.util.NoSuchElementException;
import java.util.Scanner;
import static academy.kata.calculator.constants.CalculatorConstants.*;
import static academy.kata.calculator.constants.MainConstants.*;


/**
 * @author Yury Lapitski
 * @version 2024-01-28
 */
public class Main {

    public static String calc(String input) throws CalculatorException{
        int result;
        Scanner sc = new Scanner(input);
        NumberSystem numberSystem = getNumberSystem(input);

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
                ArabicValidator.validate(result, MIN_INPUT_ROMAN_VALUE, MAX_INPUT_ROMAN_VALUE);
                return ArabicToRoman.convert(result);

            default:
                throw new CalculatorException(INTERNAL_ERROR_EXCEPTION_MSG);
        }
    }

    static NumberSystem getNumberSystem(String expression) throws CalculatorException{
        char ex = expression.trim().charAt(0);

        char[] possibleRomanNumerals = POSSIBLE_ROMAN_NUMERAL.toCharArray();
        for (char possible: possibleRomanNumerals) {
            if (ex == possible) {
                return NumberSystem.ROMAN;
            }
        }

        char[] possibleArabicNumerals = POSSIBLE_ARABIC_NUMERAL.toCharArray();
        for (char possible: possibleArabicNumerals) {
            if (ex == possible) {
                return NumberSystem.ARABIC;
            }
        }

        throw new CalculatorException(INVALID_CHARACTERS_EXCEPTION_HEAD_MSG
                + expression + INVALID_CHARACTERS_EXCEPTION_TAIL_MSG);
    }
}

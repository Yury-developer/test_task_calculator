package academy.kata.calculator;

import academy.kata.calculator.converteres.ArabicToRoman;
import academy.kata.calculator.enums.NumberSystem;
import academy.kata.calculator.exepcions.CalculatorException;
import academy.kata.calculator.logics.Calculator;
import academy.kata.calculator.logics.Validator;
import academy.kata.calculator.inputProcessors.InConsoleProcessor;
import academy.kata.calculator.inputProcessors.InProcessor;
import academy.kata.calculator.outputProcessors.OutConsoleProcessor;
import academy.kata.calculator.outputProcessors.OutProcessor;

import java.util.NoSuchElementException;
import java.util.Scanner;
import static academy.kata.calculator.constants.CalculatorConstants.*;
import static academy.kata.calculator.constants.MainConstants.*;


/**
 * @author Yury Lapitski
 * @version 2024-01-27
 */
public class Main {

    public static void main(String[] args) {
        InProcessor input = new InConsoleProcessor();
        OutProcessor output = new OutConsoleProcessor();

        while (true) {
            output.print(INPUT_EXAMPLE_MSG, INPUT_MSG);
            String inputLine = input.get();
            output.print(INPUT_EXPRESSION_HEAD_MSG, inputLine, INPUT_EXPRESSION_TAIL_MSG);

            if (inputLine.isEmpty()) {
                throw new CalculatorException(INPUT_EMPTY_LINE_EXCEPTION_MSG);
            }

            if (inputLine.equals("q")) {
                output.print(EXIT_MSG);
                System.exit(0);   //   completion without error, by code '0'
            }

            output.print(RESULT_MSG, calc(inputLine), "\n");
        }
    }

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
                Validator.validate(result, MIN_INPUT_ROMAN_VALUE, MAX_INPUT_ROMAN_VALUE);
                return ArabicToRoman.convert(result);

            default:
                throw new CalculatorException(INTERNAL_ERROR_EXCEPTION_MSG);
        }
    }



    private static NumberSystem getNumberSystem(String expression) throws CalculatorException{
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

        throw new CalculatorException(INVALID_CHARACTERS_EXCEPTION_HEAD_MSG + expression + INVALID_CHARACTERS_EXCEPTION_TAIL_MSG);
    }
}

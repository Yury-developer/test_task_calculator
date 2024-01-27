package academy.kata.calculator;

import academy.kata.calculator.converteres.ArabicToRoman;
import academy.kata.calculator.enums.NumberSystem;
import academy.kata.calculator.exepcions.CalculatorException;
import academy.kata.calculator.exepcions.logics.Calculator;
import academy.kata.calculator.exepcions.logics.Validator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import static academy.kata.calculator.constants.CalculatorConstants.*;


public class Main {

    public static String calc(String input) throws CalculatorException{
        int result;
        Scanner sc = new Scanner(input);
        NumberSystem numberSystem = getNumberSystem(input);

        try {
            result = Calculator.getResult(sc.next(), sc.next(), sc.next(), numberSystem);
        } catch (NoSuchElementException e) {
            throw new CalculatorException("Передано не верное выражение. В переданном выражении не хватает аргументов для вычисления.\n Выражение: '" + input + "'." + "\n Описание ошибки: " + e);
        }

        switch (numberSystem) {
            case ARABIC:
                return Integer.toString(result);

            case ROMAN:
                Validator.validate(result, MIN_INPUT_ROMAN_VALUE, MAX_INPUT_ROMAN_VALUE);
                return ArabicToRoman.convert(result);

            default:
                throw new CalculatorException("Внутренняя ошибка программы, неизвестная числовая система.");
        }
    }



    private static NumberSystem getNumberSystem(String expression) throws CalculatorException{
        char ex = expression.trim().charAt(0);

        char[] possibleRomanNumeral = "IVXLCDM".toCharArray();
        for (char possible: possibleRomanNumeral) {
            if (ex == possible) {
                return NumberSystem.ROMAN;
            }
        }

        char[] possibleArabicNumeral = "0123456789".toCharArray();
        for (char possible: possibleArabicNumeral) {
            if (ex == possible) {
                return NumberSystem.ARABIC;
            }
        }

        throw new CalculatorException("Передано некорректное выражение, присутствуют недопустимые символы: '" + expression + "'");
    }
}

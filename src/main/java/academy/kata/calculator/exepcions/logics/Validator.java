package academy.kata.calculator.exepcions.logics;

import academy.kata.calculator.exepcions.CalculatorException;


public class Validator {

    public static void validate(int value, int min, int max) {
        if (value < min || value > max) {
            throw new CalculatorException("Переданное значение '" + value + "' выходит за допустимый диапазон: [" + min + "..." + max + "]");
        }
    }

}

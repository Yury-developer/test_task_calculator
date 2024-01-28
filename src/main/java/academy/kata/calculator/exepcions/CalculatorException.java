package academy.kata.calculator.exepcions;

import static academy.kata.calculator.constants.Constants.NEXT_LINE;


public class CalculatorException extends ArithmeticException{

    public CalculatorException(String s) {
        super(NEXT_LINE + s + NEXT_LINE);
    }
}

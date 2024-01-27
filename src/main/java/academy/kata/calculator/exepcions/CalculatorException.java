package academy.kata.calculator.exepcions;

import static academy.kata.calculator.constants.InOutConstants.HEAD_CALCULATOR_EXEPTION_MSG;
import static academy.kata.calculator.constants.InOutConstants.TAIL_CALCULATOR_EXEPTION_MSG;


public class CalculatorException extends ArithmeticException{

    public CalculatorException(String s) {
        super(HEAD_CALCULATOR_EXEPTION_MSG + s + TAIL_CALCULATOR_EXEPTION_MSG);
    }
}

package academy.kata.calculator.validator;

import academy.kata.calculator.exepcions.CalculatorException;


public interface Validator {

    void validate(int value, int min, int max) throws CalculatorException;

    boolean isIt(String input);

    String removeNums(String expression);

    String removeOperationsFromExpression(String expression);
}

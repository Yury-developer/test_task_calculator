package academy.kata.calculator.validator;

import academy.kata.calculator.enums.Operations;


public abstract class Validator {

    protected static String removeOperationsFromExpression(String expression) {
        Operations[] operations = Operations.values();
        for (Operations current: operations) {
            expression = expression.replace(current.toString(), "");
        }
        return expression;
    }
}

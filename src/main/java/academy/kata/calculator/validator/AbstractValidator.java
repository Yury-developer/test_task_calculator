package academy.kata.calculator.validator;

import academy.kata.calculator.enums.Operations;


public abstract class AbstractValidator implements Validator{

    @Override
    public String removeOperationsFromExpression(String expression) {
        Operations[] operations = Operations.values();
        for (Operations current: operations) {
            expression = expression.replace(current.toString(), "");
        }
        return expression;
    }

    @Override
    public boolean isIt(String input) {
        if (input.isEmpty()) {
            return false;
        }
        String withoutOperations = removeOperationsFromExpression(input);
        String withoutNums = removeNums(withoutOperations);
        return withoutNums.trim().equals("");
    }
}

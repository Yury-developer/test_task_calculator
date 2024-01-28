package academy.kata.calculator.validator;


import static academy.kata.calculator.constants.MainConstants.POSSIBLE_ROMAN_NUMERAL;

public abstract class RomanValidator extends Validator{

    public static boolean valueValidate(String s) {

        return false;
    }

    public static boolean isRomanExpression(String input) {
        if (input.isEmpty()) {
            return false;
        }
        String withoutOperations = removeOperationsFromExpression(input);
        String withoutNums = removeRomanNumsFromExpression(withoutOperations);
        return withoutNums.trim().equals("");
    }


    static String removeRomanNumsFromExpression(String expression) {
        for (char current: POSSIBLE_ROMAN_NUMERAL.toCharArray()) {
            expression = expression.replaceAll(String.valueOf(current), "");
        }
        return expression;
    }
}

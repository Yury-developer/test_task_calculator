package academy.kata.calculator.logics;

import academy.kata.calculator.enums.Operations;
import academy.kata.calculator.exepcions.CalculatorException;
import static academy.kata.calculator.constants.CalculatorConstants.*;


public class Calculator {

    public static int getResult(int first, String operand, int second) throws CalculatorException{

        Operations operation = null;
        Operations[] possibleOperations = Operations.values();
        for (Operations possible: possibleOperations) {
            if (operand.equals(possible.toString())) {
                operation = possible;
                break;
            }
        }

        if (operation == null) {
            throw new CalculatorException(IMPOSSIBLE_OPERATION_EXCEPTION_HEAD_MSG
                    + operand + IMPOSSIBLE_OPERATION_EXCEPTION_TAIL_MSG);
        }

        return operation.calculate(first, second);
    }
}

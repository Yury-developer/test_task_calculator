package academy.kata.calculator.validator;

import academy.kata.calculator.converteres.ArabicToRoman;
import academy.kata.calculator.exepcions.CalculatorException;
import static academy.kata.calculator.constants.Constants.*;
import static academy.kata.calculator.constants.MainConstants.POSSIBLE_ROMAN_NUMERAL;


public class RomanValidator extends AbstractValidator {

    @Override
    public void validate(int value, int min, int max) throws CalculatorException {
        if (value < min || value > max) {
            throw new CalculatorException(OUT_OF_RANGE_EXCEPTION_HEAD_MSG + value
                    + OUT_OF_RANGE_EXCEPTION_MIDDLE1_MSG + ArabicToRoman.convert(min)
                    + OUT_OF_RANGE_EXCEPTION_MIDDLE2_MSG + ArabicToRoman.convert(max)
                    + OUT_OF_RANGE_EXCEPTION_TAIL_MSG);
        }
    }

    @Override
    public String removeNums(String expression) {
        for (char current: POSSIBLE_ROMAN_NUMERAL.toCharArray()) {
            expression = expression.replaceAll(String.valueOf(current), "");
        }
        return expression;
    }
}

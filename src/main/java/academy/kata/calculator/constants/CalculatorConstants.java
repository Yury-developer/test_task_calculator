package academy.kata.calculator.constants;


public final class CalculatorConstants {
    private CalculatorConstants() {
        // NOP
    }

    public static final int MIN_INPUT_ARABIC_VALUE = 1;
    public static final int MAX_INPUT_ARABIC_VALUE = 10;

    public static final int MIN_INPUT_ROMAN_VALUE = 1;
    public static final int MAX_INPUT_ROMAN_VALUE = 10;

    public static final int MIN_OUTPUT_ROMAN_VALUE = 1;
    public static final int MAX_OUTPUT_ROMAN_VALUE = 3_999;

    public static final String NOT_INTEGER_EXCEPTION_HEAD_MSG = "Переданные аргументы не являются целыми числами: '";
    public static final String NOT_INTEGER_EXCEPTION_TAIL_MSG = "'.";

    public static final String IMPOSSIBLE_OPERATION_EXCEPTION_HEAD_MSG = "Передана невыполнимая/ невозможная операция: ";
    public static final String IMPOSSIBLE_OPERATION_EXCEPTION_TAIL_MSG = "'.";
}

package academy.kata.calculator.constants;


public final class MainConstants {
    public MainConstants() {
        // NOP
    }

    public static final String POSSIBLE_ROMAN_NUMERAL = "IVXLCDM";
    public static final String POSSIBLE_ARABIC_NUMERAL = "0123456789";


    public static final String INPUT_EMPTY_LINE_EXCEPTION_MSG = "\nПередана пустая строка.\n";

    public static final String INPUT_EXAMPLE_MSG = "\nПример строки для вычисления: \n\t'5 + 9'   либо   'VI / III'\n";
    public static final String INPUT_MSG = "Введите строку для вычисления/ для выхода 'q' :";
    public static final String INPUT_EXPRESSION_HEAD_MSG = "Введено выражение: '";
    public static final String INPUT_EXPRESSION_TAIL_MSG = "'";
    public static final String RESULT_MSG = "\nРезультат вычислений: ";
    public static final String EXIT_MSG = "\nОсуществлен выход из программы.\n";


//    public static final String NOT_ENOUGH_ARGUMENTS_EXCEPTION_HEAD_MSG = "Передано не верное выражение. В переданном выражении не хватает аргументов для вычисления.\n Выражение: '";
//    public static final String NOT_ENOUGH_ARGUMENTS_EXCEPTION_TAIL_MSG = "'.\n Описание ошибки: ";
    
    public static final String INTERNAL_ERROR_EXCEPTION_MSG = "Внутренняя ошибка программы, неизвестная числовая система.";

    public static final String INVALID_CHARACTERS_EXCEPTION_HEAD_MSG = "Передано некорректное выражение, присутствуют недопустимые символы: '";
    public static final String INVALID_CHARACTERS_EXCEPTION_TAIL_MSG = "'";
}

package academy.kata.calculator.inputProcessors;

import academy.kata.calculator.exepcions.CalculatorException;
import java.util.Scanner;


public class InConsoleProcessor implements InProcessor {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String get() {
        String expressions = scanner.nextLine().trim().toUpperCase();

        if (expressions.isEmpty()) {
            throw new CalculatorException("Передана пустая строка.");
        }

        return expressions;
    }
}

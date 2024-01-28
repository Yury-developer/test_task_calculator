package academy.kata.calculator.inputProcessors;

import java.util.Scanner;


public class InConsoleProcessor implements InProcessor {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String get() {

        return scanner.nextLine().trim().toUpperCase();
    }
}

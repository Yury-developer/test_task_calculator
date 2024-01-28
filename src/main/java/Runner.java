import academy.kata.calculator.exepcions.CalculatorException;
import academy.kata.calculator.inputProcessors.InConsoleProcessor;
import academy.kata.calculator.inputProcessors.InProcessor;
import academy.kata.calculator.outputProcessors.OutConsoleProcessor;
import academy.kata.calculator.outputProcessors.OutProcessor;

import static academy.kata.calculator.Main.calc;
import static academy.kata.calculator.constants.MainConstants.*;

public class Runner {

    public static void main(String[] args) {
        InProcessor input = new InConsoleProcessor();
        OutProcessor output = new OutConsoleProcessor();

        while (true) {
            output.print(INPUT_EXAMPLE_MSG, INPUT_MSG);
            String inputLine = input.get();
            output.print(INPUT_EXPRESSION_HEAD_MSG, inputLine, INPUT_EXPRESSION_TAIL_MSG);

            if (inputLine.isEmpty()) {
                throw new CalculatorException(INPUT_EMPTY_LINE_EXCEPTION_MSG);
            }

            if (inputLine.equals("q")) {
                output.print(EXIT_MSG);
                System.exit(0);   //   completion without error, by code '0'
            }

            output.print(RESULT_MSG, calc(inputLine), "\n");
        }
    }
}

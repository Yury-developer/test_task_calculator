package academy.kata.calculator.outputProcessors;

public class OutConsoleProcessor implements OutProcessor{

    @Override
    public void printResult(String res) {
        System.out.println(res);
    }
}

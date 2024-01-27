package academy.kata.calculator.outputProcessors;


public class OutConsoleProcessor implements OutProcessor{

    @Override
    public void print(String... strings) {
        for (String item: strings) {
            System.out.print(item);
        }
    }
}

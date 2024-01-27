package academy.kata.calculator;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class MainTest extends TestCase {

    @Test
    void calc() {


        System.out.println(Main.calc("5 * 9"));
        System.out.println(Main.calc("V * X"));

    }
}
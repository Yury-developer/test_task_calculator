package academy.kata.calculator.converteres;

import academy.kata.calculator.enums.RomanNumeral;
import java.util.List;


public class ArabicToRoman {

    public static String convert(int number) {
        int i = 0;
        StringBuilder builder = new StringBuilder();

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                builder.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return builder.toString();
    }
}

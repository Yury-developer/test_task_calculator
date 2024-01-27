package academy.kata.calculator.converteres;

import academy.kata.calculator.enums.RomanNumeral;
import java.util.List;


public class RomanToArabic {

    public static int convert(String input) {
        int result = 0;
        String romanNumeral = input.toUpperCase();

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        return result;
    }
}

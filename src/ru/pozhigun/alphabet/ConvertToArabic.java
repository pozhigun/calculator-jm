package ru.pozhigun.alphabet;

import java.util.Map;

public class ConvertToArabic extends Alphabet {

    public int convert(String number) {
        int result = 0;
        String check = number.toUpperCase();

        if (number.length() <= 0) return 0;

        while (check.length() != 0) {
            if (number.length() <= 2 && isNumber(check)) {
                result = result + giveNumber(check);
                check = "";
            } else if (check.length() >= 2 && isNumber(check.substring(0, 2))) {
                result = result + giveNumber(check.substring(0, 2));
                check = check.substring(2);
            } else {
                result = result + giveNumber(check.substring(0, 1));
                check = check.substring(1);
            }
        }

        return result;
    }

    private int giveNumber(String number) {
        for (Map.Entry<Integer, String> entry : getMap().entrySet()) {
            if (entry.getValue().equals(number)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    private boolean isNumber(String number) {
        return getMap().containsValue(number);
    }

}

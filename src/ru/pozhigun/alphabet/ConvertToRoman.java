package ru.pozhigun.alphabet;

public class ConvertToRoman extends Alphabet {

    public String convert(int number) {
        int l = getMap().floorKey(number);

        if (number == l) {
            return getMap().get(number);
        }

        return getMap().get(l) + convert(number - l);
    }

}

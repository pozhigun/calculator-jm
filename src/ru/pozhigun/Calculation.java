package ru.pozhigun;

import ru.pozhigun.alphabet.ConvertToArabic;
import ru.pozhigun.alphabet.ConvertToRoman;

public class Calculation {

    private final StringBuilder example = new StringBuilder();
    private String[] examples;

    private final ConvertToArabic convertArabic = new ConvertToArabic();
    private final ConvertToRoman convertRoman = new ConvertToRoman();

    public Calculation(String example) {
        convert(example.toUpperCase().replaceAll(" ", ""));
        examples = this.example.toString().split("[+/*-]");
    }

    public void calculate() {
        int firstPosition;
        int secondPosition;
        while (checkOperation()) {
            if (example.toString().contains("*") ||
                    example.toString().contains("/")) {
                firstPosition = example.toString().indexOf("*");
                secondPosition = example.toString().indexOf("/");
                if (firstPosition < secondPosition && firstPosition != -1 || secondPosition == -1) {
                    countExample('*', example.toString().indexOf("*"));
                } else {
                    countExample('/', example.toString().indexOf("/"));
                }
            } else if (example.toString().contains("+") ||
                    example.toString().contains("-")) {
                firstPosition = example.toString().indexOf("+");
                secondPosition = example.toString().indexOf("-");
                if (firstPosition < secondPosition && firstPosition != -1 || secondPosition == -1) {
                    countExample('+', example.toString().indexOf("+"));
                } else {
                    countExample('-', example.toString().indexOf("-"));
                }
            }
        }

        if (Integer.parseInt(example.toString()) <= 3999) {
            String roman = convertRoman.convert(Integer.parseInt(example.toString()));
            ConsoleHelper.writeConsole("Ваш ответ -" + "\n" + "Римские: " + roman + "\n" + "Арабские: " + example);
        } else {
            ConsoleHelper.writeConsole("Ваш ответ -" + "\n" + "Римские: " + "число должно быть не больше 3999" + "\n" + "Арабские: " + example);
        }

    }

    private void countExample(char c, int positionOperation) {
        int result = 0;
        int position = 0;
        int leftNumber = 0;
        int rightNumber = 0;
        int positionLeftNumber = 0;
        int positionRightNumber = 0;

        for (int i = 0; i < examples.length; i++) {
            position += examples[i].length() + 1;

            positionLeftNumber += examples[i].length() + 1;
            positionRightNumber = positionLeftNumber + examples[i + 1].length() + 1;

            if (position == positionOperation + 1) {
                positionLeftNumber = positionLeftNumber - examples[i].length() - 1;
                leftNumber = Integer.parseInt(examples[i]);
                rightNumber = Integer.parseInt(examples[i + 1]);

                break;
            }
        }

        if (c == '+') {
            result = leftNumber + rightNumber;
        } else if (c == '-') {
            result = leftNumber - rightNumber;
        } else if (c == '*') {
            result = leftNumber * rightNumber;
        } else if (c == '/') {
            result = leftNumber / rightNumber;
        }

        example.replace(positionLeftNumber, positionRightNumber - 1, String.valueOf(result));
        examples = this.example.toString().split("[+/*-]");
    }

    private void convert(String example) {
        char[] ch = example.toCharArray();
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '+' || ch[i] == '-' || ch[i] == '*' || ch[i] == '/' || i == ch.length - 1) {
                if (i == ch.length - 1) {
                    number.append(ch[i]);
                }

                if (convertArabic.isRoman(number.toString())) {
                    this.example.append(convertArabic.convert(number.toString()));
                } else {
                    this.example.append(number.toString());
                }
                number.setLength(0);
                if (i != ch.length - 1) {
                    this.example.append(ch[i]);
                }
            } else {
                number.append(ch[i]);
            }
        }
    }

    private boolean checkOperation() {
        return example.toString().contains("+") ||
                example.toString().contains("-") ||
                example.toString().contains("*") ||
                example.toString().contains("/");
    }

}

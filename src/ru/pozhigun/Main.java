package ru.pozhigun;

public class Main {

    public static void main(String[] args) {
        String example = "";
        while (!example.equals("exit")) {
            ConsoleHelper.writeConsole("\n---------------------------------------------------------------------");
            ConsoleHelper.writeConsole("Калькулятор умеет работать с целыми положительными римскими(3999), арабскими цифрами одновременно. " +
                    "\nА так же +,-,*,/. \nДля выхода введите exit\n");
            ConsoleHelper.writeConsole("Введите пример:");
            example = ConsoleHelper.readConsole();
            Calculation calculation = new Calculation(example);
            ConsoleHelper.writeConsole("Вы ввели: " + example);
            calculation.calculate();
        }
    }

}

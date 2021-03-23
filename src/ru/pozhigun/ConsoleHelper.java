package ru.pozhigun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static final BufferedReader consoleHelper = new BufferedReader(new InputStreamReader(System.in));

    public static void writeConsole(String message) {
        System.out.println(message);
    }

    public static String readConsole() {
        try {
            return consoleHelper.readLine();
        } catch (IOException e) {
            writeConsole("Произошла ошибка ввода числа. Попробуйте ещё раз!");
            return readConsole();
        }
    }
}

package calculator;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Calculator6 {
    public static void main(String[] args) {

        //  Ввод данных пользователя и считывание строки
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        //  Разделение строки на элементы и запись в массив
        String[] numbers = string.split(" ");

        String[] arabic = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] roman = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        //  Определение цифр
        boolean rome_a = false;
        boolean rome_b = false;
        boolean arab_a = false;
        boolean arab_b = false;
        //  Выборка оператора из массива и перевод его в char
        char c = numbers[1].charAt(0);
        //  a и b - цифры введённые пользователем
        int a = 0;
        int b = 0;
        int result;
        //  Поиск в массивах цифр, поиск "ключ-значение"
        for (int i = 1; i <= roman.length; i++) {
            if (numbers[0].equals(roman[i - 1])) {
                a = i;
                rome_a = true;
            }
            if (numbers[2].equals(roman[i - 1])) {
                b = i;
                rome_b = true;
            }
        }
        for (int i = 1; i <= arabic.length; i++) {
            if (numbers[0].equals(arabic[i - 1])) {
                a = i;
                arab_a = true;
            }
            if (numbers[2].equals(arabic[i - 1])) {
                b = i;
                arab_b = true;
            }
        }
        //  Определение типа цифр
        if (rome_a && rome_b) {
            result = operations(c, a, b);
            System.out.println(romeConverter(result));
        } else if (arab_a && arab_b) {
            System.out.println(operations(c, a, b));
        } else {
            error();
            System.out.println("Введите только арабские цифры от 1 до 10 " +
                               "или римские от I до X, включительно");
        }
    }

    public static void error() {
        System.out.print("ERROR: "); //(RED + "ERROR: " + RESET);
    }

    public static int operations(char symbol, int number1, int number2) {
        int result = 0;
        switch (symbol) {
            case '+' -> result = number1 + number2;
            case '-' -> result = number1 - number2;
            case '*' -> result = number1 * number2;
            case '/' -> result = number1 / number2;
            default -> {
                System.out.println("Калькулятор умеет выполнять операции " +
                                   "сложения, вычитания, умножения и деления с двумя числами.");
                error();
            }
        }
        return result;
    }

    public static @NotNull
    String romeConverter(int result) {

        if (result <= 0)
            return "Недопустимое значение, результат должен быть положительным. Попробуйте ещё раз";

        StringBuilder string = new StringBuilder();
        while (result == 100) {
            string = new StringBuilder("C");
            result -= 100;
        }
        while (result >= 90) {
            string.append("XC");
            result -= 90;
        }
        while (result >= 50) {
            string.append("L");
            result -= 50;
        }
        while (result >= 40) {
            string.append("XL");
            result -= 40;
        }
        while (result >= 10) {
            string.append("X");
            result -= 10;
        }
        while (result >= 9) {
            string.append("IX");
            result -= 9;
        }
        while (result >= 5) {
            string.append("V");
            result -= 5;
        }
        while (result >= 4) {
            string.append("IV");
            result -= 4;
        }
        while (result >= 1) {
            string.append("I");
            result -= 1;
        }
        return string.toString();
    }
}
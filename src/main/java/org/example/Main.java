package org.example;
import java.util.Scanner;
import static java.lang.System.exit;

public class Main {
    public static String calc(String input) throws Exception {
        int op2, res;
        String[] seq = input.split(" "); // получаем слова из строки
        if (seq.length != 3) { // если строка введена неправильно
            throw new Exception("Неправильный формат ввода!");
        }
        // получаем операнды
        try {
            res = Integer.parseInt(seq[0]);
            op2 = Integer.parseInt(seq[2]);
        }
        catch (Exception e) {
            throw new Exception("Переданы неверные операнды!");
        }
        String operator = seq[1]; // получаем оператор выражения
        // рассчитываем значение выражения
        switch (operator) {
            case "+":
                res += op2;
                break;
            case "-":
                res -= op2;
                break;
            case "*":
                res *= op2;
                break;
            case "/":
                res /= op2;
                break;
            default:
                throw new Exception("Неопознанный оператор!");
        }
        return Integer.toString(res);
    }

    public static void main(String[] args) {
        // считываем строку с последовательностью
        System.out.println("Пожалуйста, введите арифметическое выражение из двух операндов" +
                "и одного оператора, разделённых пробелами.");
        System.out.println("Пример: 1 + 2");
        Scanner sc = new Scanner(System.in);
        String inputSeq = sc.nextLine();
        sc.close();

        // рассчитываем значение выражения
        String res = null;
        try {
            res = calc(inputSeq);
        } catch (Exception e) {
            e.printStackTrace();
            exit(-1);
        }

        // выводим результат
        System.out.println(res);
    }
}
import java.util.Scanner;

import static java.lang.System.out;


public class Main {
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) throws Exception {
        out.println("Введите математическое выражение: ");
        String ex = sc.nextLine();
        String expression = ex.replaceAll(" ", "");
        String[] divided = expression.split("[*/+-]");
        String oper = detectOp(expression);
        if (oper == null) throw new Exeption("Необходимо ввести оператор");
        if (divided.length != 2) throw new Exeption("Необходимо ввести 2 операнда");
        int num1;
        int num2;
        int index;
        String result;
        if (Res.isRoman(divided[0]) && Res.isRoman(divided[1])) {
            num1 = Res.convertRomanToArabian(divided[0]);
            num2 = Res.convertRomanToArabian(divided[1]);
            if (num1 < 0 || num1 > 10 || num2 < 0 || num2 > 10) {
                throw new Exeption("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более");
            }
            index=calc(num1,num2, oper);
            if(index < 0) throw new Exeption("Результатом работы калькулятора с римскими числами могут быть только положительные числа");
            result = Res.romanResult(index);
        }
        else if (!Res.isRoman(divided[0]) && !Res.isRoman(divided[1])) {
            num1 = Res.convertArabianToArabian(divided[0]);
            num2 = Res.convertArabianToArabian(divided[1]);
            if (num1 < 0 || num1 > 10 || num2 < 0 || num2 > 10)
                throw new Exeption("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более");
            index=calc(num1,num2, oper);
            result = Integer.toString(index);
        }
        else {
            throw new Exeption("Числа должны быть в одном формате ");
        }
        out.println(result);
    }

    static String detectOp(String operator) {
        if (operator.contains("*"))
            return "*";
        else if (operator.contains("/"))
            return "/";
        else if (operator.contains("+"))
            return "+";
        else if (operator.contains("-"))
            return "-";
        else return null;
    }

    static class Res {
        static String[] resultRomanArray = new String[]{"nulla", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
                "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
                "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
                "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
                "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
                "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
                "XCVIII", "XCIX", "C"};
        static String[] romanArray = new String[]{"nulla", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        static String[] arabArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        public static boolean isRoman(String val) {
            for (String s : romanArray) {
                if (val.equals(s)) {
                    return true;
                }
            }
            return false;
        }
        public static int convertRomanToArabian(String roman) {
            for (int i = 0; i < romanArray.length; i++) {
                if (roman.equals(romanArray[i])) {
                    return i;
                }
            }
            return -1;
        }
        public static int convertArabianToArabian(String roman) {
            for (int i = 0; i < arabArray.length; i++) {
                if (roman.equals(arabArray[i])) {
                    return i;
                }
            }
            return -1;
        }
        public static String romanResult(int index) {
            return resultRomanArray[index];
        }


        }
    static int calc(int a, int b, String oper) {
        switch (oper) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            default:
                return a / b;
        }
    }
    }
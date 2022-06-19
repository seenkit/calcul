package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {
        input = input.replaceAll(" ", "");
        String[] inputToArr;
        String operator;
        if (input.contains("+")) {
            inputToArr = input.split("\\+");
            operator = "+";
        } else if (input.contains("-")) {
            inputToArr = input.split("\\-");
            operator = "-";
        } else if (input.contains("*")) {
            inputToArr = input.split("\\*");
            operator = "*";
        } else if (input.contains("/")) {
            inputToArr = input.split("\\/");
            operator = "/";
        } else {
            throw new Exception("Строка не является математической операцией");
        }
        if (inputToArr.length > 2) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        List<String> romanNumbersList = new ArrayList<>(Arrays.asList(romanNumbers));
        boolean x = romanNumbersList.contains(inputToArr[0]);
        boolean y = romanNumbersList.contains(inputToArr[1]);
        int num1;
        int num2;
        int result;
        String resultToStr;
        if (x && y == true) {
            num1 = romanToInt(inputToArr[0]);
            num2 = romanToInt(inputToArr[1]);
            result = calculate(num1, num2, operator);
            if (result <= 0) {
                throw new Exception("В системе римских цифр отсутствуют отрицательные числа и ноль");
            }
            resultToStr = convertIntToRoman(result);
        } else if (x == true && y != true || y == true && x !=true) {
            throw new Exception("используются одновременно разные системы счисления");
        } else {
            num1 = Integer.parseInt(inputToArr[0]);
            num2 = Integer.parseInt(inputToArr[1]);
            if (num1 > 10 || num1 <= 0 || num2 > 10 || num2 <= 0) {
                throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более");
            }
            result = calculate(num1, num2, operator);
            resultToStr = Integer.toString(result);
        }
        return resultToStr;
    }

    public static int calculate(int num1, int num2, String operator) {
        int result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        return result;
    }
    public static int romanToInt(String romanNum) throws Exception {
        int result;
        if (romanNum.equals("I")) {
            result = 1;
        } else if (romanNum.equals("II")) {
            result = 2;
        } else if (romanNum.equals("III")) {
            result = 3;
        } else if (romanNum.equals("IV")) {
            result = 4;
        } else if (romanNum.equals("V")) {
            result = 5;
        } else if (romanNum.equals("VI")) {
            result = 6;
        } else if (romanNum.equals("VII")) {
            result = 7;
        } else if (romanNum.equals("VIII")) {
            result = 8;
        } else if (romanNum.equals("IX")) {
            result = 9;
        } else if (romanNum.equals("X")) {
            result = 10;
        } else {
            throw new Exception("Калькулятор должен принимать на вход римские числа от 1(I) до 10(X) включительно, не более");
        }
        return result;
    }
    static String[] romanNumbers = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII",
            "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII",
            "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV",
            "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX",
            "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII",
            "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV",
            "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    public static String convertIntToRoman(int romanNumber) {
        String romanToInt = romanNumbers[romanNumber];
        return romanToInt;
    }
}

package ru.inno.course;

// Я понял, что надо было только описать алгоритм, но я не смог остановится
public class Homework4_5 {
    public static void main(String[] args) {
        String password = "qwqeqweqwy1!h";
        boolean containsDigit = false;
        boolean containsSymbol = false;
        String[] symbols = {"!", ":", "#", "$", "%", "^", "&", "*", "№"};


        if (password.length() >= 8) {
            for (char element : password.toCharArray()) {
                if (Character.isDigit(element)) {
                    containsDigit = true;
                    break;
                }
            }
            if (containsDigit == true) {
                for (char element : password.toCharArray()) {
                    for (String symbol: symbols) {
                        if (symbol.equals(String.valueOf(element))) {
                            containsSymbol = true;
                            break;
                        }
                    }
                }
                if (containsSymbol == true) {
                    System.out.println("Пароль принят");
                }
                else System.out.println("Пароль должен содержать минимум 1 спецсимвол");
            }
            else System.out.println("Пароль должен содержать минимум 1 цифру");
        }
        else System.out.println("Пароль должен быть не менее 8 символов");
    }
}

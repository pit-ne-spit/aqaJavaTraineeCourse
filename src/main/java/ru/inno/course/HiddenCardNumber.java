package ru.inno.course;

public class HiddenCardNumber {

    public static void main(String[] args) {

        // Присваиваем переменной cardNumber значение
        String cardNumber = "1234 5678 9012 3456";

        // Убираем все пробелы из строки, чтобы строка всегда была в одном виде
        cardNumber = cardNumber.replaceAll(" ", "");

        // Считаем длину строки
        int сardNumberLength = cardNumber.length();

        // Создаем строку, которая будет содержать нужное кол-во звездочек для replace
        String starsForReplace = "*".repeat(сardNumberLength - 4);

        // Заменяем первые сardNumberLength - 4 символы на звездочки
        String hiddenCardNumber = starsForReplace + cardNumber.substring(сardNumberLength - 4);

        // Наводим красоту - ставим пробелы через каждые четыре символа
        String cardNumberToShow = hiddenCardNumber.replaceAll("(.{4})", "$1 ");

        System.out.println(cardNumberToShow);

    }

}


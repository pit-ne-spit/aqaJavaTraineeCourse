package ru.inno.course;

public class MyProgram {
    public static void main(String[] args) {
        Card newCard = new Card("5588 9766 8877 1257", "2024-02-29", 654, 2685);

        System.out.println(newCard.hiddenNumber());

        System.out.println(newCard.pinCodeChecker(2685));
    }
}

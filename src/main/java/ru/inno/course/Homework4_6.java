package ru.inno.course;

public class Homework4_6 {
    public static void main(String[] args) {
        String password = "Qwerty09876542321";

        if (password.equals("Qwerty0987654321")) {
            System.out.println("Доступ разрешен");
        }
        else System.out.println("Доступ запрещен");

    }
}

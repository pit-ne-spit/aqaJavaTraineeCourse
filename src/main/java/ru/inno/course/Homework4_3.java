package ru.inno.course;

public class Homework4_3 {
    public static void main(String[] args) {
        int number = 12572;

        if (number%2 != 0) {
            if (number%3 == 0) {
                System.out.println("Нечетное число. Кратно трем");
            }
            else {
                System.out.println("Нечетное число");
            }
        }
        else {
            if (number%4 == 0) {
                System.out.println("Четное число. Кратное четырем");
            }
            else {
                System.out.println("Четное число");
            }
        }

        // Прочитал про тернарные операторы. Решил попробовать через них сделать

        String text = number%2 != 0 ?
                (number%3 == 0 ?
                        "Нечетное число. Кратно трем":
                        "Нечетное число"):
                (number%4 == 0 ?
                        "Четное число. Кратное четырем":
                        "Четное число");
        System.out.println(text);
    }
}

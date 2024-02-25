package ru.inno.course.certification;

import java.util.Scanner;

public class Love_message {
    static int messageLength = (62*5) + (12*3);
    static int fenceLength;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Укажи длину забора в сантиметрах: ");
        fenceLength = Integer.parseInt(sc.nextLine());

        if (fenceLength < messageLength) {
            System.out.println("Найди забор подлиннее, дружище!");
        }
        else System.out.println("Этот забор тебе подходит. Пиши от всего сердца.");
    }
}

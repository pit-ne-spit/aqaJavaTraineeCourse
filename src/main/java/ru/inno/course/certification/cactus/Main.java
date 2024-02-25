package ru.inno.course.certification.cactus;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cactus cactus = new Cactus(Cactus.askForDate());

        LocalDate nextWatering = cactus.nextWatering();

        System.out.println("Влажность воздуха: " + Cactus.getHumidity() + "%");
        System.out.println("Следующий полив кактуса: " + nextWatering);
    }
}

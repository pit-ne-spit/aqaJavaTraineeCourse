package ru.inno.course.certification.cactus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Cactus {

        private LocalDate lastWatering;

        public Cactus(String wateringDate) {
            this.lastWatering = LocalDate.parse(wateringDate, formatter);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        public LocalDate nextWatering() {
            LocalDate currentDate = LocalDate.now().plusMonths(3);
            int humidity = getHumidity();

            if (currentDate.getMonthValue() >= 12 || currentDate.getMonthValue() <= 2) {
                return lastWatering.plusMonths(1);
            } else if (currentDate.getMonthValue() >= 3 && currentDate.getMonthValue() <= 5) {
                return lastWatering.plusWeeks(1);
            } else if (currentDate.getMonthValue() >= 6 && currentDate.getMonthValue() <= 8) {
                if (humidity < 30) {
                    return currentDate;
                } else {
                    return lastWatering.plusDays(2);
                }
            } else {
                return lastWatering.plusWeeks(1);
            }
        }
        public static int getHumidity() {
            Random random = new Random();
            return random.nextInt(101); // Генерируем случайное число от 0 до 100
        }
        public static String askForDate() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите дату в формате дд.мм.гггг:");
            String inputDate = sc.nextLine();
            return inputDate;
        }
    }


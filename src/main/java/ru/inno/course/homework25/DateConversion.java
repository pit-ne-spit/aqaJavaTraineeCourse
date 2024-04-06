package ru.inno.course.homework25;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateConversion {
    public static String DateFormatter (String inputDateStr) {


        SimpleDateFormat inputSdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSX");
        SimpleDateFormat outputSdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        try {
            // Парсинг входной даты
            Date inputDate = inputSdf.parse(inputDateStr);

            // Установка временной зоны UTC
            inputSdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            outputSdf.setTimeZone(TimeZone.getTimeZone("UTC"));

            // Преобразование форматов
            String outputDateStr = outputSdf.format(inputDate);
            return outputDateStr;

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        return inputDateStr;
    }
}

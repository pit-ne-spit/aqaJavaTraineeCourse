package ru.inno.course;

public class Homework4_4 {
    public static void main(String[] args) {
        String url = "http://vk.com";
        String textOut = url.startsWith("https://") ?  "Соединение безопасно" : "Небезопасно. Не указывайте логины,пароли и данные банковских карт";
        System.out.println(textOut);
    }
}

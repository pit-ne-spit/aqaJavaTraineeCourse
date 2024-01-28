package ru.inno.course;

import java.util.Locale;

public class Homework1 {
    public static void main(String[] args) {

        String message = " Нога - самая важная конечность ";

        String a = message.replace("Но", "Га"); // Заменяет первый найденный фрагмент на указанный
        String b = message.toLowerCase(); // весь текст в нижнем регистре
        String c = message.toUpperCase(); // весь текст в верхнем регистре
        String d = message.concat(", и длинная"); // конкатенация к тому, что есть
        String e = message.trim(); // убирает пробелы в начале и в конце
        String f = message.format("%s - %s %s важная конечность", "Leg", "the", "most"); //
        String g = message.substring(0,5); // вырезает подстроку в указанном диапазоне
        String h = message.indent(15); // добавляет отступ
        String i = message.repeat(3); // повторяет n раз
        String j = message.replaceAll("а", "у"); // заменяет все найденные фрагменты на указанный. Использует регулярки
        String k = message.replaceFirst("Н", "Р"); //заменяет первый найденный фрагмент. в отличие от просто replace использует регулярки
        String l = message.strip(); // убирает пробелы в начале и конце, как trim()
        String m = message.stripIndent(); //убирает выравннивание
        String n = message.stripLeading(); // убирает пробелы в начале
        String o = message.stripTrailing(); // убирает пробелы в конце



        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        System.out.println(l);
        System.out.println(n);
        System.out.println(o);

    }
}

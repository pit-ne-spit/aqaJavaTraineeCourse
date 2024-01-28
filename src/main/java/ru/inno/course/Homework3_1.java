package ru.inno.course;

import org.w3c.dom.ls.LSOutput;

import java.sql.Array;

public class Homework3_1 {
    public static void main(String[] args) {
        String[] toDoList = new String[5];
        toDoList[0] = "Пресс качат";
        toDoList[1] = "Бегит";
        toDoList[2] = "Турник";
        toDoList[3] = "Анжуманя";
        toDoList[4] = "Спат";

        for (String element: toDoList) {
            System.out.println(element);

        }
    }

}

package ru.inno.course.homework9;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {

    public static void main(String[] args) {

        ArrayList<String> toDoList = new ArrayList<>();

        toDoList.add("Пресс качат");
        toDoList.add("Бегит");
        toDoList.add("Турник");
        toDoList.add("Анжуманя");
        toDoList.add("Спат");

        for (String e: toDoList
             ) {
            System.out.println(e);
        }



    }



}

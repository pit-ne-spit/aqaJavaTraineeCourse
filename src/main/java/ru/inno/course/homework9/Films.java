package ru.inno.course.homework9;

import java.util.ArrayList;
import java.util.List;

public class Films {
    public static void main(String[] args) {
        List <Movie> films = new ArrayList<>();

        films.add(new Movie("Titanic", 6, "Romantic", "USA", true));
        films.add(new Movie("Toy Story", 8, "Animation", "USA", true));
        films.add(new Movie("Gruz 200", 9, "Noire", "Russia", false));

        System.out.println(films.get(1));
    }
}

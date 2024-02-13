package ru.inno.course.homework9;

import java.util.ArrayList;
import java.util.List;

public class Filmography {
    public static void main(String[] args) {

        List<Company> companies = new ArrayList<>();

        Company universal = new Company("Universal", "1980");
        Company stv = new Company("STV", "1993");
        Company tristar = new Company("Tristar", "1990");

        companies.add(universal);
        companies.add(stv);
        companies.add(tristar);

        universal.getCompanyFilms().add(new Movie("Titanic", 6, "Romantic", "USA", true));
        universal.getCompanyFilms().add(new Movie("Friday 13th", 8, "Horror", "USA", false));
        universal.getCompanyFilms().add(new Movie("Mad Max", 9, "Adventure", "USA", false));

        stv.getCompanyFilms().add(new Movie("Brat", 7, "Noire", "Russia", false));
        stv.getCompanyFilms().add(new Movie("Broken lamps street", 5, "Criminal", "Russia", false));
        stv.getCompanyFilms().add(new Movie("The war", 8, "Adventure", "Russia", false));

        tristar.getCompanyFilms().add(new Movie("Bad boy", 3, "Comedy", "USA", false));
        tristar.getCompanyFilms().add(new Movie("Troy", 7, "Epos", "USA", true));

        for (Company e:companies
             ) {
            System.out.println(e);
        }


    }
}

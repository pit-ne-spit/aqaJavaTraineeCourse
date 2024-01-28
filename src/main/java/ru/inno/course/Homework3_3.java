package ru.inno.course;

public class Homework3_3 {
    public static void main(String[] args) {

        Movie sngMovie = new Movie("Borat", 9, "Comedy", "Kazakhstan", false);
        Movie oldSovietMovie = new Movie("Moscow Does Not Believe in Tears", 7, "Drama, Romance", "USSR", true);
        Movie hollywoodMovie = new Movie("Batman: Begins", 8, "Action", "USA", false);

        Movie[] films = {sngMovie, oldSovietMovie, hollywoodMovie};

        for (Movie element: films
             ) {
            System.out.println(element.title + " | " + element.rating + " | " + element.genre + " | " + element.country + " | " + element.isOscar);
        }

    }
}

package ru.inno.course.homework9;

public class Movie {
    String title;
    int rate;
    String genre;
    String country;
    boolean isOscar;

    public Movie(String title, int rate, String genre, String country, boolean isOscar) {
        this.title = title;
        this.rate = rate;
        this.genre = genre;
        this.country = country;
        this.isOscar = isOscar;
    }

    @Override
    public String toString() {
        return
                "Название: " + title +
                ", Рейтинг: " + rate +
                ", Жанр: " + genre +
                ", Страна: " + country +
                ", Есть Оскар: " + isOscar + ";";
    }

    public String getTitle() {
        return title;
    }
}

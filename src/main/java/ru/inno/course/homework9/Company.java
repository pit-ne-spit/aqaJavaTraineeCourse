package ru.inno.course.homework9;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Company {
    private String name;
    private String foundationYear;
    private List<Movie>companyFilms;

    public List<Movie> getCompanyFilms() {
        return companyFilms;
    }

    public Company(String name, String foundationYear) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.companyFilms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoundationYear() {
        return foundationYear;
    }

    @Override
    public String toString() {
        return "Название компании: " + name + '\'' +
                ", Год основания компании: " + foundationYear + '\'' +
                ", Список фильмов: " + companyFilms +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) && Objects.equals(foundationYear, company.foundationYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, foundationYear);
    }

    public void setFoundationYear(String foundationYear) {
        this.foundationYear = foundationYear;
    }
}

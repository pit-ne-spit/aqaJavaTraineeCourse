package ru.inno.course.homework25;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class tests_PostEmployee {
    private Cridentials cridentials;
    private Connection connection;

    @BeforeEach
    public void setUp() {
        cridentials = new Cridentials();
        try {
            connection = DriverManager.getConnection(cridentials.getUrl(), cridentials.getUser(), cridentials.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }}

    @Test
    @DisplayName("Проверяем статус код")

    public void testGetStatus() throws SQLException {
        assertEquals(201, Precondition.addEmployeesToRandomCompany(connection, 1).getStatusCode());
    }

    @Test
    @DisplayName("Проверяем факт добавления в БД пользователя с переданными параметрами")

    public void testAddEmployerToRandomCompany () throws SQLException, ParseException {

        String customEmployer = Employer.createEmployeeRequestBody(
                Precondition.testChars().get(0).firstName, Precondition.testChars().get(0).lastName, Precondition.testChars().get(0).middleName,
                Precondition.randomCompanyId(Precondition.getCompaniesId(connection)), Precondition.testChars().get(0).email,
                Precondition.testChars().get(0).avatar_url, Precondition.testChars().get(0).phone);


        int employerId = Precondition.addCustomEmployerToRandomCompany(connection, customEmployer).jsonPath().getInt("id");

        String customEmployer1 = Employer.createEmployeeRequestBody(DBmethods.getEmployerFromDbByID(connection, employerId).get(0).firstName,
                DBmethods.getEmployerFromDbByID(connection, employerId).get(0).lastName, DBmethods.getEmployerFromDbByID(connection, employerId).get(0).middleName,
                DBmethods.getEmployerFromDbByID(connection, employerId).get(0).companyId, DBmethods.getEmployerFromDbByID(connection, employerId).get(0).email,
                DBmethods.getEmployerFromDbByID(connection, employerId).get(0).avatar_url, DBmethods.getEmployerFromDbByID(connection, employerId).get(0).phone);

        assertEquals(customEmployer.toString(), customEmployer1.toString());

    }
}

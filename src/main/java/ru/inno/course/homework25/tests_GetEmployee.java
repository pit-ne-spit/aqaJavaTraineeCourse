package ru.inno.course.homework25;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;

import static junit.framework.TestCase.assertEquals;

public class tests_GetEmployee {
    private Cridentials cridentials;
    private Connection connection;
    private int companyId;
    @BeforeEach
    public void setUp() {
        cridentials = new Cridentials();
        companyId = Precondition.createCompany();
        try {
            connection = DriverManager.getConnection(cridentials.getUrl(), cridentials.getUser(), cridentials.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }}

    @AfterEach
    public void tearDown() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Нет сотрудников")
    // Тест проверяет, что на запрос сотрудников компании может вернуться ничего
    public void testNoEmployeesCompany() throws ParseException {
        // Делаем запрос к АПИ подставляя id только что созданной компании и проверяем, что возвращается пустой массив
        assertEquals("[]", APImethods.getEmployerByAPI(companyId).toString());
    }

    @Test
    @DisplayName("Один сотрудник")
    //Тест проверяет, что АПИ возвращает того же сотрудника, что лежит в БД
    public void testGetCompanyEmployee() throws SQLException, ParseException {
        // Добавляем в компанию сотрудника
        Precondition.addEmployeeToCompany(companyId);
        // Сравниваем, что в АПИ и в БД
        assertEquals(DBmethods.getEmployersByDB(connection, companyId).toString(), APImethods.getEmployerByAPI(companyId).toString());
    }


    // Проверяем, что АПИ возвращает то же кол-во сотрудников для одной компании, что лежит в БД
    @Test
    @DisplayName("Несколько сотрудников")
    //Тест проверяет, что АПИ возвращает список тех же сотрудников, что лежат в БД
    public void testGetCompanyEmployees() throws SQLException, ParseException {
        // Добавляем в компанию сотрудников
        Precondition.addEmployeesToCompany(3, companyId);
        // Сравниваем, что в АПИ и в БД
        assertEquals(DBmethods.getEmployersByDB(connection, companyId).toString(), APImethods.getEmployerByAPI(companyId).toString());

    }

    @Test
    @DisplayName("Список сотрудников рандомной компании")
    public void testGetRandomCompanyEmployeesList () throws SQLException, ParseException {
        // Добываем рандомный id компании
        companyId = DBmethods.getRandomCompanyId(connection);
        // Сравниваем, что в АПИ и в БД
        assertEquals(DBmethods.getEmployersByDB(connection, companyId).toString(), APImethods.getEmployerByAPI(companyId).toString());


    }

}

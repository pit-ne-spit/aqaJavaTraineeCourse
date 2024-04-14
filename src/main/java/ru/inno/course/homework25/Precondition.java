package ru.inno.course.homework25;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.*;

public class Precondition {

    public static String getToken() {
        Cridentials cridentials = new Cridentials();
        Response response = given()
                .body(cridentials.getApiAdminJson())
                .contentType(ContentType.JSON)
                .when()
                .post("https://x-clients-be.onrender.com/auth/login");
        JsonPath jsonPath = response.jsonPath();
        String token = jsonPath.getString("userToken");
        return token;
    }

    public static int createCompany() {
        Response response = given()
                .body("{ \"name\": " + "\"" + WordGenerator.generatedWord() + "\"" + ", \"description\": "
                        + "\"" + WordGenerator.generatedWord() + "\""
                        + "}")
                .header("x-client-token", getToken())
                .contentType(ContentType.JSON)
                .when()
                .post("https://x-clients-be.onrender.com/company");

        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.getInt("id");
        return id;
    }

    public static Response addEmployeesToRandomCompany(Connection connection, int count) throws SQLException {
        Response response = null;

        for (int i = 0; i < count; i++) {
            response = createEmployeeRequest(employerChars(randomCompanyId(getCompaniesId(connection))));
        }

        return response;
    }

    public static Response addCustomEmployerToRandomCompany (Connection connection, String requestBody) {
        Response response = null;
        response = createEmployeeRequest(requestBody);
        return response;
    }

    public static Response addEmployeesToCompany(int count, int companyId) {
        Response response = null;

        for (int i = 0; i < count; i++) {
            response = createEmployeeRequest(employerChars(companyId));
        }

        return response;
    }
    public static Response addEmployeeToCompany(int companyId) {
        Response response = createEmployeeRequest(employerChars(companyId));
        return response;
    }

    public static List<Integer> getCompaniesId(Connection connection) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(DBrequests.getOrderedCompaniesId);
        List<Integer> companiesId = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            companiesId.add(id);
        }
        return companiesId;
    }

    public static int randomCompanyId(List <Integer> companiesId) {
        Random random = new Random();
        int randomCompanyId = companiesId.get(random.nextInt(companiesId.size()));
        return randomCompanyId;
    }

    private static Response createEmployeeRequest(String requestBody) {
        return given()
                .body(requestBody)
                .header("x-client-token", getToken())
                .contentType(ContentType.JSON)
                .post("https://x-clients-be.onrender.com/employee");
    }

    public static String employerChars (int companyId) {
        String firstName = WordGenerator.generatedWord();
        String lastName = WordGenerator.generatedWord();
        String middleName = WordGenerator.generatedWord();
        String email = WordGenerator.generatedWord() + "@mail.ru";
        String url = WordGenerator.generatedWord() + ".ru";
        String phone = "+79088885914";
        String employeeRequestBody = Employer.createEmployeeRequestBody(firstName, lastName, middleName, companyId, email, url, phone);
        return employeeRequestBody;
    }

    public static List<Employer> testChars () {
        List<Employer> testChars = new ArrayList<>();
        boolean isActive = true;
        String firstName = WordGenerator.generatedWord();
        String lastName = WordGenerator.generatedWord();
        String middleName = WordGenerator.generatedWord();
        String email = WordGenerator.generatedWord() + "@mail.ru";
        String url = WordGenerator.generatedWord() + ".ru";
        String phone = "+79088885914";

        Employer employer = new Employer(isActive, firstName, lastName, middleName, phone, email, url);
        testChars.add(employer);
        return testChars;
    }
}

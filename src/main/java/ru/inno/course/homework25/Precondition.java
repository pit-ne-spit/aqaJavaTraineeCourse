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
            response = given()
                    .body("{\"firstName\":" + "\"" + WordGenerator.generatedWord() + "\","
                            + "\"lastName\":" + "\"" + WordGenerator.generatedWord() + "\","
                            + "\"middleName\":" + "\"" + WordGenerator.generatedWord() + "\","
                            + "\"companyId\":" + randomCompanyId(getCompaniesId(connection)) + ","
                            + "\"email\":" + "\"" + WordGenerator.generatedWord() + "@mail.ru\","
                            + "\"url\":" + "\"" + WordGenerator.generatedWord() + ".ru\","
                            + "\"phone\":" + "\"+79088885914\","
                            + "\"isActive\":" + true + "}")
                    .header("x-client-token", getToken())
                    .contentType(ContentType.JSON)
                    .when()
                    .post("https://x-clients-be.onrender.com/employee");
        }
        return response;
    }
    public static void addEmployeesToCompany(int count, int companyId) {

        for (int i=0; i < count; i++) {
                given()
                    .body("{\"firstName\":" + "\"" + WordGenerator.generatedWord() + "\","
                            + "\"lastName\":" + "\"" + WordGenerator.generatedWord() + "\","
                            + "\"middleName\":" + "\"" + WordGenerator.generatedWord() + "\","
                            + "\"companyId\":" + companyId + ","
                            + "\"email\":" + "\"" + WordGenerator.generatedWord() + "@mail.ru\","
                            + "\"url\":" + "\"" + WordGenerator.generatedWord() + ".ru\","
                            + "\"phone\":" + "\"+79088885914\","
                            + "\"isActive\":" + true + "}")
                    .header("x-client-token", getToken())
                    .contentType(ContentType.JSON)
                    .when()
                    .post("https://x-clients-be.onrender.com/employee");
        }
    }
    public static void addEmployeeToCompany(int companyId) {
           given()
                    .body("{\"firstName\":" + "\"" + WordGenerator.generatedWord() + "\","
                            + "\"lastName\":" + "\"" + WordGenerator.generatedWord() + "\","
                            + "\"middleName\":" + "\"" + WordGenerator.generatedWord() + "\","
                            + "\"companyId\":" + companyId + ","
                            + "\"email\":" + "\"" + WordGenerator.generatedWord() + "@mail.ru\","
                            + "\"url\":" + "\"" + WordGenerator.generatedWord() + ".ru\","
                            + "\"phone\":" + "\"+79088885914\","
                            + "\"isActive\":" + true + "}")
                    .header("x-client-token", getToken())
                    .contentType(ContentType.JSON)
                    .when()
                    .post("https://x-clients-be.onrender.com/employee");
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
}

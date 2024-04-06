package ru.inno.course.homework25;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Sandbox {

    public static void main(String[] args) throws SQLException, ParseException {
        Cridentials cridentials = new Cridentials();
        Connection connection = DriverManager.getConnection(cridentials.getUrl(), cridentials.getUser(), cridentials.getPassword());

        int companyID = APImethods.getRandomCompanyId();

        ResultSet resultSet = connection.createStatement().executeQuery(DBrequests.getEmployerByCompanyId + companyID);

        //assertEquals(APImethods.getEmployerByAPI(companyID).toString(), DBmethods.getEmployerByDB(connection, companyID).toString());

        resultSet.next();
        //System.out.println(DateConversion.DateFormatter(DBmethods.getEmployerByDB(connection, companyID)));
        System.out.println(DateConversion.DateFormatter(DBmethods.getEmployerByDB(connection, companyID).get(0).createDateTime));
        System.out.println(DateConversion.DateFormatter(APImethods.getEmployerByAPI(companyID).get(0).createDateTime).substring(0,10));

    }
}
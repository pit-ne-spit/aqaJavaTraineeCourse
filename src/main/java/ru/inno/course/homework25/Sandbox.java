package ru.inno.course.homework25;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Sandbox {

    private Cridentials cridentials;
    private Connection connection;
    private int companyID;

    @BeforeEach
    public void setUp() {
        cridentials = new Cridentials();
        try {
            connection = DriverManager.getConnection(cridentials.getUrl(), cridentials.getUser(), cridentials.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        companyID = APImethods.getRandomCompanyId();
    }

    @Test
    public void Test1() throws SQLException, ParseException {
        ResultSet resultSet = connection.createStatement().executeQuery(DBrequests.getEmployerByCompanyId + companyID);

        //assertEquals(APImethods.getEmployerByAPI(companyID).toString(), DBmethods.getEmployerByDB(connection, companyID).toString());

        //System.out.println(DateConversion.DateFormatter(DBmethods.getEmployerByDB(connection, companyID)));
        System.out.println(DateConversion.DateFormatter(DBmethods.getEmployersByDB(connection, companyID).get(0).createDateTime));
        System.out.println(DateConversion.DateFormatter(APImethods.getEmployerByAPI(companyID).get(0).createDateTime));
    }

    @Test
    public void Test2() throws SQLException, ParseException {
        System.out.println(DBmethods.getRandomCompanyId(connection));
    }
}

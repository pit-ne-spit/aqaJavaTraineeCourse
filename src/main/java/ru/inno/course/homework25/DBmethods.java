package ru.inno.course.homework25;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class DBmethods {


    public static String dateFormatter(String date) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSSX");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = sdf1.parse(date);
            return sdf2.format(date1);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Employer> getEmployersByDB(Connection connection, int companyID) throws SQLException, ParseException {
        ResultSet resultSet = connection.createStatement().executeQuery(DBrequests.getEmployerByCompanyId + companyID);
        List<Employer> dbEmployersList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            boolean isActive = resultSet.getBoolean("is_active");
            String createDateTime = dateFormatter(resultSet.getString("create_timestamp"));
            String lastChangedDateTime = dateFormatter(resultSet.getString("change_timestamp"));
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String middleName = resultSet.getString("middle_name");
            String phone = resultSet.getString("phone");
            String email = resultSet.getString("email");
            String birthdate = resultSet.getString("birthdate");
            String avatar_url = resultSet.getString("avatar_url");
            int companyId = resultSet.getInt("company_id");

            Employer employer = new Employer(id, isActive, createDateTime, lastChangedDateTime, firstName,
                    lastName, middleName, phone, email, birthdate, avatar_url, companyId);
            dbEmployersList.add(employer);
        }
        return dbEmployersList;
    }

    public static int getRandomCompanyId(Connection connection) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(DBrequests.getOrderedCompaniesId);
        List <Integer> idList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            idList.add(id);
        }
        Random random = new Random();
        int randomCompanyId = idList.get(random.nextInt(idList.size()));
        return randomCompanyId;

    }



}

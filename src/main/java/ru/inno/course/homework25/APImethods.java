package ru.inno.course.homework25;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.given;

public class APImethods {


    public static int getRandomCompanyId() {
        Response responce =  given().get("https://x-clients-be.onrender.com/company");
        JsonPath jsonPath = responce.jsonPath();
        List <Integer> idList = jsonPath.getList("id");
        Random random = new Random();
        int randomCompanyId = idList.get(random.nextInt(idList.size()));
        return randomCompanyId;
    }

    public static int getCompanyEmployersSize(Response response) {
        int employersCount = response.then().extract().path("size()");
        return employersCount;
    }

    public static String dateFormatter(String date) {
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date2 = sdf2.parse(date);
            return sdf2.format(date2);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    public static List<Employer> getEmployerByAPI(int companyID) throws ParseException {
        Response response =  given().get("https://x-clients-be.onrender.com/employee?company=" + companyID);
        List<Employer> apiEmployersList = new ArrayList<>();

        for (int i = 0; i < getCompanyEmployersSize(response); i++) {
            int id = response.body().path("id[" + i + "]");
            boolean isActive = response.body().path("isActive[" + i + "]");
            String createDateTime = dateFormatter(response.body().path("createDateTime[" + i + "]"));
            String lastChangedDateTime = dateFormatter(response.body().path("lastChangedDateTime[" + i + "]"));
            String firstName = response.body().path("firstName[" + i + "]");
            String lastName = response.body().path("lastName[" + i + "]");
            String middleName = response.body().path("middleName[" + i + "]");
            String phone = response.body().path("phone[" + i + "]");
            String email = response.body().path("email[" + i + "]");
            String birthdate = response.body().path("birthdate[" + i + "]");
            String avatar_url = response.body().path("avatar_url[" + i + "]");
            int companyId = response.body().path("companyId[" + i + "]");

            Employer employer = new Employer(id, isActive, createDateTime, lastChangedDateTime, firstName,
                    lastName, middleName, phone, email, birthdate, avatar_url, companyId);

            apiEmployersList.add(employer);
        }
        return apiEmployersList;
    }


}

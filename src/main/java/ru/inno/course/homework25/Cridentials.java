package ru.inno.course.homework25;

public class Cridentials {
    private String url = "jdbc:postgresql://dpg-cn1542en7f5s73fdrigg-a.frankfurt-postgres.render.com/x_clients_xxet";
    private String user = "x_clients_user";
    private String password = "x7ngHjC1h08a85bELNifgKmqZa8KIR40";



    private String apiAdminJson = """
            {
              "username": "leonardo",
              "password": "leads"
            }
            """;

    public String getUrl() {
        return url;
    }
    public String getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }
    public String getApiAdminJson() {
        return apiAdminJson;
    }


}

package ru.inno.course.homework25;

public class Employer {

    int id;
    boolean isActive;
    String createDateTime;
    String lastChangedDateTime;
    String firstName;
    String lastName;
    String middleName;
    String phone;
    String email;
    String birthdate;
    String avatar_url;
    int companyId;

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", isActive=" + isActive +
                ", createDateTime='" + createDateTime + '\'' +
                ", lastChangedDateTime='" + lastChangedDateTime + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", companyId=" + companyId +
                '}';
    }


    public int getId() {
        return id;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public String getLastChangedDateTime() {
        return lastChangedDateTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public int getCompanyId() {
        return companyId;
    }



    public Employer(int id, boolean isActive, String createDateTime, String lastChangedDateTime, String firstName, String lastName, String middleName, String phone, String email, String birthdate, String avatar_url, int companyId) {
        this.id = id;
        this.isActive = isActive;
        this.createDateTime = createDateTime;
        this.lastChangedDateTime = lastChangedDateTime;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phone = phone;
        this.email = email;
        this.birthdate = birthdate;
        this.avatar_url = avatar_url;
        this.companyId = companyId;
    }

    public Employer(boolean isActive, String firstName, String lastName, String middleName, String phone, String email, String url) {
        this.isActive = isActive;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phone = phone;
        this.email = email;
        this.avatar_url = url;
    }

    public static String createEmployeeRequestBody(String firstName, String lastName, String middleName, int companyId, String email, String url, String phone) {
        return "{\"firstName\":" + " \"" + firstName + "\"," +
                "\"lastName\":" + " \"" + lastName + "\"," +
                "\"middleName\":" + " \"" + middleName + "\"," +
                "\"companyId\":"  + companyId + "," +
                "\"email\":" + " \"" + email + "\"," +
                "\"url\":" + " \"" + url + "\"," +
                "\"phone\":" + " \"" + phone + "\"," +
                "\"isActive\":" + true +
                "}";
    }

}



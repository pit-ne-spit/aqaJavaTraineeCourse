package ru.inno.course.homework25;

public class DBrequests {
    public static String getEmployerByCompanyId = "select * from public.employee where company_id=";
    public static String getAllCompaniesId = "select ";

    public static String getOrderedEmployeersId = "select id from public.employee order by id desc";
    public static String getOrderedCompaniesId = "select id from public.company order by id desc";

}

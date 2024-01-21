package ru.inno.course;

public class MyProgramInternetShop {
    public static void main(String[] args) {

        Item phone = new Item("Chpocophone", "784165", "12000", 200, "black");
        Item tv = new Item("Samson", "852741", "25000", 13);
        Item table = new Item("Metta", "789456", "30000", 22, "grey");
        Item cdDisk = new Item("Mirex", "123654", "0", 0);
        Item valenok = new Item("USSR", "852963", "50", 1, "russian soul color");

        System.out.println(phone.vendorCode + " - " + phone.label + " - " + phone.price + " - " + phone.count + " - " +
                phone.color);
        System.out.println(tv.vendorCode + " - " + tv.label + " - " + tv.price + " - " + tv.count);
        System.out.println(table.vendorCode + " - " + table.label + " - " + table.price + " - " + table.count + " - " +
                table.color);
        System.out.println(cdDisk.vendorCode + " - " + cdDisk.label + " - " + cdDisk.price + " - " + cdDisk.count);
        System.out.println(valenok.vendorCode + " - " + valenok.label + " - " + valenok.price + " - " + valenok.count + " - " +
                valenok.color);

    }
}

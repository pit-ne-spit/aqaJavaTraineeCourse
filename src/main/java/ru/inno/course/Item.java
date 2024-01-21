package ru.inno.course;

public class Item {
    String label;
    String vendorCode;
    String price;
    int count;
    String color;

    public Item(String label, String vendorCode, String price, int count, String color) {
        this.label = label;
        this.vendorCode = vendorCode;
        this.price = price;
        this.count = count;
        this.color = color;
    }

    public Item(String label, String vendorCode, String price, int count) {
        this.label = label;
        this.vendorCode = vendorCode;
        this.price = price;
        this.count = count;
    }
}
